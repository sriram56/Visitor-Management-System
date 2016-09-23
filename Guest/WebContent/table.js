



window.onload=function login() {
	/*var loginObject = new Object();

	loginObject.Email = document.getElementById('Email').value;
	loginObject.Password = document.getElementById('Password').value;
*/
alert("OK");
	send();
	//alert(loginObject);
}


function send() {

  $.ajax({
        url: "table.json",
        type: 'GET',
        contentType: "application/json",
        dataType: "json",
        //crossDomain: true,
		// headers: {
  //               "sessionKey": document.cookie
  //           },
  		//data: JSON.stringify(data),

        success: function (successData) {
            console.log(successData);
            alert(successData.visitor_Info.length);
            addContentsToTable3(successData);
        },
        error: function (errorData) {
            console.log(errorData);  
					//alert(JSON.stringify(errorData));
					//alert(errorData); 
					alert(" Unsucessful");
					//window.location.reload();
        }
    });
 }



function addContentsToTable3(data)
{
 // var i =0;
 // var upcoming = "Upcomming";
 // var completed = "Completed";
 // var  point    = "tmk.bza@gmail.com"; 

 //  for(i=0; i<data.visitor_Info.length;i++) {
 //    var status = data.visitor_Info[i].visitorInfo.status;
 //    var poc = data.visitor_Info[i].visitorInfo.poc;
 //   // alert(status);
   
 //  // alert(JSON.stringify(data.visitor_Info));
 //  if( status === upcoming ) {
 //    $('#upcoming').append("<tr> <td>" + data.visitor_Info[i].visitorInfo.first_name + "</td>" +
 //                          "<td>"+ data.visitor_Info[i].visitorInfo.last_name +"</td>" +
 //                          "<td>"+ data.visitor_Info[i].visitorInfo.type +"</td> " +
 //                          "<td>"+ data.visitor_Info[i].visitorInfo.org+"</td>" +
 //                         "<td>"+ data.visitor_Info[i].visitorInfo.role +"</td> " + 
 //                          "<td>"+ data.visitor_Info[i].visitorInfo.mobile_number +"</td> " +
 //                          " <td>"+ data.visitor_Info[i].visitorInfo.vid+"</td> " +
 //                         " <td>"+ data.visitor_Info[i].visitorInfo.email+"</td> " +
 //                         " <td>"+ data.visitor_Info[i].visitorInfo.delegate_to+"</td> " +
 //                          "<td>"+ data.visitor_Info[i].visitorInfo.status +"</td> </tr>");
    
 //    }
 //  else if(status === ongoing)
 //  }
}
//google sign in api 

 function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail());
	 
	 // The ID token you need to pass to your backend:
       var id_token = googleUser.getAuthResponse().id_token;
       console.log("ID Token: " + id_token);
}
