<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

<form:form method="post" modelAttribute="person" action="${submitAction}">
  <table>
    <tr><td colspan="2"><form:hidden path="id" /></td></tr>

    <tr>
      <td><form:label path="firstName" for="firstName">Firs Name:</form:label></td>
      <td>
        <form:input path="firstName" type="text" />
        <div class="error"><form:errors path="firstName" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="lastName" for="lastName">Last Name:</form:label></td>
      <td>
        <form:input path="lastName" type="text" />
        <div class="error"><form:errors path="lastName" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="email" for="email">Email:</form:label></td>
      <td>
        <form:input path="email" type="email" />
        <div class="error"><form:errors path="email" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="birthDate" for="birthDate">Date of birth:</form:label></td>
      <td>
        <form:input path="birthDate" type="date" />
        <div class="error"><form:errors path="birthDate" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="managerFullName" for="managerFullName">Manager Full Name:</form:label></td>
      <td>
        <form:input path="managerFullName" type="text" />
        <div class="error"><form:errors path="managerFullName" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="primarySkill" for="primarySkill">Primary Skill:</form:label></td>
      <td>
        <form:select path="primarySkill" items="${primarySkills}" />
        <div class="error"><form:errors path="primarySkill" /></div>
      </td>
    </tr>

    <tr>
      <td><form:label path="professionalLevel" for="professionalLevel">Professional Level:</form:label></td>
      <td>
        <form:select path="professionalLevel" items="${profLevel}" />
        <div class="error"><form:errors path="professionalLevel" /></div>
      </td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>