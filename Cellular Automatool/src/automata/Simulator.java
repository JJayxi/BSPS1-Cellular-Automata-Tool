package automata;

import automata.modular.ModularAutomaton;
import automata.modular.Rule;
import automata.modular.conditions.*;
import automata.presets.*;
import automata.stats.Stats;

public class Simulator {
    protected int[][] grid;
    protected int gridWidth, gridHeight;
    public Stats stats;
    
    //Automaton automaton = new GameOfLife();
    Automaton automaton = new RockPaperScissors();
    
    public Simulator(int gridWidth, int gridHeight) {
	
	ModularAutomaton modularGoL = new ModularAutomaton(2);
	modularGoL.addRule(new Rule(0, 1, new ConditionNeighbourStateEqual(1, 3)));
	modularGoL.addRule(new Rule(1, 0, new ConditionNeighbourStateMoreThan(1, 3)));
	modularGoL.addRule(new Rule(1, 0, new ConditionNeighbourStateLessThan(1, 2)));
	//automaton = modularGoL;
	
	stats = new Stats(gridWidth, gridHeight, automaton.getNumberOfStates());
	
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	grid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		grid[i][j] = (int)(Math.random() * automaton.getNumberOfStates());
	    }
    }
    
    public void update() {
	int[] cellCount = new int[automaton.getNumberOfStates()];
	int activity = 0;
	int[][] newGrid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		cellCount[grid[j][i]]++;
		newGrid[i][j] = nextState(j, i);
		if(grid[i][j] != newGrid[i][j])activity++;
		
	    }
	grid = newGrid;
	stats.addStepValues(activity, cellCount);
    }
    
    private int nextState(int x, int y) {
	int[] count = new int[automaton.getNumberOfStates()];
	if(x - 1 >= 0){		    count[grid[y    ][x - 1]]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x - 1]]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x - 1]]++;
	}
	if(x + 1 < gridWidth){      count[grid[y    ][x + 1]]++;
	    if(y - 1 >= 0)	    count[grid[y - 1][x + 1]]++;
	    if(y + 1 < gridHeight)  count[grid[y + 1][x + 1]]++;
	}

	if(y - 1 >= 0)		    count[grid[y - 1][x    ]]++;
	if(y + 1 < gridHeight)	    count[grid[y + 1][x    ]]++;
	
	return automaton.evaluate(count, grid[y][x]);
    }
    
    public Stats getStats() {
	return stats;
    }
}