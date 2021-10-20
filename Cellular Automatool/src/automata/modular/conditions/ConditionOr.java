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

    public void setConditionLeft(Condition conditionLeft) {
	this.conditionLeft = conditionLeft;
    }

    public Condition getConditionRight() {
	return conditionRight;
    }

    public void setConditionRight(Condition conditionRight) {
	this.conditionRight = conditionRight;
    }
    
    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return  conditionLeft.evaluate(neighbourStateCount, cellState) ||
		conditionRight.evaluate(neighbourStateCount, cellState);
    }
}
