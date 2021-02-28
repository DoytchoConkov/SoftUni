function toggle() {
    let butonclick = document.getElementsByClassName('button')[0];
    let textStyle = document.getElementById('extra').style.display;
    if (textStyle == "" || textStyle === "none") {
        document.getElementById('extra').setAttribute("style","display: block");
        butonclick.innerHTML="Less";
    } else {
        document.getElementById('extra').setAttribute("style","display: none");
        butonclick.innerHTML="More";
    }
}