
<%
session = request.getSession();
String msg = (String) session.getAttribute("message");

if (msg != null) {
%>


<div class="alert alert-warning alert-dismissible fade show"
	role="alert">
	<h4 class="text-center"><%=msg%></h4>

</div>

<%
}
%>

<%
session.removeAttribute("message");
%>


