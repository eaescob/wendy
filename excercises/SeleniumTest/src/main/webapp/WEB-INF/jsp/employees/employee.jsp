<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="employee.form.title"/></h2>

	<c:url var="url" value="/employees/addEmployee.do" /> 
	<form:form action="${url}" commandName="employee" method="POST">
	    <form:hidden path="id" />
	
	    <fieldset>
	        <div class="form-row">
	        	<label for="firstName"><fmt:message key="employee.form.firstName" /></label>
	        	<span class="input"><form:input path="firstName" /></span>
	        </div>
	        
	        <div class="form-row">
	        	<label for="lastName"><fmt:message key="employee.form.lastName" /></label>
	        	<span class="input"><form:input path="lastName" /></span>
	        </div>
	        <div class="form-row">
	            <label for="salary"><fmt:message key="employee.form.salary"/>:</label>
	            <span class="input"><form:input path="salary" /></span>
	        </div>
	        <div class="form-buttons">
	            <div class="button"><input id="btnSave" type="submit" value="<fmt:message key="button.save"/>" /></div>
	        </div>
	    </fieldset>
	</form:form>
</div>

<jsp:include page="/footer.jsp" flush="false" />