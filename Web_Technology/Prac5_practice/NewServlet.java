/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    Connection connection;
    String usrname;
    String pwdword;
    String finame;
    String laname;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        
        
            
            
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fname=request.getParameter("Fname");
            String lname=request.getParameter("Lname");
            String uname=request.getParameter("Uname");
            String pword=request.getParameter("Pwd");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Apoorv's Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
// Handling checking of stored and entered into            
            try {
// Handling Ends
            out.println("</body>");
            out.println("</html>");
        
            

            // below two lines are used for connectivity.
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/conn",
                "root", "mmcoe");
            out.println("Connection successful");
            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
 
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from user_cred");
            
            while (resultSet.next()) {
                usrname = resultSet.getString(1);
                pwdword = resultSet.getString(2);
                finame = resultSet.getString(3);
                laname = resultSet.getString(4);
                
                if(fname.equals(finame) && lname.equals(laname) && uname.equals(usrname) && pword.equals(pwdword))
                {
                  
                    out.println("<h1>Your credentials are valid</h1>");
                }
                else
                {
                   out.println("<h1>Sorry, wrong credentials. Please try again</h1>");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
            
            catch (Exception exception) {
            out.println(exception);
        }  
       
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