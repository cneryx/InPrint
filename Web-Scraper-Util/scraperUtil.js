var inputBoxes = document.querySelectorAll("input");
for (var i = 0; i < inputBoxes.length; ++i) {
    if (inputBoxes[i].type != "hidden") {
        console.log(inputBoxes[i]);
        console.log(inputBoxes[i].id);
    }
}


