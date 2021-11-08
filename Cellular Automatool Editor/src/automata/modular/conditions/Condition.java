package automata.modular.conditions;

/**
 * A condition that takes in parameters and says wether it is true or not
 */
public interface Condition {
    /**
     * the function that evaluates wether the condition is true or false depending on the parameters
     * @param neighbourStateCount
     * @param cellState
     * @return returns true or false 
     */
    public boolean evaluate(int[] neighbourStateCount, int cellState);
}
