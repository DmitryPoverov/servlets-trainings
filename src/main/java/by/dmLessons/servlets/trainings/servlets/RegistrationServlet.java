package by.dmLessons.servlets.trainings.servlets;

import by.dmLessons.servlets.practices.practise2.dto.CreateUserDto;
import by.dmLessons.servlets.practices.practise2.entity.Gender;
import by.dmLessons.servlets.practices.practise2.entity.Role;
import by.dmLessons.servlets.practices.practise2.exception.ValidationException;
import by.dmLessons.servlets.practices.practise2.sevice.UserService;
import by.dmLessons.servlets.trainings.utils.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@MultipartConfig(fileSizeThreshold = 1024 * 1024)
@WebServlet(value = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher(JspHelper.getPath("registration"))
                        .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Закомментированный код - для передачи файла в запросе
//        Part image = req.getPart("image");
//        image.
        CreateUserDto userDto = CreateUserDto.builder()
                .name(req.getParameter("userName"))
                .birthday(req.getParameter("birthDay"))
                .email(req.getParameter("eMail"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();
        try {
            userService.create(userDto);
            resp.sendRedirect("/login");
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }
    }
}
