	var idJoueur;
	var idPartie;
	var jour;
	var choix = [-1, -1, -1, -1, -1];

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
function getActions(idJour) {
	jour=idJour;
	
	var path = "v1/partie/" + idPartie + "/joueur/" + idJoueur + "/jour/" + idJour;
	$.getJSON(path, function(data) {
		afficheListActions(data, idJour)
	});
}

function getCaracteristiques(idJoueur) {
	var path = "v1/partie/" + idJoueur + "/caracteristiques";
	$.getJSON(path, function(data) {
		afficheListCaracs(data, idJour)
	});
}

function afficheListCaracs(data) {
	var html ='<ul>';
	var index = 0;
	for (index = 0; index < data.caracs.length; ++index) {
		html = html + "<li>" + data.caracs[index] + "</li>";
	}
	html = html + "</ul>";
	$("#MettezVotreDivIci").html(html);
}

function afficheListActions(data) {
	var html ='';
	var index = 0;
	for (index = 0; index < data.actions.length; ++index) {
		html = html + "<a  onclick='action("+index+")' id='action"+index+"'> " + data.actions[index] + "</a></br>";
	}
	$("#choix").html(html);
	
		if(choix[jour-1]>-1) {
			for (var y=0; y<5; y++) {
				if (choix[jour-1]==y) {
					document.getElementById('action'+y).style.color= "red";
				} else {
					document.getElementById('action'+y).style.color= "grey";				
				}
			}
		}
}

function action (index) {
	choix[jour-1]=index;

	document.getElementById('action0').style.color= "grey";
	document.getElementById('action1').style.color= "grey";
	document.getElementById('action2').style.color= "grey";
	document.getElementById('action3').style.color= "grey";
	document.getElementById('action4').style.color= "grey";
	
	
	document.getElementById('action'+index).style.color= "red";
	if (jour == 1) {
		document.getElementById('lundi').style.backgroundColor= "green";	
	}
	if (jour == 2) {
		document.getElementById('mardi').style.backgroundColor= "green";	
	}
	if (jour == 3) {
		document.getElementById('mercredi').style.backgroundColor= "green";	
	}
	if (jour == 4) {
		document.getElementById('jeudi').style.backgroundColor= "green";	
	}
	if (jour == 5) {
		document.getElementById('vendredi').style.backgroundColor= "green";	
	}
	
	var cpt=0;
	for (var i=0; i<5; i++) {
		if (choix[i] > -1 ) {
			cpt++;
		}
	}
	if (cpt == 5) {
		document.getElementById('valider').style.visibility= "visible";
	}
	
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

function getControles(idPartie) {
	var path = "v1/partie/" + idPartie + "/controles";
	$.getJSON(path, function(data) {
		afficheListControles(data)
	});
}

function afficheListControles(data) {
	var html ='<ul>';
	var index = 0;
	for (index = 0; index < data.controles.length; ++index) {
		html = html + "<li>" + data.controles[index] + "</li>";
	}
	html = html + "</ul>";
	$("#controlesdiv").html(html);
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



function lancerPartie() {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : "v1/partie/"+idPartie+"/lancer",
		
		success : function(data, textStatus, jqXHR) {
			Show("partie");
			Show("nav");
			Hide("identification");	
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error creer: ' + textStatus);
		}
	});
}

/*Fonction qui cree la partie*/
function creerPartie(data) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		url : "v1/partie/"+data+"/creer",
		success : function(data, textStatus, jqXHR) {
			idJoueur = data.idJoueur;
			idPartie = data.idPartie;
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('postUser error lancer: ' + textStatus);
		}
	});
}

function afficherEdt () {
	Hide('identification');
	Hide('partie');
	Hide('bulletins');

  	Show('edt');
}

function retourAccueil(){
 	
	Show("identification");
	Hide("nav");
	Hide("partie");
	Hide('edt');
	Hide('partie');
	Hide('bulletins');
}


function toggle(anId){
	Hide('identification');
	Hide('edt');
	Hide('partie');
	Hide('bulletins');

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









