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
 * @author Erasto
 */
@WebServlet(urlPatterns = {"/Session2"})
public class Session2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        String paginaDestino = "";
        
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String pass3 = request.getParameter("pass3");
             
        if ((request.getParameter("pass1")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 1)){
                           
            if (pass1.equals(Constantes.password1)){    
                request.getSession().setAttribute("nivel",2);
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                request.getSession().setAttribute("nivel",0);
            }
        }
        
        if ((request.getParameter("pass2")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 2)){
                           
            if (pass2.equals(Constantes.password2)){                
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                request.getSession().setAttribute("nivel",3);
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                request.getSession().setAttribute("nivel",0);
            }
        }
                
        if ((request.getParameter("pass3")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 3)){
                           
            if (pass3.equals(Constantes.password3)){                
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                request.getSession().setAttribute("nivel",4);
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                request.getRequestDispatcher(paginaDestino).forward(request, response);
                request.getSession().setAttribute("nivel",0);
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
