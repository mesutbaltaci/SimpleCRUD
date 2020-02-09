<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ms.entities.User" %>


<c:import url="include/header.jsp"><c:param name="title" value="List User page"></c:param>

 </c:import>

<div class="container mtb">
    <div class="row">
      <div class="col-lg-4 col-lg-offset-1">
      	<h1>Update User</h1>
      	
      		<form action="${pageContext.request.contextPath}/operation" method="post">
      			Username: <input type="text"  name="username" value="${param.username}" required /> <br/>
      			email:    <input type="email" name="email"    value="${param.email}" required /> <br/>
      			<input type="submit" value="Update User" > 
      			<input type="hidden" name="form" value="updateuseroperation"/>
      			<input type="hidden" name="userID" value="${param.usersID}"/>
      		</form>
      	
      	
      	
      	
      	
      	
      	
      	
      </div></div></div>




<c:import url="/include/footer.jsp"></c:import>