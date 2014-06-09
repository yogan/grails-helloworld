<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <asset:stylesheet src="application.css"/>

        <title><g:layoutTitle default="Grails Taskboard Demo" /></title>

        <g:layoutHead/>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="${g.createLink(uri:'/')}">Grails Taskboard</a>
            </div>
            <div class="collapse navbar-collapse">
              <ul class="nav navbar-nav">
                %{-- TODO: use a custom taglib for this - DRY! --}%
                <g:if test="${controllerName == 'task'}"><li class="active"></g:if>
                <g:else><li></g:else>
                    <g:link controller="task">Tasks</g:link>
                </li>
                <g:if test="${controllerName == 'taskboard'}"><li class="active"></g:if>
                <g:else><li></g:else>
                    <g:link controller="taskboard">Taskboards</g:link>
                </li>
                <g:if test="${controllerName == 'user'}"><li class="active"></g:if>
                <g:else><li></g:else>
                    <g:link controller="user">User</g:link>
                </li>
                <g:if test="${controllerName == 'admin'}"><li class="active"></g:if>
                <g:else><li></g:else>
                    <g:link controller="admin">Admin</g:link>
                </li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </div>

        <div class="container">
            <div class="starter-template">
                <g:layoutBody/>
            </div>
        </div><!-- /.container -->

        <asset:javascript src="application.js"/>
    </body>
</html>
