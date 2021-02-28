function growingWord() {
  const word = document.querySelector('#exercise >p');
  let pixelSize = 2;
  let colors = {
    "blue": "green",
    "green": "red",
    "red": "blue"
  };
  if (word.hasAttribute("style")) {
    let currentPixelSizeIntext = word.style["font-size"];
    pixelSize = currentPixelSizeIntext.substr(0, currentPixelSizeIntext.length - 2) * 2;
    let currentColor = word.style["color"];
    word.setAttribute("style", `color: ${colors[currentColor]}; font-size: ${pixelSize}px`)
  } else {
    word.setAttribute("style", `color: blue; font-size: ${pixelSize}px`);
  }
}