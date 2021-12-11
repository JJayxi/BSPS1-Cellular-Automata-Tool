package automata;

public interface Automata {
    /**
     * @param neighbourStates 
     * Array containing the number of the neighbouring cells of each state. 
     * At neighbourStateCount[i], it contains the number of cells in state i
     * @param cellState
     * The state of the cell in the middle, which will change
     * @return returns the state of the cell in the middle for the next time step, 
     * according to the local rules.
     */
    public int evaluate(int[] neighbourStates, int cellState);
    
    /**
     *
     * @return returns the number of states that exist in this cellular automata
     */
    public int numStates();
}
