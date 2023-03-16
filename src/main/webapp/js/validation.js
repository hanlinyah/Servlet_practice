//檢查username
var usernameInput=document.getElementById("username");
usernameInput.onblur=checkUsername;

function checkUsername(){
    var username=usernameInput.value.trim();
    var reg=/^\w{6,12}$/;
    var flag=reg.test(username);

    if(flag){
        document.getElementById("username_err").style.display="none";
    }else {
        document.getElementById("username_err").style.display="";
    }
    return flag;
}

//檢查password
var passwordInput=document.getElementById("password");
passwordInput.onblur=checkPassword;

function checkPassword(){
    var password=passwordInput.value;
    var reg=/^[\S\s]{6,12}$/;
    var flag=reg.test(password);
    if(flag){
        document.getElementById("password_err").style.display="none";
    }else {
        document.getElementById("password_err").style.display="";
    }
    return flag;
}


//提交表單
var regFrom=document.getElementById("reg-form");
regFrom.onsubmit=submitForm;
function submitForm(){
    var flag=!!(checkUsername() * checkPassword() );
    return flag;
}