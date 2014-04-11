<html>
    <body>
    <% taskboard.myColumns.each { aColumn -> %>
        <table style="float:left">
            <tr><th><%="${aColumn.value}" %></th></tr>
        <% taskboard.myTasksPerColumn[aColumn.key].each { aTask -> %>
            <tr><td><%="${aTask.myName}" %></td></tr>
        <%}%>
         </table>
   <%}%>
   </body>
</html>
