package automata;

public interface Automaton {
    public int evaluate(int[] neighbourStateCount, int cellState);
    public int getNumberOfStates();
}
