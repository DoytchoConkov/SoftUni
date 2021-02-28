function solve(n,k){

    let result =[1];
    for(let i=1;i<Number(n);i++){
    let startIndex=i-Number(k);
    if(startIndex<0){startIndex=0;}
    let sum=0;
    for (let j=startIndex;j<i;j++){
    sum+=result[j];
    }
    result.push(sum);
    }
    console.log(result.join(" "));
    }