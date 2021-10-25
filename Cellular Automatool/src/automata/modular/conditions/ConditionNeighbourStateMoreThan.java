package automata.modular.conditions;

public class ConditionNeighbourStateMoreThan implements Condition{
    protected int number, applyState;
    
    public ConditionNeighbourStateMoreThan(int applyState, int number) {
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
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return neighbourStateCount[applyState] > number;
    }
    
//    @Override
//    public String toFileString() {
//	return "{\n" + "state " + applyState + " count > " + number + "\n}";
//    }
}
