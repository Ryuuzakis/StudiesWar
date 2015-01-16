package fr.iutinfo.studiesWar.resources;

import java.util.ArrayList;

public class TchatTransfert {

	private ArrayList<String> chatContent = new ArrayList<String>();
	private final int CHAT_SIZE = 10;
	
	public ArrayList<String> getChatContent() {
		return chatContent;
	}

	public void setChatContent(ArrayList<String> chatContent) {
		this.chatContent = chatContent;
	}

	public TchatTransfert() {	}
	
	public TchatTransfert ajouterReponse(String nom, String reponse) {
		if (chatContent.size() > CHAT_SIZE)
			chatContent.remove(0);
		chatContent.add(nom + ": " + reponse);
		return this;
	}
}
