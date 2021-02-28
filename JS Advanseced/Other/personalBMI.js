function personalBMI(name, age, weight, height) {
    let bmi = weight / height ** 2 * 10000;
    let bmiStatus = '';
    if (bmi >= 30) {
        bmiStatus = 'obese';
        return {
            name: name,
            personalInfo: {
                age: Math.round(age),
                weight: Math.round(weight),
                height: Math.round(height)
            },
            BMI: Math.round(bmi),
            status: bmiStatus,
            recommendation: 'admission required'
        }
    } else if (bmi >= 25) {
        bmiStatus = 'overweight';
    } else if (bmi > 18.5) {
        bmiStatus = 'normal';
    } else {
        bmiStatus = 'underweight';
    }
    return {
        name: name,
        personalInfo: {
            age: Math.round(age),
            weight: Math.round(weight),
            height: Math.round(height)
        },
        BMI: Math.round(bmi),
        status: bmiStatus
    }
}


console.log(personalBMI('Peter', 29, 75, 182))