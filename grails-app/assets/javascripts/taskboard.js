//= require jquery
$(document).ready(function() {
    $("a.toggleLimit").click(function(event) {
        event.preventDefault();
        $(".columnLimit").toggle();
    });
});
