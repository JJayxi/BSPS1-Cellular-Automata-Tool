package automata.modular.conditions;

public class ConditionFactory {
    public static enum type {OR, AND, EQUAL, LESS, MORE}
    
    public static Condition getInstance(type conditionType, int... params) {
	switch(conditionType) {
	    case OR:
		return new ConditionOr(null, null);
	    case AND:
		return new ConditionAnd(null, null);
	    case EQUAL:
		return new ConditionNeighbourStateEqual(params[0], params[1]);
	    case LESS:
		return new ConditionNeighbourStateLessThan(params[0], params[1]);
	    case MORE:
		return new ConditionNeighbourStateMoreThan(params[0], params[1]);
	}
	
	return null;
    }
}