<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Owner</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
     .abc
     {
            color:rgb(10, 128, 10);
            font-family: Georgia, 'Times New Roman', Times, serif;
            text-align: center;
            background-color: lightgrey;
            padding:10px;
            font-size: 50px;
            height: 100px;
     }
     
     body{
     background-image: url(Images/OwnerPage.png);
}
     
     </style>
</head>
<body>
     <h1 class="abc"><b>Online Rental House Management</b></h1> 
     
<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top" style="font-size: 22px;'">
  <ul class="navbar-nav">
  <li class="nav-item ">
      <a class="nav-link" href="ClientHomePage.html">HomePage |</a>
    </li>
   
    <li class="nav-item active">
      <a class="nav-link" href="ViewOwner.jsp">View Owner |</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="ViewCustomerPage.jsp">View Customer |</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="HomePage.html">Log Out</a>
    </li>
  </ul>
</nav>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Blob" %>
<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>


<%
    int result=0;

   String connectionURL = "jdbc:mysql://localhost:3306/itmproject";
   String user="root";
   String pass = "#Nidhi1942";
%>


<%
   Connection con =null;
   
   Class.forName("com.mysql.cj.jdbc.Driver");
   con = DriverManager.getConnection(connectionURL,user,pass);
   
   Statement stmt = con.createStatement();
   PreparedStatement ps = con.prepareStatement("select * from addprofile");
   ResultSet res = ps.executeQuery();

   while( res.next()){
	  
       %>
         
 
<table border="2" style="margin-left:200px; margin-top:30px;margin-bottom:50px; width:800px ;background-color: ivory;"> 
    <tr>
         <td style="text-align:center;"><h2><b>PROFILE PICTURE :</b></h2> <hr/> <img src="Images/<%= res.getString(8) %>"  alt="Profile Picture" height="300" width="300"/>
               <hr/> 
               <a href="#">Delete</a> 
         <td style="padding:40px;">
         <b>Id :</b>  <%= res.getString(1) %><hr/>  
         <b>Name :</b> <%= res.getString(2) %><hr/>
         <b>DOB :</b> <%= res.getString(3) %><hr/>
         <b>Gender :</b> <%= res.getString(4) %><hr/>
         <b>Email :</b> <%= res.getString(5) %><hr/>
         <b>Mobile Number :</b> <%= res.getString(6) %><hr/>
         <b>Address :</b> <%= res.getString(9) %>
         </td>
     </tr>
 </table> 
  <%
   }
  %>
    </body>
</html>