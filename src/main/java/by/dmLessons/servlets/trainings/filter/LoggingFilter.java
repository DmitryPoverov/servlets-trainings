package by.dmLessons.servlets.trainings.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/error")
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
        chain.doFilter(request, response);
    }
}
