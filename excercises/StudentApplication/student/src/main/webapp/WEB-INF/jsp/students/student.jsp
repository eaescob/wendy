<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="student.form.title"/></h2>

	<c:url var="url" value="/students/addStudent.do" /> 
	<form:form action="${url}" commandName="student" method="POST">
	
	    <fieldset>
	    	<div class="form-row">
	    		<label for="ssn"><fmt:message key="student.form.ssn" /></label>
	    		<span class="input"><form:input path="ssn"/></span>
	    	</div>
	        <div class="form-row">
	        	<label for="firstName"><fmt:message key="student.form.firstName" /></label>
	        	<span class="input"><form:input path="firstName" /></span>
	        </div>
	        
	        <div class="form-row">
	        	<label for="lastName"><fmt:message key="student.form.lastName" /></label>
	        	<span class="input"><form:input path="lastName" /></span>
	        </div>
	        <div class="form-row">
	            <label for="address1"><fmt:message key="student.form.addr1"/>:</label>
	            <span class="input"><form:input path="address1" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="address2"><fmt:message key="student.form.addr2"/>:</label>
	        	<span class="input"><form:input path="address2" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="city"><fmt:message key="student.form.city"/>:</label>
	        	<span class="input"><form:input path="city" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="state"><fmt:message key="student.form.state"/>:</label>
	        	<span class="input"><form:input path="state" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="country"><fmt:message key="student.form.country"/>:</label>
	        	<span class="input"><form:input path="country" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="department"><fmt:message key="student.form.department"/>:</label>
	        	<span class="input"><form:input path="department" /></span>
	        </div>
	        <div class="form-row">
	        	<label for="degree"><fmt:message key="student.form.degree"/>:</label>
	        	<span class="input"><form:input path="degree" /></span>
	        </div>
	        
	        <div class="form-buttons">
	        	<c:url var="url" value="/students/addGrade.do">
	        		<c:param name="ssn" value="${student.ssn}"/>
	        	</c:url>
	        	
	        	<a id="addgrade" href='<c:out value="${url}"/>'><fmt:message key="button.addgrade"/></a>
	        </div>
	        <div class="form-buttons">
	            <div class="button"><input id="btnSave" type="submit" value="<fmt:message key="button.save"/>" /></div>
	        </div>
	    </fieldset>
	</form:form>
</div>

<jsp:include page="/footer.jsp" flush="false" />