package br.contactmanager.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.contactmanager.application.ContactApplication;
import br.contactmanager.model.Contact;

@WebServlet(name = "UpdateServlet", urlPatterns = {"update"}, loadOnStartup = 1) 
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (ContactApplication application = new ContactApplication()){
            request.setAttribute("contact", application.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error getting contact", e);
        }
        request.getRequestDispatcher("update.jsp").forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        try (ContactApplication application = new ContactApplication()){
            application.updateById(id, name, email, phone);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Failed creating Contact", e);
        }
        resp.sendRedirect("");
    }

}