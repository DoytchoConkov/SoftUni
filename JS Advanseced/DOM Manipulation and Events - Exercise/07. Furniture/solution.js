function solve() {
  let buttons = document.getElementsByTagName('button');
  buttons[0].addEventListener('click', () => {
    let text = document.getElementsByTagName('textarea');
    let furniture = JSON.parse(text[0].value)
    const tableBody = document.querySelector('table tbody');
    const row = document.createElement('tr');
    const img = document.createElement('td');
    const imgLink = document.createElement('img');
    imgLink.src = furniture[0].img;
    img.appendChild(imgLink);
    row.appendChild(img);
    const name = document.createElement('td');
    const nameP = document.createElement('p');
    nameP.textContent = furniture[0].name;
    name.appendChild(nameP);
    row.appendChild(name);
    const price = document.createElement('td');
    const priceP = document.createElement('p');
    priceP.textContent = furniture[0].price;
    price.appendChild(priceP);
    row.appendChild(price);
    const factor = document.createElement('td');
    const factorP = document.createElement('p');
    factorP.textContent = furniture[0].decFactor;
    factor.appendChild(factorP);
    row.appendChild(factor);
    const checkBox = document.createElement('td');
    const checkBoxInput = document.createElement('input');
    checkBoxInput.type = 'checkbox';
    checkBox.appendChild(checkBoxInput);
    row.appendChild(checkBox);
    tableBody.appendChild(row);
    text[0].value = '';
  });

  buttons[1].addEventListener('click', () => {
    const checkBoxes = document.querySelectorAll('td input');
    console.log(checkBoxes);
    let sum = 0;
    let factor = 0;
    let cnt = 0;
    let result = [];
    for (let i = 0; i < checkBoxes.length; i++) {
      console.log(checkBoxes[i].checked);
      if (checkBoxes[i].checked === true) {
        cnt++;
        const elements = checkBoxes[i].parentNode.parentNode.getElementsByTagName('p');
        sum += Number(elements[1].textContent);
        factor += Number(elements[2].textContent);
        result.push(elements[0].textContent);
      }
    }
    document.getElementsByTagName('textarea')[1].value =
      `Bought furniture: ${result.join(', ')}\nTotal price: ${sum.toFixed(2)}\nAverage decoration factor: ${factor / cnt}`;
  })
}