package receiver;

public class Buffer implements BufferInterface {

	//Contenu du Buffer
	private StringBuffer contenu;
	//Position de la selection du curseur
	private Selection curseur;
	
	//Cronstructeur d'un Buffer
	public Buffer(){
		this.contenu = new StringBuffer();
		this.curseur = new Selection();
	}

	//Retourne le contenu du Buffer
	public StringBuffer getContenu() {
		return this.contenu;
	}
	
	//Modifie le contenu du Buffer
	public void setContenu(StringBuffer c) {
		this.contenu = c;
	}
	//Retourne la position de la selection du curseur
	public Selection getCurseur() {
		return this.curseur;
	}

	//Modifie la position de la selection du curseur
	public void setCurseur(Selection cr) {
		this.curseur = cr;
	}
	
	
	
}
