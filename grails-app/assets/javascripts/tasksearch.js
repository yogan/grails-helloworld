//= require jquery
$(document).ready(function() {
    $("#taskName").keyup(function() {
        var searchString = $(this).val();
        if(searchString && searchString.length > 0) {
            $.getJSON("/helloworld/task/search.json", {q:searchString},
                function(data) {
                    var items = [];
                    $.each(data, function(key, val) {
                        items.push('<li><a href="/helloworld/task/show/'+val.id+'">'
                                   + val.name + "</a></li>");
                    });

                    if (items.length > 0) {
                        $("#results").html("<ul>"+items.join("")+"</ul>");
                    } else {
                        $("#results").html("<p>No results found.</p>");
                    }
                });
        } else {
            $("#results").html("");
        }
    });
});
