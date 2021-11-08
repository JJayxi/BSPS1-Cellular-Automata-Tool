package automata.modular.conditions;

public class ConditionTrue implements Condition {

    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return  true;
    }
}
