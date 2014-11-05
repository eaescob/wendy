<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="employee.form.search"/></h2>
    <c:url var="url" value="/employees/search.do"/>
	<form:form action="${url}" commandName="search" method="POST">
		    <fieldset>
		        <div class="form-row">
		        	<label for="searchString"><fmt:message key="employee.form.search" /></label>
		        	<span class="input"><form:input path="searchString" /></span>
		        </div>
		        <div class="form-buttons">
	           	 <div class="button"><input id="btnSearch" type="submit" value="<fmt:message key="button.search"/>" /></div>
	            </div>
	        </fieldset>
	</form:form>
</div>

<jsp:include page="/footer.jsp" flush="false" />