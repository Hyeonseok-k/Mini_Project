
// 자동차 번호 입력시 숫자만 입력하도록 제한
function checkNum(e) {
    var keyVal = event.keyCode;
    if (keyVal === 13) {
        return true;
    } else if (((keyVal >= 48) && (keyVal <= 57))  ) {
        return true;
    } else {
        alert("No, You can write in only numbers");
        return false;
    }
}

function checklength() {
    var length = onkeyup();
}

window.onkeydown = function() {
    var kcode = event.keyCode;
    if (kcode == 116) {
        history.replaceState({}, null, location.pathname);
    }
}