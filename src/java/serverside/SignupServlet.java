package serverside;
/*
 *  
 "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. 
 And the only way to do great work is to love what you do. If you haven't found it yet, keep looking.
 Don't settle. As with all matters of the heart, you'll know when you find it."
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.Account;
import user.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author okay
 */
public class SignupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession(false);
        String content="NULL";
        if (hs != null) {
            content = "You are already logged in as " + hs.getAttribute("usr")+"</br>You may <a href =\"http://localhost:8084/cc/logout \">Logout</a> here.";
        } else {
            
            try {
                Account acc = new Account();
                String username = request.getParameter("usr");
                if(acc.userExists(username)) //check user exists or not
                {
                    content = "You are already registered!";
                }
                else { // if new user
                    String email = request.getParameter("email");
                    String password = request.getParameter("pass");
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    acc.insertUser(user);
                    hs = request.getSession();
                    hs.setAttribute("usr", username);
                    
                    content = "You have successfully created your account! </br> Your username = " + username + "</br>Your email = " + email;
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.err.println(ex);
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Signup!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Signup information!</h1>");
            out.println("</br>" + content + "</br>");
            out.println("</body>");
            out.println("</html>");
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
