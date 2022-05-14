
const button_Create = document.getElementById('button_Create');

const HTTP_ALL_USERS = 'http://localhost:8080/users';
const HTTP_ADD_APPOINTMENT = 'http://localhost:8080/appointments/add';
const HTPP_ALL_SERVICIES = 'http://localhost:8080/servicies';
const HTTP_GET_ID_BY_PHONENR = 'http://localhost:8080/users/getIdByPhone';

window.onload = onLoadFunction;

var listServicies = [];

function onLoadFunction() {

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    var hour = today.getHours();
    var minute = today.getMinutes();

    if(dd < 10){ dd = '0' + dd; } 
    if(mm < 10){ mm = '0' + mm; }
    if(hour < 10){ hour = '0' + hour; }
    if(minute < 10){ minute = '0' + minute; } 

    document.getElementById("timeSelector").value = hour + ":" + minute;

    today = yyyy+'-'+mm+'-'+dd;
    document.getElementById("dateSelector_Date").setAttribute("min", today);
    document.getElementById("dateSelector_Date").value = today;

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

    var phoneNr = document.getElementById("textBox_phoneNr").value;
    var name = document.getElementById("textBox_Name").value;


    if(phoneNr.length != 10){

        $("#textBox_phoneNr").css("color", "red");
        alert("Phone number invalid.")

    }else{

        $("#textBox_phoneNr").css("color", "black");

        if(name.length != 0){

            addAppointment(document.getElementById("textBox_Name").value,
                    document.getElementById("textBox_phoneNr").value);

        }else{

            alert("A name is required.")
        }
    
    }

    

});

function validate(evt) {
  var theEvent = evt || window.event;

  // Handle paste
  if (theEvent.type === 'paste') {
      key = event.clipboardData.getData('text/plain');
  } else {
  // Handle key press
      var key = theEvent.keyCode || theEvent.which;
      key = String.fromCharCode(key);
  }
  var regex = /[0-9]|\./;
  if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
  }
}

function addAppointment(name, phoneNr){

    var date = new Date($('#dateSelector_Date').val());

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    var l = document.getElementById("timeSelector").value;
    timeArray = l.split(":");
    
    axios({
        method: 'post',
        url: HTTP_ADD_APPOINTMENT,
        headers: {}, 
        data: {
            idService: document.getElementById("dropDown_Service").value,
            userName: name,
            userPhoneNr: phoneNr,
            year: year,
            month: month,
            day: day,
            hour: parseInt(timeArray[0]),
            minute: parseInt(timeArray[1])
        }
    }).then(response => {

        console.log(response.data);

        if(response.data == 1){
            console.log("OK");

            initComponents();

        }else{
            console.log("NOT OK");
            alert("Can't make appointment on that time.");
        }
    
    });
    
}

function initComponents(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    var hour = today.getHours();
    var minute = today.getMinutes();

    if(dd < 10){ dd = '0' + dd; } 
    if(mm < 10){ mm = '0' + mm; }
    if(hour < 10){ hour = '0' + hour; }
    if(minute < 10){ minute = '0' + minute; } 

    document.getElementById("timeSelector").value = hour + ":" + minute;

    today = yyyy+'-'+mm+'-'+dd;
    document.getElementById("dateSelector_Date").setAttribute("min", today);
    document.getElementById("dateSelector_Date").value = today;

    document.getElementById("textBox_Name").text = "";
    document.getElementById("textBox_phoneNr").text = "";

    alert("Appointment saved.");

}


function axiosGet(){
    /*

    axios.get(HTTP_ALL_USERS).then(resp => {

        console.log(resp.data);

        resp.data.forEach(data => {
            console.log(data.name);
        })

        //for(int i=0 ; i<res.data.length() ; i++){
        //  console.log(resp.data.name);
        //}
    
    });
    */

}
