package codesstore.json;  

import javax.servlet.ServletContext.*;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

  
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/JsonServlet"})  
public class JsonServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
    private Object res;
    public int n;
  
    public JsonServlet() {  
        super();  
        n = 0;
        // TODO Auto-generated constructor stub  
    }  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
    }  
  
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) 
            throws ServletException, IOException
    {
        String id = request.getParameter("name");
        
        
        // response.sendRedirect("http://localhost:8080/BlackJack3/JsonServlet");
        PrintWriter out= response.getWriter();
        /* if( n == 0 )
        {
            out.println( "S8" );
            n++;
        }
        else if( n == 1)
        {
            out.println( "H5" );
            n++;
        }
        else if( n == 2)
        {
            out.println( "HK" );
            n=0;
        } */
        out.println( id );
      
    }     
  
} 
