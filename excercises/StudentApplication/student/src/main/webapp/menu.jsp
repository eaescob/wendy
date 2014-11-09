<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="navcontainer">
    <ul id="navlist">
        <li><a href="<%= request.getContextPath() %>/students/list.do"><fmt:message key="menu.student.list"/></a></li>
        <li><a id="addstudent" href="<%= request.getContextPath() %>/students/addStudent.do"><fmt:message key="menu.student.create"/></a></li>
        <li><a id="searchstudent" href="<%= request.getContextPath() %>/students/search.do"><fmt:message key="menu.student.search"/></a></li>
    </ul>
</div>
