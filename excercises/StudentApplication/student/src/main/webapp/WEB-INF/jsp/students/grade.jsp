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
		    	<form action="${url}" method="POST">
			    	<input type="hidden" name="ssn" value="${student.ssn}"/>
			    	<input type="hidden" name="returnUrl" value="${returnUrl}"/>
			    	    <label for="score"><fmt:message key="student.form.score"/>:</label>
			            <span class="input"><input type="text" name="score" length="2"/></span>
			             <div class="button"><input id="btnGrade" type="submit" value="<fmt:message key="button.addgrade"/>" /></div>
			    </form>
		    </display:column>
		</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />