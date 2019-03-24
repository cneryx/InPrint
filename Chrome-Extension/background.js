var data = {greeting: 'hello!'};
var siteData = {};
var email = "";
var password = "";

fetch("http://127.0.0.1:5000/test.html", {
    headers:{
        'Content-Type': 'application/json'
    }})
    .then(function(response) {
        return response.json();
    })
    .then(function(text) {
        console.log(text);
        siteData = text;
        console.log(siteData)
        setTimeout(killme, 1000);
    });

function killme() {
    console.log(siteData);
    console.log(siteData.facebook);
    email = siteData.facebook.email;
    password = siteData.facebook.password;

    document.getElementById("email").value = email;
    document.getElementById("pass").value = password;
}