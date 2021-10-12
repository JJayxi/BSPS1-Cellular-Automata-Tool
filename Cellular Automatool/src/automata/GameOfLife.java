package automata;

public class GameOfLife {
    

    public int evaluate(int[] neighbourStateCount, int cellState) {

	if(cellState == 1) {
	    if(neighbourStateCount[1] < 2) return 0;
	    return (neighbourStateCount[1] <= 3) ? 1 : 0;
	}
	
	return (neighbourStateCount[1] == 3) ? 1 : 0;
    }
    
}