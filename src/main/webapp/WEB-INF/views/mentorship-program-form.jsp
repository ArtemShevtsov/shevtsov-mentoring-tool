<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <form action="/j_spring_security_logout" method="POST">
    Hi, ${pageContext.request.userPrincipal.name} <input type="submit" value="log out"/>
  </form>
  <hr>
</c:if>

<form:form method="post" modelAttribute="program" action="${submitAction}">
  <table>
    <tr><td colspan="2"><form:hidden path="id" /></td></tr>

    <tr>
      <td><form:label path="name" for="name">Program Name:</form:label></td>
      <td>
        <form:input path="name" type="text" />
        <div class="error"><form:errors path="name" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="location" for="location">Office Location:</form:label></td>
      <td>
        <form:select path="location" items="${locations}" />
        <div class="error"><form:errors path="location" /></div>
      </td>
    </tr>
    
    <tr>
      <td><form:label path="startDate" for="startDate">Start Date:</form:label></td>
      <td>
        <form:input path="startDate" type="date" />
        <div class="error"><form:errors path="startDate" /></div>
      </td>
    </tr>
    
    <tr>
      <td><form:label path="endDate" for="endDate">End Date:</form:label></td>
      <td>
        <form:input path="endDate" type="date" />
        <div class="error"><form:errors path="endDate" /></div>
      </td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>