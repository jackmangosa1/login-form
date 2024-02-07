import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class LoginStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VALID_USERNAME = "admin";
	private static final String VALID_PASSWORD = "password";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String enteredUsername = request.getParameter("username");
	        String enteredPassword = request.getParameter("password");

	        // Check if entered credentials are valid
	        if (isValidCredentials(enteredUsername, enteredPassword)) {
	            // Create a session and redirect to the admission form
	            HttpSession session = request.getSession();
	            session.setAttribute("username", enteredUsername);
	            response.sendRedirect("/StudentAdmissionForm/index.html");
	            
	        } else {
	            // Display an error message if credentials are invalid
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Login Error</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<p style=\"color: red; text-align: center;\">Invalid username or password. Please try again.</p>");
	            out.println("</body>");
	            out.println("</html>");
	        }
	        
	      
	}
	
	  private boolean isValidCredentials(String username, String password) {
          return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
      }

}