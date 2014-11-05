<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="navcontainer">
    <ul id="navlist">
        <li><a href="<%= request.getContextPath() %>/employees/list.do"><fmt:message key="menu.employee.list"/></a></li>
        <li><a id="addemployee" href="<%= request.getContextPath() %>/employees/createEmployee.do"><fmt:message key="menu.employee.create"/></a></li>
        <li><a id="searchemployee" href="<%= request.getContextPath() %>/employees/search.do"><fmt:message key="menu.employee.search"/></a></li>
    </ul>
</div>
