import java.io.IOException;
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

@WebServlet(name = "Session3", urlPatterns = {"/session3"})
public class Session3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String pwd = request.getParameter("pwd");
        String paginaDestino = Constantes.PAGINA_ERROR;
           
        if ((request.getParameter("pwd")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 4)){
                           
            if (pwd.equals(Constantes.PASSWORD3)){                
                request.getSession().setAttribute("nivel",0);
                paginaDestino = Constantes.PAGINA_EXITO;
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                request.getSession().setAttribute("nivel",0);
            }
        }
        else{
           request.getRequestDispatcher(paginaDestino).forward(request, response);
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
