<html>
    <body>
        <h1>Tasks</h1>
        <ul>
        <% tasks.each { task -> %>
            <li>
                <b><g:link action="show" id="${task.id}">${task.myName}</g:link></b>
                <g:if test="${task.myOwner != null}">
                    by ${task.myOwner.myName}
                </g:if>
            </li>
        <%}%>
        </ul>
    </body>
</html>
