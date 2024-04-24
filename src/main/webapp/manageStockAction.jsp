<%@page import="com.connection.jdbc_conn"%>
<%@page import="java.sql.*"%>
<%
String bloodGroup=request.getParameter("bloodGroup");
System.out.println(bloodGroup);
String indec=request.getParameter("indec");
System.out.println(indec);
String units=request.getParameter("units");
System.out.println(units);
int units1=Integer.parseInt(units);
try{
	Connection con=jdbc_conn.getConnection();
	Statement st=con.createStatement();
	if(indec.equals("inc")){
		st.executeUpdate("update stock set units=units+'"+units1+"' where bloodgroup='"+bloodGroup+"'");
		
	}else{
		st.executeUpdate("update stock set units=units-'"+units1+"' where bloodgroup='"+bloodGroup+"'");
		response.sendRedirect("manageStock.jsp?msg.valid");
	}
}catch(Exception e){
response.sendRedirect("manageStock.jsp?msg.invalid");
}




%>