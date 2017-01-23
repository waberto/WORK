//Please comment each modification of this skeleton to highlight the code asked for this lab.

/**
 * Objects of class Workshop represent processing workshops. The operation is as follows:
 * The method processing() removes an element from a Stock A, waits 100 ms 1 and, finally adds 
 * an element to a Stock B. The method work() performs n processings successively.
 */

class Workshop {

	/**
	 * source stock
	 */
    private Stock A;
    /**
     * destination stock
     */
    private Stock B;
    /** 
     * Number of processings to perform when the method work is called
     */
    private int nbProcessing;

    /**
     * Constructor
     * @param A: source stock
     * @param B: destination stock
     * @param nbProcessing: Number of processings to perform
     */
    public Workshop(Stock A, Stock B, int nbProcessing) {
        this.A = A;
        this.B = B;
        this.nbProcessing = nbProcessing;
    }

    /**
     * Perform one processing
     */
    public void processing() {
        A.destock();
        try { Thread.sleep(100); } catch(InterruptedException e) {}
        B.stock();
    }

    /**
     * Perform nbProcessing processings
     */
    public void work() {
        for(; nbProcessing > 0; nbProcessing--)
            processing();
    }
    /**
     * Print the state of the stock object
     */
    public void print() {
    	System.out.println("Stock " + A.getName() + ": " + A.getNbProducts() + " product(s).");
    	System.out.println("Stock " + B.getName() + ": " + B.getNbProducts() + " product(s).");
        System.out.println("Stock " + A.getName() + ": " + nbProcessing + " processing(s).");
        System.out.println("Stock " + B.getName() + ": " + nbProcessing + " processing(s).");
    }


    /**
     * Method main for unit testing
     * @param args Not used
     */
    static public void main(String[] args) {
    		
    	Workshop w = new Workshop(new Stock("PieceA", 10), new Stock("PieceB", 20) , 5);
    	w.work();
    	w.print();

    }
}
