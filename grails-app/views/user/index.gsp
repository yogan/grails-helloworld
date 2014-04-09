<html>
   <body>
   User: <%="${user.myName}" %></br>
   
   <table>
	<tr><th>Taskboards</th></tr>
	  <% taskboards.each { taskboard -> %>
        <tr><td><%="${taskboard.myName}" %></td></tr>
	  <%}%>
   </table>
   
   </body>
</html>
