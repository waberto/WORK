package receiver;

public class PressPapier implements PressPapierInterface {
	//Contenu du presse-papier
	private String contenu;
	
	//Crée le press-papier avec une chaine vide
	public PressPapier(){
		contenu = "";
	}
		
	//Retourne le contenu du press-papier
	public String getContenu() {
		return new String(contenu);
	}
	
	//Modifie le contenu du press-papier
	public void setContenu(String c) {
		this.contenu = new String(c);
	}
	
}
