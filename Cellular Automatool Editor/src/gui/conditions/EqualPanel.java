/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.conditions;

import automata.modular.ModularAutomata;
import automata.modular.conditions.ConditionEqual;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import util.MiscUtil;


public class EqualPanel extends javax.swing.JPanel {

    /**
     * Creates new form LessThanPanel
     */
    private ModularAutomata automata;
    private ConditionEqual equalCondition;
    public EqualPanel() {
	initComponents();
	
	
    }
    
    public void setAutomataAndCondition(ModularAutomata automata, ConditionEqual equalCondition) {
	
	this.equalCondition = equalCondition;
	
	if(this.automata == null || this.automata != automata) {
	    this.automata = automata;
	    stateComboBox.setRenderer(new EqualPanel.StateListCellRenderer());

	    for(String str : automata.getStateStringArray()) {
		stateComboBox.addItem(str);
	    }
	}
    }
    
    private class StateListCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            c.setBackground(MiscUtil.colorFromState(index, automata.getNumberOfStates()));
            return c;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numberComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox<>();

        jLabel1.setText("If  ");

        numberComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        numberComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                numberComboBoxItemStateChanged(evt);
            }
        });

        jLabel2.setText("neighbour in state ");

        stateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numberComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_numberComboBoxItemStateChanged
        equalCondition.setNumber(numberComboBox.getSelectedIndex());
    }//GEN-LAST:event_numberComboBoxItemStateChanged

    private void stateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateComboBoxItemStateChanged
        equalCondition.setApplyState(stateComboBox.getSelectedIndex());
    }//GEN-LAST:event_stateComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> numberComboBox;
    private javax.swing.JComboBox<String> stateComboBox;
    // End of variables declaration//GEN-END:variables
}
