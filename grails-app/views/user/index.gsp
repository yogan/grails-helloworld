<html>
    <body>
    <%-- FIXME: hardcoded id --%>
    <g:link action="show" id="1">${user.myName}</g:link>
    <br />

    <table>
        <tr><th>
            <g:link controller="taskboard" action="index">Taskboards</g:link>
        </th></tr>
        <% taskboards.each { taskboard -> %>
        <tr><td>
            <%-- FIXME: hardcoded id --%>
            <g:link controller="taskboard" action="show" id="1">${taskboard.myName}</g:link>
        </td></tr>
        <% } %>
    </table>

    </body>
</html>
