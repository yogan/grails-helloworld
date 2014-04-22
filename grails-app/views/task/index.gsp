<html>
    <body>
        <h1>Tasks</h1>
        <ul>
        <% tasks.each { task -> %>
            <li>
                <b><g:link action="show" id="${task.id}">${task.myName}</g:link></b>
                <g:if test="${task.myOwner != null}">
                    by <g:link controller="user" action="show" id="${task.myOwner.id}">${task.myOwner.myName}</g:link>
                </g:if>
            </li>
        <%}%>
        </ul>
    </body>
</html>
