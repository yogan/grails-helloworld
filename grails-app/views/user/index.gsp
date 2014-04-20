<html>
    <body>
    <table>
        <tr>
            <th>Login</th>
            <th>Name</th>
        </tr>
        <% users.each { user -> %>
        <tr>
            <td>
                <g:link action="show" id="${user.id}">${user.myLogin}</g:link>
            </td>
            <td>
                ${user.myName}
            </td>
        </tr>
        <% } %>
    </table>
    </body>
</html>
