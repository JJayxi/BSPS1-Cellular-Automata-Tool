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
    
    public void setApplyState(int applyState) {
	this.applyState = applyState;
    }
    
    public void setNumber(int number) {
	this.number = number;
    }
    
    @Override
    public String toString() {
	return "Has less than " + number + " neighbour cells in state " + applyState;
    }
}
