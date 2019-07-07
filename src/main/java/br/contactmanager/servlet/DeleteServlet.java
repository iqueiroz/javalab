package br.contactmanager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.contactmanager.application.ContactApplication;

@WebServlet(name = "DeleteServlet", urlPatterns = { "delete" }, loadOnStartup = 1)
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));

            try (ContactApplication application = new ContactApplication()){
                application.deleteById(id);
            } catch(Exception e) {
                e.printStackTrace();
                throw new ServletException("Error getting contact", e);
            }
    
            response.sendRedirect("");
    }

}