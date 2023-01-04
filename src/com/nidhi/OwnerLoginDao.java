package com.nidhi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OwnerLoginDao {

	public static int save(OwnerLoginBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into ownerlogin values(?,?)");
			ps.setString(1,bean.getuname());
			ps.setString(2,bean.getpwd());
		
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static boolean authenticate(String uname,String pwd){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from ownerlogin where username=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
}
