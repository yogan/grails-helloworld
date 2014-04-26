<html>
    <body>
        <h1>Taskboards</h1>
        <ul>
        <% taskboards.each { board -> %>
            <li><g:link action="show" id="${board.id}">${board.myName}</g:link></li>
        <%}%>
        </ul>
        <hr/>
        <g:link uri="/">home</g:link>
    </body>
</html>
