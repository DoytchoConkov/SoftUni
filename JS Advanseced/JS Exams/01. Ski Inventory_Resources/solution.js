function solve() {
   let form = document.getElementById('add-new');
   let name = form.querySelectorAll('input')[0];
   let quantity = form.querySelectorAll('input')[1];
   let price = form.querySelectorAll('input')[2];
   let products = document.getElementById('products');
   let myProducts = document.getElementById('myProducts');
   let addBtn = form.querySelector('button');



   addBtn.addEventListener('click', e => {
      e.preventDefault();
      if (name.value === '' || quantity.value === '' || price.value === '') {
         return
      }

      let ul = products.querySelector('ul');
      let li = document.createElement('li');
      let span = document.createElement('span');
      span.textContent = name.value;
      let strong = document.createElement('strong');
      strong.textContent = `Available: ${quantity.value}`;
      let div = document.createElement('div');
      let strong2 = document.createElement('strong');
      strong2.textContent = price.value;
      let clientBtn = document.createElement('button');
      clientBtn.textContent = "Add to Client's List";
      div.appendChild(strong2);
      div.appendChild(clientBtn);
      li.appendChild(span);
      li.appendChild(strong);
      li.appendChild(div);
      ul.appendChild(li);

      clientBtn.addEventListener('click', e => {
         let clientPrice = e.target.parentNode.parentNode.querySelectorAll('strong')[1].textContent;
         let clientQuantity = e.target.parentNode.parentNode.querySelectorAll('strong')[0].textContent.slice(11);
         let productName = e.target.parentNode.parentNode.querySelector('span');
         let liClient = document.createElement('li');
         liClient.textContent = productName.textContent;
         let strongClient = document.createElement('strong');
         strongClient.textContent = clientPrice;
         liClient.appendChild(strongClient);
         let ulClient = myProducts.querySelector('ul');
         ulClient.appendChild(liClient);
         e.target.parentNode.parentNode.querySelectorAll('strong')[0].textContent = `Available: ${clientQuantity - 1}`;
         clientQuantity--;
         if (clientQuantity == 0) {
            e.target.parentNode.parentNode.remove();
         }
         let totalPriceH1 = document.querySelectorAll('h1');
         let tp = totalPriceH1[1].textContent;
         console.log(totalPriceH1);
         console.log(tp.slice(13));
         console.log(clientPrice);
         totalPriceH1[1].textContent = 'Total Price: ' + (Number(tp.slice(13)) + Number(clientPrice)).toFixed(2);
      });

      let buyBtn = myProducts.querySelector('button');
      buyBtn.addEventListener('click', e => {
         let ulCln = myProducts.querySelector('ul');
         while (ulCln.firstChild) {
            ulCln.removeChild(ulCln.firstChild);
         }
         document.querySelectorAll('h1')[1].textContent = 'Total Price: 0.00';
      });

      let filterElement = document.querySelector('.filter #filter');
      let findBtn = document.getElementsByClassName('filter')[0].querySelector('button');
      findBtn.addEventListener('click', e => {
         let productsLi = products.querySelectorAll('li');
         let ulDel = products.querySelector('ul');
         while (ulDel.firstChild) {
            ulDel.removeChild(ulDel.firstChild);
         }
         productsLi.forEach(element => {
            console.log(element.querySelector('span').textContent)
            if (element.querySelector('span').textContent.indexOf(filterElement.value)>=0) {
               element.style = 'display: none';
            } else {
               element.style = 'display: block';
            }
            products.querySelector('ul').appendChild(element);
         });
      });
   });
}