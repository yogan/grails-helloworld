<h1>Task Search</h1>

<g:form action="search">
    <g:textField name="taskName" value="${searchString}"/>
</g:form>

<br/>

<g:if test="${matches.size == 0}">
    <g:if test="${searchString != null && searchString.length() > 0}">
        <p>No results found.</p>
    </g:if>
</g:if>
<g:else>
    <ul>
    <% matches.each { task -> %>
        <li>
            <g:link action="show" id="${task.id}">${task.name}</g:link>
        </li>
    <%}%>
    </ul>
</g:else>
