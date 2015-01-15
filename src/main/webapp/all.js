function getUser(name) {
	$.getJSON("v1/user/" + name, function(data) {
		afficheUser(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(data.id + " : " + data.name);
}

function postUser(name) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/user/",
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});
}

function listUsers() {
	$.getJSON("v1/user/", function(data) {
		afficheListUsers(data)
	});
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>" + data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}

function lancerPartie() {
	alert('Lancer la partie');
}

function CreerPartie(){}

/** Fonction basculant la visibilité d'un élément dom
* @parameter anId string l'identificateur de la cible à montrer, cacher
*/
function Hide (addr) { 
	document.getElementById(addr).style.visibility = "hidden";
}

function Show (addr) { 
	document.getElementById(addr).style.visibility = "visible";
}

function toggle(anId){
	if (document.getElementById(anId).style.visibility == "hidden")	{
		Show(anId);
	}else{	
		Hide(anId);
	}
}

function toggle(anId, anId2){
	if (document.getElementById(anId).style.visibility == "hidden")	{
		Show(anId);
	}else{	
		Hide(anId);
		document.getElementById(anId2).style.height = "0";
	}if (document.getElementById(anId2).style.visibility == "hidden"){
		Show(anId);
	}else{	
		Hide(anId2);
		document.getElementById(anId2).style.height = "0";
	}
}

<<<<<<< HEAD
function afficheBulletin(data) {
	console.log(data);
	$("#reponse").html(data.id + " : " + data.name);
=======
function lancerPartie(anId, anId2){
	Show(anId);
	Show('nav');
	
	Hide(anId2);
	document.getElementById(anId2).style.height = "0";
	
>>>>>>> fe8d2d3510bef6a48c27de9a06ffc23174a1a5df
}


function afficherContact(){ 
	window.onload = function()
	{
  		  var section = document.getElementById('canvas_contacts');
    		    if(!section)
       		 {
        		    alert("Impossible de récupérer le canvas");
          		
         return;
            
        }

    var context = section.getContext('2d');
        if(!context)
        {
            alert("Impossible de récupérer le context du canvas");
            return;
        }


    //C'est ici que l'on placera tout le code servant à nos dessins.
    context.font = "18px Helvetica";//On passe à l'attribut "font" de l'objet context une simple chaîne de caractères composé de la taille de la police, puis de son nom.
	context.fillText("Hello World", 0, 30);//strokeText(); fonctionne aussi, vous vous en doutez.
}









