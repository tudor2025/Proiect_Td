
const button_Create = document.getElementById('button_Create');

const HTTP_ALL_USERS = 'http://localhost:8080/users';
const HTTP_ADD_APPOINTMENT = 'http://localhost:8080/appointments/add';

button_Create.addEventListener('click', event => {

	console.log("Clicked");

 	
  axios.get(HTTP_ALL_USERS).then(resp => {

      console.log(resp.data);

      resp.data.forEach(data => {
        console.log(data.name);
      })

      //for(int i=0 ; i<res.data.length() ; i++){
      //  console.log(resp.data.name);
      //}
  
  });

	//res.data.data; // '{"answer":42}'
	//res.data.headers['Content-Type']; // 'application/json;charset=utf-8',

});

function addAppointment(){
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
}

function axiosGet(){

	axios.get(HTTP_ALL_USERS).then(resp => {

    	console.log(resp.data);

    	resp.data.forEach(data => {
    		console.log(data.name);
    	})

    	//for(int i=0 ; i<res.data.length() ; i++){
    	//	console.log(resp.data.name);
    	//}
	
	});

}
