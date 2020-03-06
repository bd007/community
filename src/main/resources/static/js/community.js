function post() {
    var questionId = $("#questionId").val();
    var content = $("#content").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({"questionId": questionId, "content": content, "type": 1}),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=080c4379e9ddc9682ef2&redirect_uri=http://localhost:8888/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    } else {
                        alert(response.message);
                    }
                }
            }
        },
        dataType: "json"
    });
}