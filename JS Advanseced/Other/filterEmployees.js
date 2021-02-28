function filterEmployees(data, criteria) {
    const employees = JSON.parse(data);
    if (criteria === 'all') {
        employees.forEach((e, i) => {
            console.log(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
        })
    } else {
        const token = criteria.split('-');
        employees.filter((e) => {
            if (e[token[0]] === token[1]) {
                return true;
            } return false;
        }).forEach((e, i) => {
            console.log(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
        })
    }
}


filterEmployees(`[{
    "id": "1",
    "first_name": "Kaylee",
    "last_name": "Johnson",
    "email": "k0@cnn.com",
    "gender": "Female"
    }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Johnson",
    "email": "kjost1@forbes.com",
    "gender": "Female"
    }, {
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
    }, {
    "id": "4",
    "first_name": "Evanne",
    "last_name": "Johnson",
    "email": "ev2@hostgator.com",
    "gender": "Male"
    }]`,
    'last_name-Johnson')