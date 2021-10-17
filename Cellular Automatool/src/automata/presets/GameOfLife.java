package automata.presets;

import automata.Automaton;

public class GameOfLife implements Automaton {
    
    @Override
    public int getNumberOfStates() {
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