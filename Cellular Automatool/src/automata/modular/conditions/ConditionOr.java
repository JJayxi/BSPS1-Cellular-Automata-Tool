
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
    public boolean isTrue(int[] neighbourStateCount, int cellState) {
	return  conditionLeft.isTrue(neighbourStateCount, cellState) ||
		conditionRight.isTrue(neighbourStateCount, cellState);
    }
}