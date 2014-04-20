<html>
    <body>
        <h1>Taskboards</h1>
        <ul>
        <% taskboard.each { board -> %>
            <li><g:link action="show" id="${board.id}">${board.myName}</g:link></li>
        <%}%>
        </ul>
   </body>
</html>
