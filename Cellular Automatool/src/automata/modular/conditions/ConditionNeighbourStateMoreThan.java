package automata.modular.conditions;

public class ConditionNeighbourStateMoreThan implements Condition{
    protected int number, applyState;
    
    public ConditionNeighbourStateMoreThan(int applyState, int number) {
	this.applyState = applyState;
	this.number = number;
    }
    
    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return neighbourStateCount[applyState] > number;
    }
}
