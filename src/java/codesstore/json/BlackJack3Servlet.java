package codesstore.json;  

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.json.JSONException;
  
import org.json.JSONObject;  
  
public class BlackJack3Servlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    public BlackJack3Servlet() {  
        super();  
        // TODO Auto-generated constructor stub  
    }  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {  
  
    }  
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {  
      
        try {
            PrintWriter out= response.getWriter();
            JSONObject json = new JSONObject();
            json.put("name", "Sameera Jayasekara");
            json.put("email", "codesstore@blogspot.com");  
            out.print(json);
        } catch (JSONException ex) {
            Logger.getLogger(BlackJack3Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }  
      
  
}  
