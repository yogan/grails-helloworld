<html>
    <body>
        <h1>${task.name}</h1>
        <g:if test="${user != null}">
            <p>by <g:link controller="user" action="show" id="${user.id}">${user.name}</g:link></p>
        </g:if>
        <p><g:link action="edit" id="${task.id}">edit</g:link> |
           <g:link action="delete" id="${task.id}">delete</g:link></p>
    </body>
</html>
