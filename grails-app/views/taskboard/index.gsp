<body>
    <h1>Taskboards</h1>
    <ul>
    <% taskboards.each { board -> %>
        <li><g:link action="show" id="${board.id}">${board.name}</g:link></li>
    <%}%>
    </ul>
</body>
