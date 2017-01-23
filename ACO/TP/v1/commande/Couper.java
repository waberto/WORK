package commande;

import receiver.MoteurEditeur;

public class Couper {
	
	//Attribut
	private MoteurEditeur moteur;
	
	//Constructeur
	public Couper(MoteurEditeur m){
		this.moteur = m;
	}
	
	//Execution de la commande couper
	public void couper(){
		this.moteur.couper();
	}
}
