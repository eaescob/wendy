<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<jsp:include page="/header.jsp" flush="false" />

<div id="content">
    <h2><fmt:message key="employee.list.title"/></h2>
	<display:table name="employees" id="employee">
	    <display:column property="id" title="ID" />
	    <display:column property="firstName" title="First Name"/>
	    <display:column property="lastName" title="Last Name"/>
	    <display:column property="formattedSalary" title="Salary" />
	    <display:column title="Actions">
	        <c:url var="editUrl" value="/employees/showEmployee.do">
	            <c:param name="id" value="${employee.id}" />
	        </c:url>
	        <c:url var="deleteUrl" value="/employees/deleteEmployee.do">
	            <c:param name="id" value="${employee.id}" />
	        </c:url>
	        <a id="edit${employee.id}" href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
	        <a id="delete${employee.id}" href='<c:out value="${deleteUrl}"/>'><fmt:message key="button.delete"/></a>
	    </display:column>
	    
	</display:table>
</div>

<jsp:include page="/footer.jsp" flush="false" />