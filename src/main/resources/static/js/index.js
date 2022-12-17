document.getElementById('goWrite').addEventListener('click', function (e) {
    location.href = "write";
});

var main = document.getElementById('boardMain');

$.ajax({
    url: "/list",
    data: {},
    method: "POST",
    dataType: "json"
})
.done(function (json) {
    json = json.reverse();
    attachList(json);
})
.fail(function (xhr, status, errorThrown) {
    alert("fail");
    console.log(xhr);
    console.log(status);
    console.log(errorThrown);
});

function attachList(json) {
    if (json.length < 1) {
        let tr = document.createElement('tr');
        let th = document.createElement('th');
        let a = document.createElement('a');

        th.setAttribute('style', 'text-align: center;')
        a.setAttribute('style', 'text-decoration: none; color: red');
        a.innerHTML = "등록된 글 없음";
        th.appendChild(a);

        tr.appendChild(document.createElement('td'));
        tr.appendChild(th);
        tr.appendChild(document.createElement('td'));

        main.appendChild(tr);

        return;
    }

    json.forEach(row => {
        let tr = document.createElement('tr');
        let tdSeq = document.createElement('td');
        let tdDate = document.createElement('td');
        let th = document.createElement('th');
        let a = document.createElement('a');

        tdSeq.innerText = row.seq;

        a.setAttribute('href', "/view/" + row.seq);
        a.innerText = row.title;
        th.appendChild(a)

        row.date = new Date(row.date).toLocaleString();

        tdDate.innerText = row.date;

        tr.appendChild(tdSeq);
        tr.appendChild(th);
        tr.appendChild(tdDate);

        main.appendChild(tr);
    });
}