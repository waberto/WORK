//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Factory represent a factory with two processing workshops.
 * A factory has a stock of products to process and, a stock of processed products (initially empty).
 * Both workshops process half of the products. The method activate() launch successively the two
 * workshops and then print the state of the stocks when the processing is finished.
 */
class Factory {
	/**
	 * source stock
	 */
    Stock sourceStock = new Stock("source", 10000,10000);
    /**
     * destination stock
     */
    Stock destinationStock = new Stock("destination", 0,1);
    /**
     * destination stock final
     */
    Stock destinationStockFinal = new Stock("destinationFinal", 0,10000);
    /**
     * processing workshops
     */
    Workshop workshop1 = new Workshop(sourceStock, destinationStock, 5000);
    Workshop workshop2 = new Workshop(sourceStock, destinationStock, 5000);
    Workshop workshop3 = new Workshop(destinationStock, destinationStockFinal, 10000);
    
    /**
     * Launch the factory work
     */
    public void activate() {
    		workshop2.start();
    		workshop3.start();
    		workshop1.start();

    			try{
    				workshop2.join();
    				workshop3.join();
    				workshop1.join();
    			} catch (Exception ex){
    				
    				System.out.println(ex.getMessage());
    			}
    		sourceStock.print();
    		destinationStock.print();
    		destinationStockFinal.print();
    		
    }
    
    /**
     * Entry point for the lab
     * @param args Not used
     */
    public static void main(String[] args) {

    		Factory fac = new Factory();
    		fac.activate();  

    }
}
