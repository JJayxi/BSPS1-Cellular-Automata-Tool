/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata.modular.conditions;

public class ConditionLessThan implements Condition{
    
    protected int number, applyState;
    
    public ConditionLessThan(int applyState, int number) {
	this.applyState = applyState;
	this.number = number;
    }
    
    @Override
    public boolean isTrue(int[] neighbourStateCount, int cellState) {
	return neighbourStateCount[applyState] < number;
    }
    
}
