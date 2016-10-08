
<c:if test="${pageContext.request.userPrincipal.name != null}">
  <form action="/j_spring_security_logout" method="POST">
    Hi, ${pageContext.request.userPrincipal.name} <input type="submit" value="log out"/>
  </form>
  <hr>
</c:if>

<h2>Hello there</h2>
<a href="/persons">See All Persons</a>
<a href="/mentorship-programs">See All Mentorship Programs</a>