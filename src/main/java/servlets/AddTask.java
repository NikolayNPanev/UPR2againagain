package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Task;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tasks/add")
public class AddTask extends HttpServlet {
    private Storage storage;

    @Override
    public void init() throws ServletException {
        storage = Storage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");

        if(title!=null && !title.isEmpty()
                && description!=null && !description.isEmpty()
                && deadline!=null && !deadline.isEmpty()) {
            Task task = new Task(title, description, deadline);
            storage.addTask(task);

            writer.print("<html>" +
                    "<body>" +
                    "<h3>Successfully added task, habibi!!!</h3>" +
                    "</body>" +
                    "</html>");
            response.setStatus(201);
        }
        else{
            writer.print("<html>" +
                    "<body>" +
                    "<h3>Not enough parameters!!!</h3>" +
                    "</body>" +
                    "</html>");
            response.setStatus(400);
        }
    }
}
