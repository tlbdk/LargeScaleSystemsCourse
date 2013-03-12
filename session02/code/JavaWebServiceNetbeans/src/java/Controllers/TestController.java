/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.HelloSOAP;
import Models.TestModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.HelloSOAP_Service;

/**
 *
 * @author TroelsLiebeBentsen
 */
public class TestController extends HttpServlet {

    protected void Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        TestModel model = new TestModel();
        model.title = "Hello from Index title";
        model.stuff = "Hello from Index stuff";
        
        HelloSOAP_Service service = new HelloSOAP_Service();
        HelloSOAP test = service.getHelloSOAPPort();
        
        model.stuff += ": " + test.hello("Webservice");

        request.setAttribute("model", model);
        RequestDispatcher view = request.getRequestDispatcher("Views/Test/Index.jsp");
        view.forward(request, response);
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
        Index(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Index(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
