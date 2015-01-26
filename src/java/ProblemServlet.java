import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "Home servlet", urlPatterns = { "/s1" })
public class ProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	ServletContext sc;
        FileCreator fc;
        Checker ch;
    @Override
    public void init()throws ServletException
    {
    	System.out.println("Logs...");
        
    	
    }
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getSession().getAttribute("usr").toString();
                
		String name = request.getParameter("name");
		String code = request.getParameter("code");
                String verdict="";
                String color="red";
                
                
                boolean isUserCase = (request.getParameter("b1").equals("yes") && !request.getParameter("usrcase").equals(""));                
                System.out.println("Usercase"+ isUserCase);
                String userCase=request.getParameter("usrcase") ;            
                String lang = request.getParameter("lang");
                String file;
                if(lang.equals("java"))
                    file="Main.java";
                else if(lang.equals("cpp"))
                    file="Main.c";
                else
                    file="Main.cpp";
                
                String cres="Error";                
		response.setContentType("text/html");
                
            try (PrintWriter p = response.getWriter()) {
                
                fc=new FileCreator(file, code,isUserCase);
                
                //if user has opted for his own case
                if(isUserCase)                
                    fc.writeUserCase(userCase);                
                fc.createFile();                
                
                System.out.println("Lang: "+lang);
                Checker ch=new Checker();
                cres = ch.compile(lang);  
                
                if(!cres.contains("Error"))
                {                    
                    if(isUserCase)
                        verdict += ("Stdout: <br>"+ch.execute(lang,"uin.txt"));
                    else
                        verdict += ("Stdout: <br>"+ch.execute(lang,"in.txt"));
                    
                    if(ch.match())
                    {
                        color="green";
                        verdict="Accepted! :D";
                    }
                    else                       
                        verdict="Wrong Answer :'(";
                     
                }
                else
                    verdict=cres;
                
                p.println("<!DOCTYPE html>\n" +
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
"			<h1 class=\"logo-right\">Verdict</h1>\n" +
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
"				  <li><a href=\"logout\"><i class=\"fa fa-comments-o fa-medium\"></i>Log out ("+user+") </a></li>\n" +
"				  <!--li><a href=\"about.html\"><i class=\"fa fa-gears fa-medium\"></i>About Us</a></li>\n" +
"				  <li><a href=\"contact.html\"><i class=\"fa fa-envelope-o fa-medium\"></i>Contact</a></li-->\n" +
"				</ul>\n" +
"			</div>\n" +
"		</div> <!-- left section -->\n" +
"		<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container\">\n" +
"			<h1 class=\"logo-right hidden-xs margin-bottom-60\">Verdict</h1>		\n" +
"			<div class=\"tm-right-inner-container\">				\n" +
"				\n" +
"				<h4 class=\"templatemo-header\"> <font color="+color+">\n" +
				verdict +
"				</font></h4>\n" +
"				</br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>\n" +
"					\n" +
"				\n" +
"\n" +
"\n" +
"				<footer>					\n" +
"					\n" +
"					<p class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 templatemo-copyright\">					\n" +
"					<h4>Designed and Developed by Rajarshee Mitra and Suman Ghosh</h4>\n" +
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

}
