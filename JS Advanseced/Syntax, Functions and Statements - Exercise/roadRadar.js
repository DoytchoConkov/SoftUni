function roadRadar(arr){

    let speed=arr[0];
    let limit=0;
    switch(arr[1]){
        case "motorway": limit=130; break;
        case "interstate": limit=90; break;
        case "city": limit=50; break;
        case "residential": limit=20; break;
    }
    if (speed-limit>40){
        console.log('reckless driving')
    }else if (speed-limit>20){
        console.log('excessive speeding')
    }else if (speed-limit>0){
        console.log('speeding')
    }
}