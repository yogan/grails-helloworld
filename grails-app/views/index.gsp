<!DOCTYPE html>
<html>
    <head>
        <title>Grails Taskboard Thingy</title>
    </head>
    <body>
        <h1>Grails Taskboard Thingy</h1>
        <g:if test='${session["user"]}'>
            Logged in with id ${session["user"]}.
            <g:link controller="user" action="logout">logout</g:link>
        </g:if>
        <g:else>
            <g:link controller="user" action="login">login</g:link>
        </g:else>
        <h2>Available controllers</h2>
        <ul>
        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
            <g:if test="${c.fullName.startsWith(grailsApplication.metadata['app.name'])}">
            <li><g:link controller="${c.logicalPropertyName}">${c.logicalPropertyName.capitalize()}</g:link></li>
            </g:if>
        </g:each>
        </ul>
    </body>
</html>
