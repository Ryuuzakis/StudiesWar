function getMessage(idPartie){
	var path="v1/partie"+idPartie+"/tchat";
	$.getJSON(path,function(data){
		alert("bienvenue");
		PostMessage(data)
	});
}

function PostMessage(idPartie,idJoueur,reponse){

	var html="<p id='chatbox'>";
	for(var i=0;i<data.caracs.length;++i){
		html+=data.caracs[i];
	}
	html+="</p>";
	$("#usermsg").html(html);
}
