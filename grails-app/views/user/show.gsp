<html>
    <body>
        <h1>${user.myName}</h1>
        <table>
            <tr><th>
                ${user.myLogin}'s Taskboards
            </th></tr>
            <% taskboards.each { board -> %>
            <tr><td>
                <g:link controller="taskboard" action="show" id="${board.id}">${board.myName}</g:link>
            </td></tr>
            <% } %>
        </table>
        <hr/>
        <g:link uri="/">home</g:link>
    </body>
</html>
