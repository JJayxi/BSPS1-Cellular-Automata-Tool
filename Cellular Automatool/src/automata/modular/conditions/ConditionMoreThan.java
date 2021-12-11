package automata.modular.conditions;

public class ConditionMoreThan implements Condition{
    protected int number, applyState;
    
    public ConditionMoreThan(int applyState, int number) {
	this.applyState = applyState;
	this.number = number;
    }
    
    @Override
    public boolean isTrue(int[] neighbourStateCount, int cellState) {
	return neighbourStateCount[applyState] > number;
    }
}
