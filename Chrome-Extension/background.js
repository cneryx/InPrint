var xhr = new XMLHttpRequest();

xhr.open("GET", "http://127.0.0.1:3000/", false);
xhr.send();

var result = xhr.responseText;