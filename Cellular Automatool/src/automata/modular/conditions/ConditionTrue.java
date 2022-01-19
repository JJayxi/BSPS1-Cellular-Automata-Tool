
package automata.modular.conditions;

public class ConditionTrue implements Condition {

    @Override
    public boolean isTrue(int[] neighbourStateCount, int cellState) {
	return  true;
    }
}
