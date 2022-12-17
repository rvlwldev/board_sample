function getSeq(name) {
    let url = location.search;
    let index = url.lastIndexOf(name + "=") + name.length + 1;

    return url.substring(index);
}

$.ajax({
    url: "/view",
    data: JSON.stringify({
        seq: getSeq("seq")
    }),
    method: "POST",
    dataType: "json",
    contentType: "application/json"
})
.done(function (json) {
    let title = document.getElementById('title');
    let content = document.getElementById('content');

    title.innerHTML = json.title;
    content.innerHTML = json.content;
})
.fail(function (xhr, status, errorThrown) {
    alert("fail");
    console.log(xhr);
    console.log(status);
    console.log(errorThrown);
});