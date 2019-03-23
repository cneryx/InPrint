var data = {greeting: 'hello!'};

fetch("http://127.0.0.1:5000/test.json", {
    headers:{
        'Content-Type': 'application/json'
    }})
    .then(function(response) {
        return response.json();
    })
    .then(function(text) {
        console.log(text);
    });

