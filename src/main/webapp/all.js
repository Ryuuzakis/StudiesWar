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
function getActions(idJoueur, idPartie) {
	var path = "v1/partie/" + idPartie + "/joueur/" + idJoueur;
	$.getJSON(path, function(data) {
		afficheListActions(data)
	});
}

function afficheListActions(data) {
	var html ='<ul>';
	var index = 0;
	for (index = 0; index < data.actions.length; ++index) {
		html = html + "<li> " + data.actions[index] + "</li>";
	}
	html = html + "</ul>";
	$("#actionsdiv").html(html);
}
function getResultats(idPartie) {
	var path = "v1/partie/" + idPartie + "/resultats";
	$.getJSON(path, function(data) {
		afficheListResultats(data)
	});
}

function afficheListResultats(data) {
	var html ='<ul>';
	var index = 0;
	for (index = 0; index < data.resultats.length; ++index) {
		html = html + "<li>" + data.resultats[index] + "</li>";
	}
	html = html + "</ul>";
	$("#resultsdiv").html(html);
}


function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>" + index + " : " + data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}



/** Fonction basculant la visibilité d'un élément dom
* @parameter anId string l'identificateur de la cible à montrer, cacher
*/
function Hide (addr) { 
	document.getElementById(addr).style.visibility = "hidden";
}

function Show (addr) { 
	document.getElementById(addr).style.visibility = "visible";
}



function lancerPartie(){	
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/partie/"+$('#user').val(),
		success : function(data, textStatus, jqXHR) {
			idJoueur = data.idJoueur;
			idPartie = data.idPartie;
			alert(idJoueur + "/" + idPartie);
			Show("partie");
			Show("nav");
			Hide("identification");	
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error: ' + textStatus);
		}
	});	
}

function retourAccueil(){
 	
	Show("identification");
	Hide("nav");
	Hide("partie");	
}


function toggle(anId){
	Hide('identification');
	Hide('contacts');
	Hide('edt');
	Hide('partie');
	Hide('bulletins');
	Hide('contacts2');

  	Show(anId);
}


function afficherContact(){ 
	window.onload = function() {
  		  var section = document.getElementById('canvas_contacts');
    	  if(!section) {
        	    alert("Impossible de récupérer le canvas");
          	    return;
		  }

    	  var context = section.getContext('2d');
          if(!context) {
            alert("Impossible de récupérer le context du canvas");
            return;
          }
    }


    //C'est ici que l'on placera tout le code servant à nos dessins.
    context.font = "18px Helvetica";//On passe à l'attribut "font" de l'objet context une simple chaîne de caractères composé de la taille de la police, puis de son nom.
	context.fillText("Hello World", 0, 30);//strokeText(); fonctionne aussi, vous vous en doutez.
}









