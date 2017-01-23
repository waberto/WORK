package receiver;

public class Selection implements SelectionInterface{
	
	//Position du début de la selection
	private int debut;
	//Position de fin de la selection 
	private int fin;
	
	//Cronstructeur d'une selection  
	public Selection(){
		this.debut = 0;
		this.fin = 0;
	}

	//Retourne le debut de la selection 
	public int getDebut() {
		return debut;
	}

	//Modifie le début de la selection
	public void setDebut(int debut) {
		this.debut = debut;
	}
	
	//Retourne la fin de la selection
	public int getFin() {
		return fin;
	}
	
	//Modifie la fin de la selection
	public void setFin(int fin) {
		this.fin = fin;
	}
	
}
