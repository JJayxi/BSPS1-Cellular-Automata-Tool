package automata.presets;

import automata.Automata;

/**
 * automata that makes beautiful spirals, and can have an arbitrary number of states.
 * this cannot be created with the moduls since a random value is used
 */
public class RockPaperScissors implements Automata {
    
    //state n+1 beats n 
    private final int N = 4;
    @Override
    public int getNumberOfStates() {
	return N;
    }
    
    private int threshold = 3;
    @Override
    public int evaluate(int[] neighbourStateCount, int cellState) {
	
	if(neighbourStateCount[(cellState + 1) % N] > threshold + Math.round(Math.random() * 4 - 3)) 
	    return (cellState + 1) % N;
	return cellState;
    }
    
}