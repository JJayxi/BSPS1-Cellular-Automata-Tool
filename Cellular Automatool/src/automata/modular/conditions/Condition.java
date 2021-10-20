package automata.modular.conditions;

public interface Condition {
    public boolean evaluate(int[] neighbourStateCount, int cellState);
}
