package automata.modular;

import java.util.ArrayList;
import automata.Automata;
/**
 * Automaton that can be edited by adding rules and changing the number of possible states.
 * There is no limit of rules.
 */
public class ModularAutomata implements Automata {
    
    /**
     * The number of states that this automata can have
     */
    private int numberOfStates;
    /**
     * contains the list of all the rules that this automata can have
     */
    private ArrayList<Rule> rules = new ArrayList<>();
    
    /**
     * Create a new cellular automata with no rules and a number of possible states 
     * @param numberOfStates the number of states that exist in this cellular automata
     */
    public ModularAutomata(int numberOfStates) {
	setNumberOfStates(numberOfStates);
    }
    
    /**
     * Set the number of states that this cellular automata can have
     * @param numberOfStates the number of states that the cellular automata should have
     */
    public void setNumberOfStates(int numberOfStates) {
	this.numberOfStates = numberOfStates;
    }	    
    
    /**
     * @param rule Rule that will be added in the rule list and will be considered
     * when calling the function evaluate
     */
    public void addRule(Rule rule) {
	rules.add(rule);
    }
    
    /**
     * Remove a rule in the rules array
     * @param n Position in the rules array of the rule that will be removed
     */
    public void removeRule(int n) {
	rules.remove(n);
    }
    
    /**
     * @param n Position of the rule in an array
     * @return returns the Rule in that position in the ModularAutomata.rules array
     */
    public Rule getRule(int n) {
	return rules.get(n);
    }
    
    /**
     * The local function that returns the state of the next cell according to the
     * local parameters
     * @param neighbourStateCount an array that contains the number of cell in each state
     * @param cellState the state of the cell that may change
     * @return the state of the cell in the next time step
     */
    @Override
    public int evaluate(int[] neighbourStateCount, int cellState) {
	for(Rule rule : rules) {
	    if(rule.isApplied(neighbourStateCount, cellState))
		return rule.toState;
	}
	return cellState;
    }

    /**
     * @return returns the number of states that exists in this automata
     */
    @Override
    public int getNumberOfStates() {
	return numberOfStates;
    }
    
}
