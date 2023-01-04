package com.nidhi;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddCustomerProfile
 */
@WebServlet("/AddCustomerProfile")
@MultipartConfig(maxFileSize = 16177216)

public class AddCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String connectionURL = "jdbc:mysql://localhost:3306/itmproject";
		String user = "root";
		String pass = "#Nidhi1942";
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mob_no = request.getParameter("mob_no");
        String  imgName = request.getParameter("imgName"); 
		String address = request.getParameter("address");
			 
		int result = 0;
		Connection con = null;
		Part part = request.getPart("image");
 
		if(part != null){
			try{
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(connectionURL, user, pass);

			    PreparedStatement ps = con.prepareStatement("insert into addcustomerprofile values(?,?,?,?,?,?,?,?,?)");
			    InputStream is = part.getInputStream();
			    ps.setInt(1, id);
			    ps.setString(2, name);
			    ps.setString(3, dob);
			    ps.setString(4, gender);
			    ps.setString(5, email);
			    ps.setString(6, mob_no);
			    ps.setBlob(7, is);
			    ps.setString(8, imgName);
			    ps.setString(9, address);
			    result = ps.executeUpdate();
			    System.out.println(result);
			}
			    catch(Exception e){
				e.printStackTrace();
			}	
			finally{
				if(con != null){
					try{
						con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		if(result > 0){
	    	System.out.println("file Uploaded");
	    	response.sendRedirect("CustomerHomePage.html");
	    }
		else{
			System.out.println("Some Error Occurred");
			response.sendRedirect("AddCustomerProfile.html");
			
		}
}
	}


