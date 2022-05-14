
const button_Create = document.getElementById('button_Create');

const HTTP_ALL_USERS = 'http://localhost:8080/users';
const HTTP_ADD_APPOINTMENT = 'http://localhost:8080/appointments/add';
const HTPP_ALL_SERVICIES = 'http://localhost:8080/servicies';

window.onload = codeAddress;

var listServicies = [];

function codeAddress() {

    axios.get(HTPP_ALL_SERVICIES).then(resp => {

        if(resp.status == 200){

            resp.data.forEach(data => {
                
                listServicies.push({'id': data.id, 'name': data.name, 'duration': data.duration, 'price': data.price});
                $("#dropDown_Service").append(new Option(data.name, data.id));

            });

            $("#label_Price").text(listServicies[0].price.toString() + " RON");
            $("#label_Duration").text(listServicies[0].duration.toString() + " min");

        }else{
            console.log("Not good");
        }
    
    });

}

$("#dropDown_Service").change(function (value) { 

    var id = document.getElementById("dropDown_Service").value;

    id--;
    $("#label_Price").text(listServicies[id].price.toString() + " RON");
    $("#label_Duration").text(listServicies[id].duration.toString() + " min");

});  

button_Create.addEventListener('click', event => {

	console.log("Clicked ...");

	

	//res.data.data; // '{"answer":42}'
	//res.data.headers['Content-Type']; // 'application/json;charset=utf-8',

});

function addAppointment(){
	/*
	axios({
		method: 'post',
 		url: HTTP_ADD_APPOINTMENT,
  		headers: {}, 
  		data: {
    		duration: 100,
    		idUser: 3,
    		year: 1990,
    		month: 12,
   			day: 20,
    		hour: 12,
    		minute: 30
  		}
	}).then(response => {

		if(response.data == 201){
			console.log("OK");
		}else{
			console.log("NOT OK");
		}
	
	});
	*/

}


function axiosGet(){
	/*

	axios.get(HTTP_ALL_USERS).then(resp => {

    	console.log(resp.data);

    	resp.data.forEach(data => {
    		console.log(data.name);
    	})

    	//for(int i=0 ; i<res.data.length() ; i++){
    	//	console.log(resp.data.name);
    	//}
	
	});
	*/

}
