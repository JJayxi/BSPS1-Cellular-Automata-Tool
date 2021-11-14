package automata.modular;

import automata.modular.conditions.Condition;

public class ConditionWrapper {
    public Condition condition;
    public ConditionWrapper(Condition condition) {
	this.condition = condition;
    }
}