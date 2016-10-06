<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Please, find below Person with ID <c:out value="${person.getId()}"/>:</h2>
<hr>
<p>
  First Name       :   <c:out value="${person.getFirstName()}"/>
</p>
<p>
  Last Name        :   <c:out value="${person.getLastName()}"/>
</p>
<p>
  Email            :   <c:out value="${person.getEmail()}"/>
</p>
<p>
  Manager          :   <c:out value="${person.getManagerFullName()}"/>
</p>
<p>
  Primary skill    :   <c:out value="${person.getPrimarySkill().toString()}"/>
</p>
<p>
  Birth day        :   <fmt:formatDate value="${p.birthDate}" pattern="dd/MM/yyyy" />
</p>
<p>
  Professional Lvl :   <c:out value="${person.getProfessionalLevel().toString()}"/>
</p>
<br>
<a href="/persons">see All</a>
<a href="/persons/${person.getId()}/edit">edit</a>