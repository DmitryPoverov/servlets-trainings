package by.dmLessons.servlets.trainings.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(value = "/error",
/*      servletNames = {"RegistrationServlet"},*/
        initParams = {@WebInitParam(name = "param1", value = "paramValue")},
        dispatcherTypes = DispatcherType.REQUEST)
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
