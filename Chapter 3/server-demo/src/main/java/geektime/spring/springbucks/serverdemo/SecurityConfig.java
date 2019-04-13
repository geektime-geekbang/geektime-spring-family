//package geektime.spring.springbucks.serverdemo;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
///**
// * @Author 肖拔赟
// * @Description ${TODO}
// * @DATE Created on 2019-04-13 13:51
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        SavedRequestAwareAuthenticationSuccessHandler successHandler
//                = new SavedRequestAwareAuthenticationSuccessHandler();
//        successHandler.setTargetUrlParameter("redirectTo");
//        successHandler.setDefaultTargetUrl("/");
//
//        http.authorizeRequests()
//                .antMatchers("/assets/**").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated().and()
//                .formLogin().loginPage("/login")
//                .successHandler(successHandler).and()
//                .logout().logoutUrl("/logout").and()
//                .httpBasic().and()
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .ignoringAntMatchers(
//                        "/instances",
//                        "/actuator/**"
//                );
//    }
//}