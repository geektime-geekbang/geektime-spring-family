package geektime.spring.springbucks.customer.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.util.Arrays;

public class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    private final long DEFAULT_SECONDS = 30;

    @Override
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        return Arrays.asList(response.getHeaders(HTTP.CONN_KEEP_ALIVE))
                .stream()
                .filter(h -> StringUtils.equalsIgnoreCase(h.getName(), "timeout")
                        && StringUtils.isNumeric(h.getValue()))
                .findFirst()
                .map(h -> NumberUtils.toLong(h.getValue(), DEFAULT_SECONDS))
                .orElse(DEFAULT_SECONDS) * 1000;
    }
}
