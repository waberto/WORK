package receiver;

public class MoteurEditeur implements MoteurEditeurInterface {
	
	//Attributs
	private Buffer Buf;
	private PressPapier Press;
	
	public MoteurEditeur(){
		this.Buf = new Buffer();
		this.Press = new PressPapier();
	}

	
	public Buffer getBuf() {
		return this.Buf;
	}

	public void setBuf(Buffer buf) {
		this.Buf = buf;
	}

	public PressPapier getPress() {
		return this.Press;
	}

	public void setPress(PressPapier press) {
		this.Press = press;
	}
	
	//Execution de la command couper
	public void couper(){
		
	}
	
	//Execution de la command copier
	public void copier(){
			
	}
	
	//Execution de la command coller
	public void coller(){
			
	}
	
	//Execution de la command insererTexte
	public void insererTexte(){
			
	}
	
	
	
	
	
}
