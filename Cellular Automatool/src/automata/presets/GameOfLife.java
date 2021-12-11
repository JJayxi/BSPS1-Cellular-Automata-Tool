package automata.presets;

import automata.Automata;

/**
 *  automata that runs game of life
 */
public class GameOfLife implements Automata{
    
    @Override
    public int numStates() {
	return 2;
    }
    
    @Override
    public int evaluate(int[] neighbourStateCount, int cellState) {

	if(cellState == 1) {
	    if(neighbourStateCount[1] < 2) return 0;
	    return (neighbourStateCount[1] <= 3) ? 1 : 0;
	}
	
	return (neighbourStateCount[1] == 3) ? 1 : 0;
    }
    
}