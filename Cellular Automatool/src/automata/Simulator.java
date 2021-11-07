package automata;

import automata.stats.Stats;
import java.util.Arrays;

public class Simulator {

    protected int[][] grid;
    protected int[][][] gridCount;
    protected int gridWidth, gridHeight;
    public Stats stats;

    Automata automata;

    /**
     * @param gridWidth number of columns in the grid of the running simulation
     * @param gridHeight number of rows in the grid of the running simulation
     * @param automaton automata that will run the simulation
     */
    public Simulator(int gridWidth, int gridHeight, Automata automata) {

	this.automata = automata;

	stats = new Stats(gridWidth, gridHeight, automata.getNumberOfStates());

	this.gridHeight = gridHeight;
	this.gridWidth = gridWidth;
	randomizeGrid();

	//////////
	newGrid = new int[gridHeight][gridWidth];
	newGridCount = new int[gridHeight][gridWidth][automata.getNumberOfStates()];
    }
    
    public void setAutomata(Automata automata) {
	this.automata = automata;
	randomizeGrid();
    }
    
    public Automata getAutomata() {
	return automata;
    }

    /**
     * sets the states of all the cells in the grid to a random possible state
     */
    public void randomizeGrid() {
	grid = new int[gridHeight][gridWidth];
	gridCount = new int[gridHeight][gridWidth][automata.getNumberOfStates()];
	for (int i = 0; i < gridHeight; i++)
	    for (int j = 0; j < gridWidth; j++)
		setCellValue(j, i, (int)(Math.random() * automata.getNumberOfStates()));
    }
    
    /**
     * Set all the cells in the grid to a specific state
     * @param state 
     */
    public void clearToState(int state) {
	grid = new int[gridHeight][gridWidth];
	newGridCount = new int[gridHeight][gridWidth][automata.getNumberOfStates()];
	for (int i = 0; i < gridHeight; i++)
	    for (int j = 0; j < gridWidth; j++)
		setCellValue(j, i, state);
    }
    
    /**
     * Set's a cell to a state and add it's state to the neighbours neighbours-count
     * @param col
     * @param row
     * @param state 
     */
    public void setCellValue(int col, int row, int state) {
	grid[row][col] = state;
	addNeighbourCount(col, row, state, gridCount, 1);
    }
    
    /**
     * Set's a cell to a state and add it's state to the neighbours neighbours-count.
     * The grid is where the cell is set, and the gridCount is where the neighbours are counted.
     * @param col
     * @param row
     * @param state
     * @param grid
     * @param gridCount 
     */
    public void setCellValue(int col, int row, int state, int[][] grid, int[][][] gridCount) {
	grid[row][col] = state;
	addNeighbourCount(col, row, state, gridCount, 1);
    }
    
    /**
     * Set's a cell to a state and add it's state to the neighbours neighbours-count.
     * The grid is where the cell is set, and the gridCount is where the neighbours are counted.
     * @param col
     * @param row
     * @param state
     * @param grid
     * @param gridCount 
     */
    public void replaceCellValue(int col, int row, int state, int[][] grid, int[][][] gridCount) {
	addNeighbourCount(col, row, grid[row][col], gridCount, -1);
	grid[row][col] = state;
	addNeighbourCount(col, row, state, gridCount, 1);
    }
    
    /**
     * To all the neighbours of a cell, add val to the neighbour counter of a specific state. 
     * @param col
     * @param row
     * @param state
     * @param gridCount
     * @param val 
     */
    private void addNeighbourCount(int col, int row, int state, int[][][] gridCount, int val) {
	
	boolean cm = col > 0, cg = col < gridWidth - 1;
	boolean rm = row > 0, rg = row < gridHeight - 1;
	
	if (cm) {
	    gridCount[row][col - 1][state]+=val;
	    if (rm) gridCount[row - 1][col - 1][state]+=val;
	    if (rg) gridCount[row + 1][col - 1][state]+=val;
	}
	if (cg) {
	    gridCount[row][col + 1][state]+=val;
	    if (rm) gridCount[row - 1][col + 1][state]+=val;
	    if (rg) gridCount[row + 1][col + 1][state]+=val;
	}

	if (rm) gridCount[row - 1][col][state]+=val;
	if (rg) gridCount[row + 1][col][state]+=val;
    }
    
    
    private int[][][] newGridCount;
    private int[][] newGrid;
    /**
     * steps the simulation into the next timestep. The local rule is calculated
     * for every cell, then the calculated state is applied to the cell. \n The
     * number of cells in each state is counted, and so is the number of cells
     * that change state. Those value are then added in the Simulator.stats to
     * be tracked.
     */
    public void update() {
	int[] cellCount = new int[automata.getNumberOfStates()];

	for (int[][] row : newGridCount) {
	    for (int[] cell : row) {
		Arrays.fill(cell, 0);
	    }
	}

	int activity = 0;
	for (int i = 0; i < gridHeight; i++) {
	    for (int j = 0; j < gridWidth; j++) {
		cellCount[grid[j][i]]++;
		setCellValue(i, j,
			    automata.evaluate(gridCount[j][i], grid[j][i]),
			    newGrid, newGridCount);
		if (grid[i][j] != newGrid[i][j])
		    activity++;
		

	    }
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
     * @return returns the object which contains the values of the number of
     * cell in each state on each time step and the activity (number of cells
     * changed).
     */
    public Stats getStats() {
	return stats;
    }

}
