package automata.modular;

import java.util.ArrayList;
import automata.Automata;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Automaton that can be edited by adding rules and changing the number of
 * possible states. There is no limit of rules.
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
     * Create a new cellular automata with no rules and a number of possible
     * states
     *
     * @param numberOfStates the number of states that exist in this cellular
     * automata
     */
    public ModularAutomata(int numberOfStates) {
	setNumberOfStates(numberOfStates);
    }

    /**
     * Set the number of states that this cellular automata can have
     *
     * @param numberOfStates the number of states that the cellular automata
     * should have
     */
    public void setNumberOfStates(int numberOfStates) {
	this.numberOfStates = numberOfStates;
    }

    /**
     * @param rule Rule that will be added in the rule list and will be
     * considered when calling the function evaluate
     */
    public void addRule(Rule rule) {
	rules.add(rule);
    }

    /**
     * Remove a rule in the rules array
     *
     * @param n Position in the rules array of the rule that will be removed
     */
    public void removeRule(int n) {
	rules.remove(n);
    }

    /**
     * @param n Position of the rule in an array
     * @return returns the Rule in that position in the ModularAutomata.rules
     * array
     */
    public Rule getRule(int n) {
	return rules.get(n);
    }

    /**
     * The local function that returns the state of the next cell according to
     * the local parameters
     *
     * @param neighbourStateCount an array that contains the number of cell in
     * each state
     * @param cellState the state of the cell that may change
     * @return the state of the cell in the next time step
     */
    @Override
    public int evaluate(int[] neighbourStateCount, int cellState) {
	for (Rule rule : rules) {
	    if (rule.isApplied(neighbourStateCount, cellState)) {
		return rule.toState;
	    }
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
    
    public String[] getStateStringArray() {
	String[] strings = new String[numberOfStates];
	for(int i = 0; i < numberOfStates; i++) {
	    strings[i] = "State " + i;
	}
	
	return strings;
    }
    
    private static void configureXStream(XStream xstream) {
	
	XStream.setupDefaultSecurity(xstream);
	xstream.allowTypesByWildcard(new String[] { 
        "automata.modular.*",
        "automata.modular.conditions.*",
        });
	
	xstream.alias("modularAutomata", automata.modular.ModularAutomata.class);
	xstream.alias("Rule", automata.modular.Rule.class);
	xstream.alias("equal", automata.modular.conditions.ConditionNeighbourStateEqual.class);
	xstream.alias("moreThan", automata.modular.conditions.ConditionNeighbourStateMoreThan.class);
	xstream.alias("lessThan", automata.modular.conditions.ConditionNeighbourStateLessThan.class);
	xstream.alias("and", automata.modular.conditions.ConditionAnd.class);
	xstream.alias("or", automata.modular.conditions.ConditionOr.class);
    }
    
    /**
     * @param filename The name of the file that this modularAutomata will be
     * saved to
     */
    public static void saveToXMLFile(ModularAutomata automata, String filename) {
	XStream xstream = new XStream(new DomDriver("UTF-8"));
	configureXStream(xstream);
	
	String xml = xstream.toXML(automata);

	try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
	    out.println(xml);
	} catch (IOException ex) {
	    System.err.println("Unable to save the file");
	}
    }
    
    /**
     * @param filename name of the XML file that contains the modular automata
     * @return returns a instance of Modular Automata corresponding to the XML file
     */
    public static ModularAutomata fromXMLFile(String filename) {
	XStream xstream = new XStream(new DomDriver("UTF-8"));
	configureXStream(xstream);
	
	try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
	    return (ModularAutomata) xstream.fromXML(in);
	} catch (com.thoughtworks.xstream.mapper.CannotResolveClassException e) {
	    System.err.println("Cannot create class from this XML file");
	} catch (IOException ex) {
	    System.err.println("Unable to load the file");
	}
	return null;
    }
}
