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
		html = html + "<li>" + data.actions.[index] + "</li>";
	}
	html = html + "</ul>";
	$("#actionsdiv").html(html);
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
		document.getElementById(anId).style.height = "auto";
	}else{	
		Hide(anId);
		document.getElementById(anId2).style.height = "0";
	}if (document.getElementById(anId2).style.visibility == "hidden"){
		Show(anId);
		document.getElementById(anId).style.height = "auto";
	}else{	
		Hide(anId2);
		document.getElementById(anId2).style.height = "0";
	}
}











