function myfun(){
 var na =document.getElementById("username").value;
var n=document.getElementById("password").value;
if( n=="1234" && na=="Deepak"){
     window.location.assign("After_login.html");
     document.getElementById("form_main").action="After_login.html";
 
}
else {
    alert("something went wrong");
    window.location.assign("login.html");
}


}
const station =[];
station.push("raja nahar singh");
station.push("sant surdas");
station.push("escort mujhesar");
station.push("bata chowk");
station.push("neelam");
station.push("old faridabad");
station.push("sector 28");
station.push("mewla maharajpur");
station.push("sarai");
station.push("badrpur border");
console.log(station);
let price=5;
function search(){
    let origin=document.getElementById("origin").value;
    let destination=document.getElementById("destination").value;
    let between,i;
    if(station.indexOf(origin)<station.indexOf(destination)){
        console.log("station between origin to destination");
        for( i=station.indexOf(origin);i<station.indexOf(destination);i++){
   price+=5;

  
        }
        document.write(origin +"to"+destination+" price"+price);
       window.print();
    }
    else{
        station.reverse();
        for(i=station.indexOf(origin);i<=station.indexOf(destination);i++){
            price+=5;

        }
        document.write(price);
        window.print();
       
    }
    }