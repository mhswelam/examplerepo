/**
 * To print error message
 */

window.onload = function(){
	document.getElementById('btn').addEventListener("click",checklogin,false);

	
}


function checklogin() {
	let username = document.getElementById('userName').value;
	let userpass = document.getElementById('userPass').value;
	let userT = {
		name : username,
        pass : userpass
	}
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			document.getElementById('meg').innerHTML = "UserName and/or password incorrect";
			
		}
	}
	xhr.open("POST", "login", true);
	xhr.send(userT);
}