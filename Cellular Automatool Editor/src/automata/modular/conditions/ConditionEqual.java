package automata.modular.conditions;

public class ConditionEqual implements Condition{
    protected int number, applyState;
    
    public ConditionEqual(int applyState, int number) {
	this.applyState = applyState;
	this.number = number;
    }
    
    public void setApplyState(int applyState) {
	this.applyState = applyState;
    }
    
    public void setNumber(int number) {
	this.number = number;
    }
    
    @Override
    public String toString() {
	return "Has exactly " + number + " neighbour cells in state " + applyState;
    }
}
