<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="student.list.title"/></h2>
	<display:table name="students" id="student">
	    <display:column property="ssn" title="SSN" />
	    <display:column property="firstName" title="First Name"/>
	    <display:column property="lastName" title="Last Name"/>
	    <display:column property="department" title="Department" />
	    <display:column property="degree" title="Degree" />
	    <display:column property="gpa" title="GPA" />
	    <display:column title="Actions">
	        <c:url var="editUrl" value="/students/showStudent.do">
	            <c:param name="ssn" value="${student.ssn}" />
	        </c:url>
	        <c:url var="deleteUrl" value="/students/deleteStudent.do">
	            <c:param name="ssn" value="${student.ssn}" />
	        </c:url>
	        <a id="edit${student.ssn}" href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
	        <a id="delete${student.ssn}" href='<c:out value="${deleteUrl}"/>'><fmt:message key="button.delete"/></a>
	    </display:column>
	    
	</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />