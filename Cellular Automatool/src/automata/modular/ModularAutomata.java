package automata.modular;

import java.util.ArrayList;
import automata.Automata;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
	this.numberOfStates = numberOfStates;
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
    
    /**
     * 
     * @return Array of the names of the states. For the JList
     */
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
	xstream.alias("equal", automata.modular.conditions.ConditionEqual.class);
	xstream.alias("moreThan", automata.modular.conditions.ConditionMoreThan.class);
	xstream.alias("lessThan", automata.modular.conditions.ConditionLessThan.class);
	xstream.alias("and", automata.modular.conditions.ConditionAnd.class);
	xstream.alias("or", automata.modular.conditions.ConditionOr.class);
	xstream.alias("true", automata.modular.conditions.ConditionTrue.class);
    }
    
    /**
     * @param automata The automata that will be saved
     * @param filename The name of the file that this modularAutomata will be
     * saved to
     */
    public static void saveToXMLFile(ModularAutomata automata, String filename) throws Exception {
	XStream xstream = new XStream(new DomDriver("UTF-8"));
	configureXStream(xstream);
	
	String xml = xstream.toXML(automata);

	try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
	    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
	    out.println(xml);
	}
    }
    
    /**
     * @param filename name of the XML file that contains the modular automata
     * @return returns a instance of Modular Automata corresponding to the XML file
     */
    public static ModularAutomata fromXMLFile(String filename) throws Exception {
	XStream xstream = new XStream(new DomDriver("UTF-8"));
	configureXStream(xstream);
	
	try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
	    return (ModularAutomata) xstream.fromXML(in);
	}
    }
}
