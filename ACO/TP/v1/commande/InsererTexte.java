package commande;

import receiver.MoteurEditeur;

public class InsererTexte {

	//Attribut
	private MoteurEditeur moteur;
		
	//Constructeur
	public InsererTexte(MoteurEditeur m){
		this.moteur = m;
	}
		
	//Execution de la commande insererTexte
	public void InsererTexte(){
		this.moteur.insererTexte();
	}
}
