<html>
   <body>
   <table>
	<tr><th>User</th><th>Login</th></tr>
	  <% users.each { aUser -> %>
        <tr><td><%="${aUser.myName}" %></td><td><%="${aUser.myLogin}" %></td></tr>
	  <%}%>
   </table>
   
   <table>
	<tr><th>Taskboards</th></tr>
	  <% taskboards.each { taskboard -> %>
        <tr><td><%="${taskboard.myName}" %></td></tr>
	  <%}%>
   </table>
   
   </body>
</html>
