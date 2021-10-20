package automata.modular;

import automata.Automaton;
import java.util.ArrayList;

public class ModularAutomaton implements Automaton {
    
    private int numberOfStates;
    private ArrayList<Rule> rules = new ArrayList<>();
    
    public ModularAutomaton(int numberOfStates) {
	setNumberOfStates(numberOfStates);
    }
    
    public void setNumberOfStates(int numberOfStates) {
	this.numberOfStates = numberOfStates;
    }	    
    
    public void addRule(Rule rule) {
	rules.add(rule);
    }
    
    @Override
    public int evaluate(int[] neighbourStateCount, int cellState) {
	for(Rule rule : rules) {
	    if(rule.apply(neighbourStateCount, cellState))
		return rule.toState;
	}
	return cellState;
    }

    @Override
    public int getNumberOfStates() {
	return numberOfStates;
    }
    
}
