package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.entity.Adminlogin;
import com.entity.Bloodrequest;
import com.entity.Donor;
import com.entity.stock;

public class Promodel {
	Connection con;
	public Promodel(Connection con) {
		super();
		this.con=con;
		
	}
	public boolean request(Bloodrequest b) throws SQLException {
		boolean f=false;
		String sql="insert into bloodrequest(name,mobilenumber,email,bloodgroup,status)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,b.getName());
		ps.setString(2,b.getMobilenumber());
		ps.setString(3,b.getEmail());
		ps.setString(4,b.getBloodgroup());
		ps.setString(5,b.getStatus());
		int i=ps.executeUpdate();
		
		if(i==1) {
			System.out.println("success");
			f=true;
		
		}
		return f;
	}
	public Adminlogin checkadmin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		Adminlogin l=null;
		String sql="select * from adminlogin where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		 l=new Adminlogin();
		 l.setId(rs.getInt(1));
		 l.setUsername(rs.getString(2));
		 l.setPassword(rs.getString(3));
		 System.out.println("login");
		}else {
			System.out.println("login fail");
		}
		
		return l;
	}
	public boolean addDoner(Donor d) throws SQLException {
		// TODO Auto-generated method stub
		boolean f=false;
		String sql="insert into donor(id,name,father,mother,mobilenumber,gender,email,bloodgroup,address)values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,d.getId());
		ps.setString(2,d.getName());
		ps.setString(3,d.getFather());
		ps.setString(4,d.getMother());
		ps.setString(5,d.getMobilenumber());
		ps.setString(6,d.getGender());
		ps.setString(7,d.getEmail());
		ps.setString(8,d.getBloodgroup());
		ps.setString(9,d.getAddress());
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("doner added successfully");
			f=true;
		}
		
		return f;
	}
	
	public List<Donor> Allrecord() throws SQLException{
		List<Donor> li=new ArrayList<Donor>();
		Donor d=null;
		String sql="select * from donor";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			d=new Donor();
			d.setId(rs.getString(1));
			d.setName(rs.getString(2));
			d.setFather(rs.getString(3));
			d.setMother(rs.getString(4));
			d.setMobilenumber(rs.getString(5));
			d.setGender(rs.getString(6));
			d.setEmail(rs.getString(7));
			d.setBloodgroup(rs.getString(8));
			d.setAddress(rs.getString(9));
			li.add(d);
		}
		return li;
		
	}
	public List<Donor> updatedonor(String id) throws SQLException {
	 List<Donor> li=new ArrayList<Donor>();
		Donor d=null;
		String sql="select * from donor where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			d=new Donor();
			d.setId(rs.getString(1));
			d.setName(rs.getString(2));
			d.setFather(rs.getString(3));
			d.setMother(rs.getString(4));
			d.setMobilenumber(rs.getString(5));
			d.setGender(rs.getString(6));
			d.setEmail(rs.getString(7));
			d.setBloodgroup(rs.getString(8));
			d.setAddress(rs.getString(9));
			
			li.add(d);
		}
		
	
		return li;
		
	}
	public boolean update(Donor d) throws SQLException {
		boolean f=false;
		String sql="update donor set name=?,father=?,mother=?,mobilenumber=?,gender=?,email=?,bloodgroup=?,address=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,d.getName());
		ps.setString(2,d.getFather());
		ps.setString(3,d.getMother());
		ps.setString(4,d.getMobilenumber());
		ps.setString(5,d.getGender());
		ps.setString(6,d.getEmail());
		ps.setString(7,d.getBloodgroup());
		ps.setString(8,d.getAddress());
		ps.setString(9,d.getId());
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("updated successfully");
			f=true;
		}
		
		return f;

}
	public boolean deletedonor(String id) throws SQLException {
	   boolean f=false;
	   String sql="delete from donor where id=?";
	   PreparedStatement ps=con.prepareStatement(sql);
	   ps.setString(1, id);
	   int i=ps.executeUpdate();
	   if(i==1) {
		   System.out.println("deleted successfully");
		   f=true;
	   }
	   
		return f;
	}
	public List<stock> getstock() throws SQLException{
		List<stock> li=new ArrayList<stock>();
		stock s=null;
		String sql="select * from stock";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			s=new stock();
			s.setBloodGroup(rs.getString(1));
			s.setUnits(rs.getString(2));
			li.add(s);
		}
		return li;
		
	}
	public List<Bloodrequest> getrecord() throws SQLException {
		List<Bloodrequest> li = new ArrayList<Bloodrequest>();
		Bloodrequest b = null;
		String sql = "select * from bloodrequest where status='pending'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			b = new Bloodrequest();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setMobilenumber(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setBloodgroup(rs.getString(5));
			
			li.add(b);

		}
		return li;
}
	public boolean updaterequest(int id) throws SQLException {
		boolean f=false;
		String sql="update bloodrequest set status='completed' where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		int i=ps.executeUpdate();
		if(i==1) {
			System.out.println("updated successfully");
			f=true;
		}
		return f;
	}
	public boolean deleterequest(int id) throws SQLException {
           boolean f=false;
           String sql="delete from bloodrequest where id=?";
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setInt(1, id);
           int i=ps.executeUpdate();
           if(i==1) {
        	   System.out.println("success");
        	   f=true;
           }
		return f;
	}
	public List<Bloodrequest> completerequest() throws SQLException {
		List<Bloodrequest> li = new ArrayList<Bloodrequest>();
		Bloodrequest b = null;
		String sql = "select * from bloodrequest where status='completed'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			b = new Bloodrequest();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setMobilenumber(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setBloodgroup(rs.getString(5));
			
			li.add(b);

		}
		return li;
}
	public void increaseStock(String bloodGroup, int units) throws SQLException {
       
             PreparedStatement pst = con.prepareStatement("update stock set units=units+? where bloodgroup=?"); 
            pst.setInt(1, units);
            pst.setString(2, bloodGroup);
            pst.executeUpdate();
        }
    

    public void decreaseStock(String bloodGroup, int units) throws SQLException {
        
             PreparedStatement pst = con.prepareStatement("update stock set units=units-? where bloodgroup=?");
            pst.setInt(1, units);
            pst.setString(2, bloodGroup);
            pst.executeUpdate();
        }
    
}