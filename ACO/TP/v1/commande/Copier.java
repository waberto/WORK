package commande;

import receiver.MoteurEditeur;

public class Copier {
	
	//Attribut moteur
	private MoteurEditeur moteur;
	
	//Constructeur
	public Copier(MoteurEditeur m){
		this.moteur = m;
	}
	
	//Execution de la command execute
	public void execute(){
		this.moteur.copier();
	}
}
