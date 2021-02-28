function timeTowalk(steps, footprint, speed) {

    let distance = steps * footprint;
    let time = Math.round(distance / speed * 36/10);
    time = time + 60*Math.floor(distance / 500);
    let seconds=time%60;
    let minutes=Math.floor(time/60)%60;
    let hours=Math.floor(time/3600);
    if (seconds<10){
        seconds='0'+seconds;
    }
    if (minutes<10){
        minutes='0'+minutes;
    }
    if (hours<10){
        hours='0'+hours;
    }
    console.log(hours+':'+minutes+':'+seconds);
}


timeTowalk(2564, 0.70, 5.5)