function login() {
	var loginObject = new Object();

	loginObject.Email = document.getElementById('Email').value;
	loginObject.Password = document.getElementById('Password').value;

alert(JSON.stringify(loginObject));
	//send(loginObject);
	//alert(loginObject);
}


function send(data) {

  $.ajax({
        url: "",
        type: 'POST',
        contentType: "application/json",
        dataType: "json",
        //crossDomain: true,
		// headers: {
  //               "sessionKey": document.cookie
  //           },
  		data: JSON.stringify(data),

        success: function (successData) {
            console.log(successData);
            //resp = successData;
        	//alert(successData);
        	window.location = "index.html";
        },
        error: function (errorData) {
            console.log(errorData);  
					//alert(JSON.stringify(errorData));
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