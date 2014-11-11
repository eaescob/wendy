<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
	<h2><fmt:message key="student.form.title"/></h2>
		<c:url var="url" value="/students/addGrade.do" /> 
		<display:table name="student" id="student">
			<display:column property="firstName" title="First Name"/>
		    <display:column property="lastName" title="Last Name"/>
		    <display:column title="Add Grade">
			    <form:form action="${url}" method="POST" id="addgrade">
			    		<form:hidden path="ssn"/>
			    	    <label for="score"><fmt:message key="student.form.score"/>:</label>
			            <span class="input"><form:input name="score" /></span>
			             <div class="button"><input id="btnGrade" type="submit" value="<fmt:message key="button.addgrade"/>" /></div>
			    </form:form>
		    </display:column>
		</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />