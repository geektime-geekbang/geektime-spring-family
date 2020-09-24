package geektime.spring.boot.sba;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableAdminServer
public class SbaServerApplication extends WebSecurityConfigurerAdapter {
	@Autowired
	private AdminServerProperties adminServerProperties;

	public static void main(String[] args) {
		SpringApplication.run(SbaServerApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String adminContextPath = adminServerProperties.getContextPath();

		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(adminContextPath + "/");

		http.authorizeRequests()
				.antMatchers(adminContextPath + "/assets/**").permitAll()
				.antMatchers(adminContextPath + "/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
				.logout().logoutUrl(adminContextPath + "/logout").and()
				.httpBasic().and()
				.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.ignoringAntMatchers(
						adminContextPath + "/instances",
						adminContextPath + "/actuator/**"
				);
	}
}
