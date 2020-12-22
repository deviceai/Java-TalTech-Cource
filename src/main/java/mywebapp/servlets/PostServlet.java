package mywebapp.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import mywebapp.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    Post post;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(post);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getReader().lines()
                .collect(Collectors.joining("\n"));
        post = new ObjectMapper().readValue(input, Post.class);
        resp.setContentType("application/json");
        resp.getWriter().print(post);
    }
}
