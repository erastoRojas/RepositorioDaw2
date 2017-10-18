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
        
        String contraseña;  
        String contraseña2;
        String contraseña3;
        
        String pas1 = "1";
        String pas2 = "2";
        String pas3 = "3";
        String paginaDestino = "";
        
        contraseña = request.getParameter("pass1");
        contraseña2 = request.getParameter("pass2");
        contraseña3 = request.getParameter("pass3");
             
        if ((request.getParameter("pass1")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 1)){
                           
            if (contraseña.equals(pas1)){                
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getSession().setAttribute("nivel",2);
                response.getWriter().println("bien hecho, nivel 1 superado");
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                response.getWriter().println("mal hecho el nivel 1");
                request.getSession().setAttribute("nivel",0);
            }
        }
        
        if ((request.getParameter("pass2")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 2)){
                           
            if (contraseña2.equals(pas2)){                
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getSession().setAttribute("nivel",3);
                response.getWriter().println("bien hecho, nivel 2 superado");
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                response.getWriter().println("mal hecho el nivel 2");
                request.getSession().setAttribute("nivel",0);
            }
        }
                
        if ((request.getParameter("pass3")!= null) && ((Integer) request.getSession().getAttribute("nivel") == 3)){
                           
            if (contraseña3.equals(pas3)){                
                paginaDestino = Constantes.PAGINA_INTERMEDIO;
                request.getSession().setAttribute("nivel",4);
                response.getWriter().println("bien hecho, nivel 3 superado");
            }
            else{
                paginaDestino = Constantes.PAGINA_ERROR;
                response.getWriter().println("mal hecho el nivel 3");
                request.getSession().setAttribute("nivel",0);
            }
        }
                
        else{
           paginaDestino = Constantes.PAGINA_ERROR;
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
