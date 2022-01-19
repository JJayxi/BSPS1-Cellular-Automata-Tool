
package automata.modular.conditions;

public class ConditionAnd implements Condition {
    protected Condition conditionLeft, conditionRight;
    public ConditionAnd(Condition conditionLeft, Condition conditionRight) {
	this.conditionLeft = conditionLeft;
	this.conditionRight = conditionRight;
    }
    
    @Override
    public boolean isTrue(int[] neighbourStateCount, int cellState) {
	return  conditionLeft.isTrue(neighbourStateCount, cellState) &&
		conditionRight.isTrue(neighbourStateCount, cellState);
    }
}
