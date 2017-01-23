import java.util.Stack;

//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Stock represent a set of products stacked one above the other.
 * Due to the stack layout, it is not possible that two workshops take two products 
 * at the same time.
 */
class Stock {
	/**
	 * Number of products in the stack
	 */
	
    private int nbProducts;
    
    private int maxStock;
    
	/**
     * Name of the stock
     */
    private String name;
    
    public synchronized int getNbProducts() {	
		return nbProducts;
	}

	public synchronized void setNbProducts(int nbProducts) {
		this.nbProducts = nbProducts;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}
	
    public synchronized int getMaxStock() {
		return maxStock;
	}

	public synchronized void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}


    
    /**
     * Constructor
     * @param name: Name of the new stock
     * @param nbProducts: Initial number of products
     */
    public Stock(String name, int nbProducts, int  max) {
        this.nbProducts = nbProducts;
        this.name = name;
        this.maxStock = max;
    }



	/**
     * Add a product on top of the stack
	 * @throws InterruptedException 
     */
    public synchronized void stock() throws InterruptedException {
    	
    	while(getNbProducts() >= getMaxStock()){
    		notifyAll();
    		wait();
            
    	} 
    	
        setNbProducts(getNbProducts() + 1);
    	notifyAll();
    	

    }

    /**
     * Remove the highest product on the stack
     * @throws InterruptedException 
     */
    public synchronized void destock() throws InterruptedException {
    	while(this.getNbProducts() <= 0){
    		notifyAll();
    		wait();
       	}
    	setNbProducts(getNbProducts() - 1);
     }

    /**
     * Print the state of the stock object
     */
    public synchronized void print() {
        System.out.println("Stock " + name + ": " + getNbProducts() + " product(s).");
    }

    /** 
     * Method main for unit testing
     * @param args Not used
     */
   /* static public void main(String[] args) {

    	Stock c = new Stock("Piece", 10);
    	c.print();
    	c.stock();
    	c.destock();

    }*/
}
