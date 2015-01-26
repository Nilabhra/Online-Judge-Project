/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rajarshee
 */
public class StartServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession hs = request.getSession();
        String user=request.getParameter("usr");
        hs.setAttribute("usr", user);
        System.out.println("SESSION ID "+hs.getId());
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>\n" +
"<head>\n" +
"	<!-- templatemo 419 black white -->\n" +
"    <!-- \n" +
"    Black White\n" +
"    http://www.templatemo.com/preview/templatemo_419_black_white\n" +
"    -->\n" +
"	<title>Online Code Checker</title>\n" +
"	<meta name=\"keywords\" content=\"\" />\n" +
"	<meta name=\"description\" content=\"\" />\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<link href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,400,700\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"css/templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\">	\n" +
"</head>\n" +
"<body>\n" +
"	<div class=\"templatemo-logo visible-xs-block\">\n" +
"		<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg logo-left-container\">\n" +
"			<h1 class=\"logo-left\">Tab</h1>\n" +
"		</div>\n" +
"		<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg logo-right-container\">\n" +
"			<h1 class=\"logo-right\">Challenges</h1>\n" +
"		</div>			\n" +
"	</div>\n" +
"	<div class=\"templatemo-container\">\n" +
"		<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container\">\n" +
"			<h1 class=\"logo-left hidden-xs margin-bottom-60\">Tab</h1>			\n" +
"			<div class=\"tm-left-inner-container\">\n" +
"				<ul class=\"nav nav-stacked templatemo-nav\">\n" +
"				  <li><a href=\"index.html\" class=\"active\"><i class=\"fa fa-home fa-medium\"></i>Homepage</a></li>\n" +
"				  <li><a href=\"#\"><i class=\"fa fa-shopping-cart fa-medium\"></i>LeaderShip board</a></li>\n" +
"				  <li><a href=\"#\"><i class=\"fa fa-send-o fa-medium\"></i>Score Card</a></li>\n" +
"				  <li><a href=\"logout\"><i class=\"fa fa-comments-o fa-medium\"></i>Log out ("+hs.getAttribute("usr")+") </a></li>\n" +
"				  <!--li><a href=\"about.html\"><i class=\"fa fa-gears fa-medium\"></i>About Us</a></li>\n" +
"				  <li><a href=\"contact.html\"><i class=\"fa fa-envelope-o fa-medium\"></i>Contact</a></li-->\n" +
"				</ul>\n" +
"			</div>\n" +
"		</div> <!-- left section -->\n" +
"		<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container\">\n" +
"			<h1 class=\"logo-right hidden-xs margin-bottom-60\">Challenges</h1>		\n" +
"			<div class=\"tm-right-inner-container\">\n" +
"				<h1 class=\"templatemo-header\">Easy</h1>\n" +
"				<!--img src=\"images/wooden-desk.jpg\" alt=\"Wooden Desk\" class=\"img-thumbnail\"-->\n" +
"				\n" +
"				<h4>\n" +
"				<a href =\"p1.html\">Write a program to add two numbers.</a>\n" +
"				</h4>\n" +
"				</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>\n" +
"					\n" +
"				\n" +
"\n" +
"\n" +
"				<footer>					\n" +
"					\n" +
"					<p class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 templatemo-copyright\">					\n" +
"					\n" +
"					Netaji Subhash Engineering College, Kolkata</p> </br></br></br>\n" +
"					\n" +
"					<p class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social\">\n" +
"						<a href=\"#\"><i class=\"fa fa-facebook fa-medium\"></i></a>\n" +
"						<a href=\"#\"><i class=\"fa fa-twitter fa-medium\"></i></a>\n" +
"						<a href=\"#\"><i class=\"fa fa-google-plus fa-medium\"></i></a>\n" +
"						<a href=\"#\"><i class=\"fa fa-youtube fa-medium\"></i></a>\n" +
"						<a href=\"#\"><i class=\"fa fa-linkedin fa-medium\"></i></a>\n" +
"					</p>\n" +
"				</footer>\n" +
"			</div>	\n" +
"		</div> <!-- right section -->\n" +
"	</div>	\n" +
"</body>\n" +
"</html>");
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
