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

@WebServlet(name = "Session2", urlPatterns = {"/session2"})
public class Session2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        int pwd1 = Integer.parseInt(request.getParameter("pwd1"));
        int pwd2 = Integer.parseInt(request.getParameter("pwd2"));
        int pwd3 = Integer.parseInt(request.getParameter("pwd3"));
        
        String paginaDestino = Constantes.PAGINA_ERROR;
             
        if ((request.getParameter("pwd1")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 1)){
                           
            if (Constantes.PASSWORD21 == pwd1){    
                request.getSession().setAttribute("nivel",2);
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
            }
            else{
                request.getSession().setAttribute("nivel",0);
                paginaDestino = Constantes.PAGINA_ERROR;         
            }
        }
        
        if ((request.getParameter("pwd2")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 2)){
                           
            if (Constantes.PASSWORD22 == pwd2){                
                request.getSession().setAttribute("nivel",3);
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
            }
            else{
                request.getSession().setAttribute("nivel",0);
                paginaDestino = Constantes.PAGINA_ERROR;                
            }
        }
                
        if ((request.getParameter("pwd3")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 3)){
                           
            if (Constantes.PASSWORD23 == pwd3){                
                request.getSession().setAttribute("nivel",4);
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
            }
            else{
                request.getSession().setAttribute("nivel",0);
                paginaDestino = Constantes.PAGINA_ERROR;                
            }
        }
        request.getRequestDispatcher(paginaDestino).forward(request, response);
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
