package by.dmLessons.servlets.trainings.filter;

import by.dmLessons.servlets.practices.practise1Lombok.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/error")
public class UnsafeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var userDto = (UserDto) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (userDto != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/registration");
        }

    }
}
