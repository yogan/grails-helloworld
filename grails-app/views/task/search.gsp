<head>
    <asset:javascript src="tasksearch.js"/>
</head>

<body>
    <h1>Task Search</h1>

    <g:form action="search">
        <g:textField name="taskName" value="${searchString}" autocomplete="off" />
    </g:form>

    <br/>

    <div id="results">
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
    </div>
</body>
