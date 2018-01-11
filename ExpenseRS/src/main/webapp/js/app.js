/**
 * 
 */
window.onload = function(){
	getuserinfo();
	checkrole();
	document.getElementById('reimreq').addEventListener("click",submitreqview,false);
	document.getElementById('updateviewpanal').addEventListener("click",updateview,false);
	document.getElementById('reqviewpanal').addEventListener("click",reqsview,false);
	
}


function get_mg_empsview() {

}
//****************View reqs Functions ***********************/

// Reqs for Manager
function get_mg_reqsview() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('block1').innerHTML ="";
			document.getElementById('block1').innerHTML = xhr.responseText;
			document.getElementById('selstatus').addEventListener("change",mg_loadallreqs,false);
			
		}
	}
	xhr.open("GET", "mgreqsview", true);
	xhr.send();
}

function mg_loadallreqs() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			let current = JSON.parse(xhr.responseText);
			let tbody = document.getElementById ('reqtable');
			tbody.innerHTML = "";
			let tr;
			let td;
			for(let k in current) {
				tr = document.createElement("tr");
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].author;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rDescription;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rAmount;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rType;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rSubmittedDate;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rStatus;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rResolvedDate;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].resolver;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = '<button type="submit" class="btn btn-success input-xs" id="viewSReqBtn" value='+ current[k].rId +'>View</button>';
				tr.appendChild(td);
				tbody.appendChild(tr);
			 }
			 $("button").click(function() {
				if (this.id === 'viewSReqBtn'){
					let fired_button = $(this).val();
					alert(fired_button);
				} 
				
			});
		}
	}
	
	
	let sel = document.getElementById ('selstatus');
	let selectedS = (sel.options [sel.selectedIndex]).text;
	let tx;
	if (selectedS === "Pending"){
		tx = {id1 : "Pending"};
	} else {
		tx = {id1 : "Resolved"};
	}
	tx = JSON.stringify(tx);
	xhr.open("POST", "getallreqsmg", true);
	xhr.send(tx);

}




// Reqs for Emp..
function reqsview() {
    let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('block1').innerHTML ="";
			document.getElementById('block1').innerHTML = xhr.responseText;
			document.getElementById('selstatus').addEventListener("change",loadallreqs,false);
			
		}
	}
	xhr.open("GET", "reqsview", true);
	xhr.send();
}



function loadallreqs() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			let current = JSON.parse(xhr.responseText);
			let tbody = document.getElementById ('reqtable');
			tbody.innerHTML = "";
			let tr;
			let td;
			for(let k in current) {
				tr = document.createElement("tr");
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rDescription;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rAmount;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rType;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rSubmittedDate;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rStatus;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rResolvedDate;
				tr.appendChild(td);
				td = document.createElement("td");
				td.setAttribute( 'class', 'text-left' );
				td.innerHTML = current[k].rReceipt;
				tr.appendChild(td);
				tbody.appendChild(tr);
			 }
		}
	}
	
	
	let sel = document.getElementById ('selstatus');
	let selectedS = (sel.options [sel.selectedIndex]).text;
	let tx;
	if (selectedS === "Pending"){
		tx = {id1 : "Pending"};
	} else {
		tx = {id1 : "Resolved"};
	}
	tx = JSON.stringify(tx);
	xhr.open("POST", "getallreqs", true);
	xhr.send(tx);

}













//****************update Functions ***********************/

function updateview() {
    let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('block1').innerHTML ="";
			document.getElementById('block1').innerHTML = xhr.responseText;
			document.getElementById('updateBtn').addEventListener("click",updateinfo,false);
			confirmpass();
			loadinfo();
		}
	}
	xhr.open("GET", "updateview", true);
	xhr.send();
}

function loadinfo() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
            let current = JSON.parse(xhr.responseText);
            document.getElementById('ufname').value = current.userFirst;
            document.getElementById('ulname').value = current.userLast;
            document.getElementById('uemail').value = current.userEmail;
		}
	}
	xhr.open("GET", "getupdateinfo", true);
	xhr.send();
}
function updateinfo(){
	let firstname = document.getElementById('ufname').value;
	let lastname = document.getElementById('ulname').value;
	let updatedemail = document.getElementById ('uemail').value;
    let updatedpass =  document.getElementById ('upass2').value;

	let tx = {
		userFirst: firstname,
		userLast: lastname,
		userEmail: updatedemail,
		userPass: updatedpass  
	}
	tx = JSON.stringify(tx);
	// ready to send xhr
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
            document.getElementById('block1').innerHTML ="";
			document.getElementById('block1').innerHTML = xhr.responseText;
		}
	}
	xhr.open("POST", "updateinfo", true);
	xhr.send(tx);
}


function confirmpass() {
	let password = document.getElementById("upass1")
  , confirm_password = document.getElementById("upass2");

	function validatePassword(){
	if(password.value != confirm_password.value) {
		confirm_password.setCustomValidity("Passwords Don't Match");
	} else {
		confirm_password.setCustomValidity('');
	}
	}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
}





//****************submit req  Functions ***********************/
function submitreqview() {
    let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('block1').innerHTML ="";
			document.getElementById('block1').innerHTML = xhr.responseText;
			document.getElementById('submitBtn').addEventListener("click",submitreq,false);
			getTypes();
		}
	}
	xhr.open("GET", "reqview", true);
	xhr.send();
}

function getTypes(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			let types = JSON.parse(xhr.responseText);
			let select = document.getElementById('seltype');
			let opt;
			for(let k in types) {
				opt = document.createElement("option");
				opt.innerHTML = types[k].name;
				select.appendChild(opt);
				
			 }
			
		}
	}
	xhr.open("GET", "reqtypes", true);
	xhr.send();
}

function submitreq(){
	
	let amount = document.getElementById('amount').value;
	let desc = document.getElementById('description').value;
	let sel = document.getElementById ('seltype');
    let selectedT = (sel.options [sel.selectedIndex]).text;

	let tx = {
		rAmount: amount,
		rType: selectedT,
		rDescription: desc  
	}
	tx = JSON.stringify(tx);
	// ready to send xhr
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
            
		}
	}
	xhr.open("POST", "submitreq", true);
	xhr.send(tx);

}


//****************User Functions ***********************/
function getuserinfo() {
    let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
            let current = JSON.parse(xhr.responseText);
			document.getElementById('usern').innerHTML = current.userName;
            document.getElementById('first').innerHTML = current.userFirst;
            document.getElementById('last').innerHTML = current.userLast;
            document.getElementById('email').innerHTML = current.userEmail;
		}
	}
	xhr.open("GET", "userinfo", true);
	xhr.send();
}


function checkrole() {
    let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('mgbar').innerHTML = xhr.responseText;
			document.getElementById('mgviewreq').addEventListener("click",get_mg_reqsview,false);
			document.getElementById('viewemps').addEventListener("click",get_mg_empsview,false);
		}
	}
	xhr.open("GET", "checkrole", true);
	xhr.send();
}


