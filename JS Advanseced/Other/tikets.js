function tikets(arr, sortCriteria) {
    let tiketsArray = [];
    class Tiket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }
    const command=  {
        destination: (a, b) => a.destination.localeCompre(b.destination),
        price: (a, b) => a.price - b.price,
        status: (a, b) => a.status.localeCompre(b.status)
    }
    for (const line of arr) {
        let [destination, price, status] = line.split('|');
        tiketsArray.push(new Tiket(destination, price, status));
    }
    let sortedTckets;
    switch (sortCriteria){
        case "destination":
            sortedTckets = tiketsArray.sort((a, b) => a.destination.localeCompare(b.destination));
            break;
        case "price":
            sortedTckets = tiketsArray.sort((a, b) => a.price - b.price);
            break;
        case "status":
            sortedTckets = tiketsArray.sort((a, b) => a.status.localeCompare(b.status));
            break;
        }
    
        return sortedTckets;
}

console.log(tikets(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'destination'));