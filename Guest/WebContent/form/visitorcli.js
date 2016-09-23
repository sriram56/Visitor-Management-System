//Requesting otp sending email and mobile number

function requestotp()
{
  alert("request done");
  var requestObject = {
    "requestotp" : <!-- Ask backend name -->
    {
      "email": document.getElementById('Email').value,
      "mobile_number":document.getElementById('Mobile').value
    }
  };
  alert(JSON.stringify(requestObject));
  console.log(JSON.stringify(requestObject));
  request(requestObject);
}

function request(data) {

  $.ajax({
        url: "",
        type: 'POST',
        contentType: "application/json",
        dataType: "text",
        //crossDomain: true,
    // headers: {
  //               "sessionKey": document.cookie
  //           },
      data: JSON.stringify(data),

        success: function (successData) {
            console.log(successData);
            //resp = successData;
          //alert(successData);
          if(successData=="true")
          {
            window.location = "index.html";
          }
          else
          {
            alert("Wrong");
            }
          
        },
        error: function (errorData) {
            console.log(errorData);  
          alert(JSON.stringify(errorData));
          //alert(errorData); 
          alert("Login Unsucessful");
          window.location.reload();
        }
    });
 }

//verifying Otp sending otp and mobile number

function verifyotp()
{
  alert("verify entered");
  var verifyObject = {
    "verifyotp" : <!-- Ask backend name -->
    {
      "mobile_number":document.getElementById('Mobile').value,
      "otp":document.getElementById('Otp').value
    }
  };
  alert(JSON.stringify(verifyObject));
  console.log(JSON.stringify(verifyObject));
  verify(verifyObject);
}

function verify(data) {

  $.ajax({
        url: "",
        type: 'POST',
        contentType: "application/json",
        dataType: "text",
        //crossDomain: true,
    // headers: {
  //               "sessionKey": document.cookie
  //           },
      data: JSON.stringify(data),

        success: function (successData) {
            console.log(successData);
            //resp = successData;
          //alert(successData);
          if(successData=="true")
          {
            document.getElementById("Address").disabled = false;
            document.getElementById("Org").disabled = false;
            document.getElementById("Purp").disabled = false;
            document.getElementById("Date").disabled = false;
          }
          else
          {
            alert("Wrong OTP");
            }
          
        },
        error: function (errorData) {
            console.log(errorData);  
          alert(JSON.stringify(errorData));
          //alert(errorData); 
          alert("Login Unsucessful");
          window.location.reload();
        }
    });
 }




// Adding Vistors entire data to db 

function addvisin() {
	alert("ok");
	var visitorObject = {
  "visitorInfo": 
    {
			"address": document.getElementById('Address').value,
			"date":document.getElementById('Date').value,
      "email": document.getElementById('Email').value,
      "first_name" : document.getElementById('Firstname').value,
			"last_name" :document.getElementById('Lastname').value,
			"mobile_number":document.getElementById('Mobile').value,
			"poc":document.getElementById('Poc').value,
			"purpose": document.getElementById('Purp').value,
      "org":document.getElementById('Org').value,
			"type":"Client"
			 
    }
  
};

alert(JSON.stringify(visitorObject));
	console.log(JSON.stringify(visitorObject));
	//send(loginObject);
	//alert(loginObject);
}


function send(data) {

  $.ajax({
        url: "http://localhost:8080/guest_3/otherService/loginService",
        type: 'POST',
        contentType: "application/json",
        dataType: "text",
        //crossDomain: true,
		// headers: {
  //               "sessionKey": document.cookie
  //           },
  		data: JSON.stringify(data),

        success: function (successData) {
            console.log(successData);
            //resp = successData;
        	//alert(successData);
        	if(successData=="true")
        	{
            window.location = "index.html";
        	}
        	else
        	{
        		alert("Wrong");
        		}
        	
        },
        error: function (errorData) {
            console.log(errorData);  
					alert(JSON.stringify(errorData));
					//alert(errorData); 
					alert("Login Unsucessful");
					window.location.reload();
        }
    });
 }

//google sign in api 

 function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail());
}