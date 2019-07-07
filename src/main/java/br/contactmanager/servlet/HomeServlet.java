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

@WebServlet(name = "HomeServlet", urlPatterns = { "" }, loadOnStartup = 1)
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (ContactApplication application = new ContactApplication()){
            request.setAttribute("contacts", application.getContacts());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error getting contacts", e);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response); 
    }
}