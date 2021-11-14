package automata.modular.conditions;

public class ConditionOr implements Condition {
        protected Condition conditionLeft, conditionRight;
    public ConditionOr(Condition conditionLeft, Condition conditionRight) {
	this.conditionLeft = conditionLeft;
	this.conditionRight = conditionRight;
    }

    public Condition getConditionLeft() {
	return conditionLeft;
    }

    public Condition getConditionRight() {
	return conditionRight;
    }
    
    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return  conditionLeft.evaluate(neighbourStateCount, cellState) ||
		conditionRight.evaluate(neighbourStateCount, cellState);
    }
}
