var data = {greeting: 'hello!'};
var siteData = {};
var email = "";
var password = "";
var noEmail = false;
var noPassword = false;

var host = window.location.hostname;

getServerData();
var constantLoop = setInterval(getServerData, 3000);

function getServerData() {
    fetch("http://127.0.0.1:5000/test.html", {
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            console.log(text);
            siteData = text;
            console.log(siteData)
            setTimeout(fillInputs, 1000);
        });

}

function fillInputs() {
    console.log(siteData);
    console.log(siteData.facebook);
    try {
        var spacename = host.replace("www.", "");
        email = siteData[spacename.substring(0, spacename.indexOf("."))].email;
        password = siteData[spacename.substring(0, spacename.indexOf("."))].password;
    } catch (e) {
        email = siteData.facebook.email;
        password = siteData.facebook.password;
    }
    var canStop = false;
    try {
        if (host == "github.com") {
            document.getElementById("login_field").value = email;
        } else {
            document.querySelector("input[type=\"email\"").value = email;
        }
        canStop = true;
        noEmail = false;
    } catch (e) {
        noEmail = true;
    }

    try {
        if (window.location.href == "https://github.com/") {

        } else {
            document.querySelector("input[type=\"password\"").value = password;
        }
        canStop = true;
        noPassword = false;
    } catch (e) {
        noPassword = true;
    }

    try {
        setTimeout(autoPress, 100);
        } catch (e) {

    }

    if (canStop || (noPassword && noEmail)) {
        clearInterval(constantLoop);
    }
}

function autoPress() {
    try {
        if (window.location.href == "https://github.com/login" && !noPassword) {
            document.forms[0].submit();
        }
        document.forms["login_form"].submit();
    } catch (e) {

    }
}