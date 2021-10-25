/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata.modular.conditions;

public class ConditionNeighbourStateLessThan implements Condition{
    
    protected int number, applyState;
    
    public ConditionNeighbourStateLessThan(int applyState, int number) {
	this.applyState = applyState;
	this.number = number;
    }
    
    public void setApplyState(int applyState) {
	this.applyState = applyState;
    }
    
    public void setNumber(int number) {
	this.number = number;
    }
    
    @Override
    public boolean evaluate(int[] neighbourStateCount, int cellState) {
	return neighbourStateCount[applyState] < number;
    }
    
//    @Override
//    public String toFileString() {
//	return "{\n" + "state " + applyState + " count < " + number + "\n}";
//    }
    
}
