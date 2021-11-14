package automata.modular.conditions;

public class ConditionAnd implements Condition {
    protected Condition conditionLeft, conditionRight;
    public ConditionAnd(Condition conditionLeft, Condition conditionRight) {
	this.conditionLeft = conditionLeft;
	this.conditionRight = conditionRight;
    }
    
    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return  conditionLeft.evaluate(neighbourStateCount, cellState) &&
		conditionRight.evaluate(neighbourStateCount, cellState);
    }
}
