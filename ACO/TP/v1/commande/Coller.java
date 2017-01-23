package commande;

import receiver.MoteurEditeur;

public class Coller {
	
	//Attribut
	private MoteurEditeur moteur;
		
	//Constructeur
	public Coller(MoteurEditeur m){
		this.moteur = m;
	}
		
	//Execution de la commande Coller
	public void Coller(){
		this.moteur.couper();
	}

}
