function encodeAndDecodeMessages() {
    const buttons = document.getElementsByTagName('button');
    const buttonEncode = buttons[0];
    const buttonDecode = buttons[1];
    buttonEncode.addEventListener('click', (e) => {
        const button = e.target;
        const profile = button.parentNode;
        const textElement = profile.getElementsByTagName('textarea')[0];
        const text = textElement.value;
        let result = '';
        for (let i = 0; i < text.length; i++) {
            result += String.fromCharCode(text.charCodeAt(i) + 1);
        }
        textElement.value = '';
        let parentElement = profile.parentNode;
        parentElement.getElementsByTagName('textarea')[1].value = result;
      //  buttonEncode.disabled = true;
      //  textElement.disabled = true;
      //  parentElement.getElementsByTagName('textarea')[1].disabled = false;
      //  parentElement.getElementsByTagName('button')[1].disabled = false;
    })
    buttonDecode.addEventListener('click', (e) => {
        const button = e.target;
        const profile = button.parentNode;
        const textElement = profile.getElementsByTagName('textarea')[0];
        const text = textElement.value;
        let result = '';
        for (let i = 0; i < text.length; i++) {
            result += String.fromCharCode(text.charCodeAt(i) - 1);
        }
        textElement.value = result;
   //     let parentElement = profile.parentNode;
   //     buttonDecode.disabled = true;
    //    textElement.disabled = true;
    //    parentElement.getElementsByTagName('textarea')[0].disabled = false;
     //   parentElement.getElementsByTagName('button')[0].disabled = false;
    })
}