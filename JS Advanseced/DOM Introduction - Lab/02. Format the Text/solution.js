function solve() {
  let input = document.getElementById('input')
  let inputArray = input.innerText.split('. ');
  let outputArea = document.getElementById('output');
  let counter = 0;
  let result = '';
  let paragraf = document.createElement('p');
  for (let i = 0; i < inputArray.length; i++) {
    counter++;
    result += inputArray[i];
    console.log(inputArray[i]);
    if (counter === 3) {

      paragraf.innerText += result;
      outputArea.appendChild(paragraf);
      counter = 0;
      result = '';
      paragraf = document.createElement('p');
    }
  }
  if (counter !== 0) {

    paragraf.innerText += result;
    outputArea.appendChild(paragraf);
  }
}