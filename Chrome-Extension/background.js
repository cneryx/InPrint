var data = {greeting: 'hello!'};
var siteData;

fetch("http://127.0.0.1:5000/test.html", {
    headers:{
        'Content-Type': 'application/json'
    }})
    .then(function(response) {
        return response.json();
    })
    .then(function(text) {
        console.log(text);
    });

