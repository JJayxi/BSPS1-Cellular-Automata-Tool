package automata.modular.conditions;

public class ConditionAnd implements Condition {
    protected Condition conditionLeft, conditionRight;
    public ConditionAnd(Condition conditionLeft, Condition conditionRight) {
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
    public String toString() {
	return "\t(" + 
		((conditionLeft != null) ? conditionLeft.toString() : "not set")
		+ ")\n and \n\t(" + 
		((conditionRight != null) ? conditionRight.toString() : "not set")
		+ ")";
    }
}
