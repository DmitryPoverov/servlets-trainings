package by.dmLessons.servlets.trainings;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

//        Files.readAllBytes(Path.of("src", "main", "resources", "firstTrying.json"));
        try (var outputStream = resp.getOutputStream();
             var stream = DownloadServlet.class.getClassLoader().getResourceAsStream("firstTrying.json")) {
            outputStream.write(stream.readAllBytes());
        }
    }
}
