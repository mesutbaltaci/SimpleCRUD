<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="org.ms.entities.User" %>


<c:import url="include/header.jsp"><c:param name="title" value="List User page"></c:param>

 </c:import>

<div class="container mtb">
    <div class="row">
      <div class="col-lg-4 col-lg-offset-1">
      	<h1>List User</h1>
      	<table border="1">
      		<thead> 
      			<th> User ID </th>
      			<th> Username </th>
      			<th> Email </th>
      			<th> Operation </th>
      		</thead>
      	
      	<%! String deleteURL; %> <!-- makes it global -->
      		<%
      			List<User> listUsers = (List)request.getAttribute("listUsers");
      		String updateURL;
      		    for(int i=0; i<listUsers.size(); i++) {
      		    	out.print("<tr>");
      		    	out.print("<td>" + listUsers.get(i).getUsers_ID() +"</td>");
      		    	out.print("<td>" + listUsers.get(i).getUsername() +"</td>");
      		    	out.print("<td>" + listUsers.get(i).getEmail() +"</td>");
      		    	updateURL= request.getContextPath() + "/operation?page=updateUser"+
		      		    	"&usersID="+listUsers.get(i).getUsers_ID()+
		      		    	"&username="+listUsers.get(i).getUsername()+
		      		    	"&email="+listUsers.get(i).getEmail();
      		    	deleteURL=request.getContextPath() + "/operation?page=deleteUser"+
		      		    	"&usersID="+listUsers.get(i).getUsers_ID();
      		    	out.print("<td><a href="+updateURL+">Update</a> | ");
      		    	
      		    	
      		    	
      		  
      		
      		
      		%>
      		<a href="<%=deleteURL %>" onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a> </td>
      	</tr>
      	<%   } %>
      	
      	
      	</table>
      	
      	
      	
      </div></div></div>




<c:import url="/include/footer.jsp"></c:import>