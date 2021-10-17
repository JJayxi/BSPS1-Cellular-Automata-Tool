package automata.presets;

import automata.Automaton;

public class RockPaperScissors implements Automaton {
    
    //0 = rock, 1 = paper, 2 = scissors
    private final int N = 6;
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