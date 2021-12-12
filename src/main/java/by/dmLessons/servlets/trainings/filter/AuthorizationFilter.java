package by.dmLessons.servlets.trainings.filter;

import by.dmLessons.servlets.practices.practise2.dto.UserDto;
import by.dmLessons.servlets.practices.practise2.entity.Role;
import by.dmLessons.servlets.trainings.utils.UrlPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(UrlPath.LOGIN, UrlPath.REGISTRATION, UrlPath.LOCALE/*, UrlPath.INDEX*/);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) request).getRequestURI();
        if (isThisAdmin(request) || isPublicPath(uri)) {
            chain.doFilter(request, response);
        } else {
            var prevPage = ((HttpServletResponse) response).getHeader("referer");
            ((HttpServletResponse)response).sendRedirect(prevPage != null ? prevPage : UrlPath.LOGIN);
        }
    }

    private boolean isThisAdmin(ServletRequest servletRequest) {
        var user =(UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null && user.getRole().name().equals(Role.ADMIN.name());
    }
/* Эта проверка становится не нужна, если пользователь уже админ или путь общедоступный
    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }*/

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);  // path -> uri.startsWith(path)
    }
}
