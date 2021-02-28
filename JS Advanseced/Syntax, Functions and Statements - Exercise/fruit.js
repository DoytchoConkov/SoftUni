function fruit(fruit,grams,price){
let kilos=grams/1000;
let totalPrice=kilos*price;
console.log(`I need $${totalPrice.toFixed(2)} to buy ${kilos.toFixed(2)} kilograms ${fruit}.`)
}