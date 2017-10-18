import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constantes;

/**
 *
 * @author Erasto Rojas Sánchez
 */
@WebServlet(urlPatterns = {"/Session1"})
public class Session1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String password = "1234";
        String pass;
        String paginaDestino="";
        
        pass = request.getParameter("pass");
        request.getSession().setAttribute("nivel",0);
             
        if (request.getParameter("pass")!= null && (Integer) request.getSession().getAttribute("nivel") == 0){
                           
            if (password.equals(pass)){
                request.getSession().setAttribute("nivel",1);
                paginaDestino = Constantes.PAGINA_INTERMEDIO;               
                request.getRequestDispatcher(paginaDestino).forward(request, response);
            }
            else{
                request.getSession().setAttribute("nivel",0);
                paginaDestino = Constantes.PAGINA_ERROR;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
            }
        }
        else{
           response.getWriter().println("introduce algo");
        }   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
