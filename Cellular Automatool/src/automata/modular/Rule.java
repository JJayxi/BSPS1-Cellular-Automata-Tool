package automata.modular;

import automata.modular.conditions.Condition;

/**
 * A rule of a cellular automata; it contains a cell state it is applied to, 
 * a condition, and the state of that cell in the next time step if that condition
 * is true. 
 */
public class Rule {
    
    /**
     * the condition of the rule
     */
    protected Condition condition;
    
    /**
     * the state that the cell should have for this rule to isApplied
     */
    protected int cellState;
    /**
     * the state that this cell will have if the rule applies and the condition is true
     */
    protected int toState;
    
    /**
     * creates a new rule with the given parameters
     * @param cellState the state that the cell should have for this rule to isApplied
     * @param toState the state that this cell will have if the rule applies and the condition is true
     * @param condition the condition of the rule
     */
    public Rule(int cellState, int toState, Condition condition) {
	this.cellState = cellState;
	this.toState = toState;
	this.condition = condition;
    }
    
    /**
     * @param cellState change the state that the cell should have for this rule to isApplied
     */
    public void setCellState(int cellState) {
	this.cellState = cellState;
    }
    
    /**s
     * @param toState change the state that this cell will have if the rule applies 
     * and the condition is true
     */
    public void setToState(int toState) {
	this.toState = toState;
    }
    
    /**
     * @param neighbourStateCount an array that contains the number of cell in each state
     * @param cellState the state of the cell in the middle of the neighbours
     * @return returns wether the rule applies or not
     */
    public boolean isApplied(int[] neighbourStateCount, int cellState) {
	return  this.cellState == cellState && 
		condition.evaluate(neighbourStateCount, cellState);
    }
    
}
