<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<c:forEach items="${expenses}" var="expenses">
 <li> <c:out value ="${expenses}"/></li>
   </c:forEach>

</html>
