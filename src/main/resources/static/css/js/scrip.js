
function checkLogin(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let inputLogin = document.getElementById("inputLogin");
    if(username.length < 3 || username.length > 256){
        document.getElementById("warningLogin").innerText = "Tài khoản phải từ 3 - 256 ký tự";
        inputLogin.setAttribute("disabled", "disabled");
    }
    else if(password.length < 8 || password.length > 256){
        document.getElementById("warningLogin").innerText = "Mật khẩu phải từ 8 - 256 ký tự";
        inputLogin.setAttribute("disabled", "disabled");
    }
    else {
        document.getElementById("warningLogin").innerText = "";
        inputLogin.removeAttribute("disabled");
    }
}
function checkSignUp(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let name = document.getElementById("name").value;
    let inputSignUp = document.getElementById("inputSignUp");
    if(name.length < 3 || name.length > 256){
        document.getElementById("warningSignUp").innerText = "Tên phải từ 3 - 256 ký tự !!!";
        inputSignUp.setAttribute("disabled", "disabled");
    }
    else if(username.length < 3 || username.length > 256){
        document.getElementById("warningSignUp").innerText = "Tài khoản phải từ 3 - 256 ký tự !!!";
        inputSignUp.setAttribute("disabled", "disabled");
    }
    else if(password.length < 8 || password.length > 256){
        document.getElementById("warningSignUp").innerText = "Mật khẩu phải từ 8 - 256 ký tự !!!";
        inputSignUp.setAttribute("disabled", "disabled");
    }
    else if(confirmPassword.localeCompare(password)){
        document.getElementById("warningSignUp").innerText = "Mật khẩu chưa khớp !!!";
        inputSignUp.setAttribute("disabled", "disabled");
        console.log(confirmPassword);
    }
    else {
        document.getElementById("warningLogin").innerText = "";
        inputSignUp.removeAttribute("disabled");
    }
}