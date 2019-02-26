$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {};
    search["cityName"] = $("#cityName").val();
    var path = $(location).attr('path');
    // var cityName = $("#cityName").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        // type: "GET",
        method : "GET", type: "GET",
        // contentType: "application/json",
        url: "api/ajax/weather/" + search["cityName"],
        // // data: JSON.stringify(search),
        dataType: 'json',
        // cache: false,
        // timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}
