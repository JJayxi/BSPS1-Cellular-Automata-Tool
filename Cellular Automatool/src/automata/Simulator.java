package automata;

import automata.presets.*;
import automata.stats.Stats;
import java.util.Arrays;

public class Simulator {
    
    
    protected int[][] grid;
    protected int[][][] gridCount;
    protected int gridWidth, gridHeight;
    public Stats stats;
    
    //Automaton automaton = new GameOfLife();
    Automata automaton = new RockPaperScissors();
    
    /**
     * @param gridWidth number of columns in the grid of the running simulation
     * @param gridHeight number of rows in the grid of the running simulation
     * @param automaton automaton that will run the simulation
     */
    public Simulator(int gridWidth, int gridHeight, Automata automaton) {
	
	this.automaton = automaton;
	
	stats = new Stats(gridWidth, gridHeight, automaton.getNumberOfStates());
	
	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	this.gridCount = new int[gridHeight][gridWidth][automaton.getNumberOfStates()];
	randomizeGrid();
	
	
	//////////
	newGrid = new int[gridHeight][gridWidth];
	newGridCount = new int[gridHeight][gridWidth][automaton.getNumberOfStates()];
    }
    
    /**
     * sets the states of all the cells in the grid to a random possible state
     */
    public void randomizeGrid() {
	grid = new int[gridHeight][gridWidth];
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) 
		grid[i][j] = (int)(Math.random() * automaton.getNumberOfStates());  
    }
    
    public void setCellValue(int col, int row, int state) {
	setCellValue(col, row, state, grid, gridCount);
    }
    
    private void setCellValue(int col, int row, int state, int[][] grid, int[][][] gridCount) {
	grid[row][col] = state;
	
	boolean cm = col > 0, cg = col < gridWidth-1;
	boolean rm = row > 0, rg = row < gridHeight-1;
	if(cm) {
		  gridCount[row	   ][col - 1][state]++;
	    if(rm)gridCount[row - 1][col - 1][state]++;
	    if(rg)gridCount[row + 1][col - 1][state]++;
	}
	if(cg) {
		  gridCount[row	   ][col + 1][state]++;
	    if(rm)gridCount[row - 1][col + 1][state]++;
	    if(rg)gridCount[row + 1][col + 1][state]++;
	}
	
	if(rm)gridCount[row - 1][col][state]++;
	if(rg)gridCount[row + 1][col][state]++;
    }
    
    /**
     * steps the simulation into the next timestep. The local rule is calculated
     * for every cell, then the calculated state is applied to the cell. \n
     * The number of cells in each state is counted, and so is the number of cells
     * that change state. Those value are then added in the Simulator.stats to be tracked. 
     */
    private int[][][] newGridCount;
    private int[][] newGrid;
    public void update() {
	int[] cellCount = new int[automaton.getNumberOfStates()];
	
	for(int[][] row : newGridCount)
	    for(int[] cell : row)
		Arrays.fill(cell, 0);
	
	int activity = 0;
	
	for(int i = 0; i < gridHeight; i++)
	    for(int j = 0; j < gridWidth; j++) {
		cellCount[grid[j][i]]++;
		setCellValue(i, j, 
			    automaton.evaluate(gridCount[j][i], grid[j][i]),
			    newGrid, newGridCount);
		if(grid[i][j] != newGrid[i][j])activity++;
		
	    }
	int[][] temp2 = grid;
	grid = newGrid;
	newGrid = temp2;
	
	int[][][] temp3 = gridCount;
	gridCount = newGridCount;
	newGridCount = temp3;
	
	stats.addStepValues(activity, cellCount);
    }
    
    /**
     * @return returns the object which contains the values of the number of cell
     * in each state on each time step and the activity (number of cells changed). 
     */
    public Stats getStats() {
	return stats;
    }
    
}