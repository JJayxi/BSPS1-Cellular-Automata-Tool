package automata.modular.conditions;

public class ConditionMoreThan implements Condition{
    protected int number, applyState;
    
    public ConditionMoreThan(int applyState, int number) {
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
	return "Has more than " + number + " neighbour cells in state " + applyState;
    }
    
}
