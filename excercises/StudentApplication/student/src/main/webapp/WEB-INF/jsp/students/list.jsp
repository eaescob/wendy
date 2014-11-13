<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="student.list.title"/></h2>

	<display:table name="students" id="student">
	    
	    <display:column property="ssn" sortable="true" title="SSN" href="/student/students/showStudent.do" paramId="ssn"/>
	    <display:column title="First Name">
	    	<c:out value="${student.firstName}"/>
	    </display:column>
	    <display:column title="Last Name">
	    	<c:out value="${student.lastName}"/>
	    </display:column>
	    <display:column title="Department">
	    	<c:out value="${student.department}"/>
	    </display:column>
	    <display:column title="Degree">
	    	<c:out value="${student.degree}"/>
	    </display:column>

	    <display:column title="GPA" href="/student/students/addGrade.do?return=list" paramId="ssn" paramProperty="ssn">
	    	<c:out value="${student.gpa}"/>
	    </display:column>
	    <display:column title="Actions" value="Delete" href="/student/students/deleteStudent.do" paramId="ssn" paramProperty="ssn"/>
	    
	</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />