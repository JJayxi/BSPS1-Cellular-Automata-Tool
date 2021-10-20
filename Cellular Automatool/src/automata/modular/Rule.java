package automata.modular;

import automata.modular.conditions.Condition;

public class Rule {
    protected Condition condition;
    protected int cellState, toState;
    
    public Rule(int cellState, int toState, Condition condition) {
	this.cellState = cellState;
	this.toState = toState;
	this.condition = condition;
    }
    
    public void setCellState(int cellState) {
	this.cellState = cellState;
    }
    
    public void setToState(int toState) {
	this.toState = toState;
    }
    
    public boolean apply(int[] neighbourStateCount, int cellState) {
	return  this.cellState == cellState && 
		condition.evaluate(neighbourStateCount, cellState);
    }
    
}
