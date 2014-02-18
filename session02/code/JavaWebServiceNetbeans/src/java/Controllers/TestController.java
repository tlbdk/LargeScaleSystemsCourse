/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TestModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TroelsLiebeBentsen
 */
public class TestController extends HttpServlet {

    // Index Action
    protected void Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        // Add infomation to the model so we can pass it to the view later
        TestModel model = new TestModel();
        model.title = "Hello from Index title";
        model.stuff = "Hello from Index stuff";
        // Get stuff from database or webservice
        //model.stuff = .....
        
        // Set model object on request
        request.setAttribute("model", model);
        
        // Tell application ser to dispatch the request to the jsp page with the included model data
        RequestDispatcher view = request.getRequestDispatcher("Views/Test/Index.jsp");
        view.include(request, response);
    }

    // Home Action
    private void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestModel model = new TestModel();
        model.title = "Hello from Home title";
        model.stuff = "Hello from Home stuff";
        request.setAttribute("model", model);
        RequestDispatcher view = request.getRequestDispatcher("Views/Test/Home.jsp");
        view.include(request, response);
    }

    // 404 file not found Action
    private void Error404(HttpServletRequest request, HttpServletResponse response) {
        // Set response content type
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>404 - Action not found</h1>");
        } catch (IOException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Default to index page if do not set
        String action = (request.getParameter("do") == null) ? "" : request.getParameter("do");

        // Map parameters to actions
        switch (action) {
            case "":
            case "index":
                Index(request, response);
                break;
            case "home":
                Home(request, response);
                break;
            default:
                Error404(request, response);
                break;
        }
    }

}
