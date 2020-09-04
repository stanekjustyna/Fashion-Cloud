var x = document.getElementById("forms");
var y = document.getElementById("btn");

function login() {
    x.style.marginLeft = "65vh";
    y.style.left = "0";
}

function register() {
    x.style.marginLeft = "-65vh";
    y.style.left = "auto";
    y.style.right = "0";
}
