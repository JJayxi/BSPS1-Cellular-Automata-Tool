/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import automata.modular.ConditionWrapper;
import automata.modular.ModularAutomata;
import automata.modular.Rule;
import automata.modular.conditions.ConditionLessThan;
import java.awt.Component;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import util.MiscUtil;

/**
 *
 * @author jam
 */
public class RuleFrame extends javax.swing.JFrame {

    private ModularAutomata automata;
    private Rule rule;
    public RuleFrame(JFrame parent, ModularAutomata automata, Rule rule) {
	initComponents();
	this.automata = automata;
	this.rule = rule;
	cellStateComboBox.removeAllItems();
	toStateComboBox.removeAllItems();
	
	
	cellStateComboBox.setRenderer(new StateListCellRenderer());
	toStateComboBox.setRenderer(new StateListCellRenderer());
	
	for(String str : automata.getStateStringArray()) {
	    cellStateComboBox.addItem(str);
	    toStateComboBox.addItem(str);
	}
	
	setVisible(true);
	setAlwaysOnTop(true);
	parent.setEnabled(false);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
	addWindowListener(new java.awt.event.WindowAdapter() {
	@Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		parent.setEnabled(true);
		dispose();
	    }
	});
    }
    
    private class StateListCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            c.setBackground(MiscUtil.colorFromState(index, automata.getNumberOfStates()));
            return c;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cellStateComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        toStateComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        conditionTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        setConditionButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cellStateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cellStateComboBoxItemStateChanged(evt);
            }
        });

        jLabel1.setText("Applies to state:");

        jLabel2.setText("To state:");

        toStateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toStateComboBoxItemStateChanged(evt);
            }
        });

        conditionTextArea.setColumns(20);
        conditionTextArea.setRows(5);
        jScrollPane1.setViewportView(conditionTextArea);

        jLabel3.setText("Condition:");

        setConditionButton.setText("Set Condition");
        setConditionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setConditionButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cellStateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(toStateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(setConditionButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(saveButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cellStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(setConditionButton)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setConditionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setConditionButtonActionPerformed
        ConditionWrapper conditionWrapper = new ConditionWrapper(rule.getCondition());
	
	if(conditionWrapper.condition == null)conditionWrapper.condition = new ConditionLessThan(1, 0);
	
	setEnabled(false);
	new ConditionFrame(this, automata, conditionWrapper)
	.addWindowListener(new java.awt.event.WindowAdapter() {
	@Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		rule.setCondition(conditionWrapper.condition);
		conditionTextArea.setText(conditionWrapper.condition.toString());
	    }
	});
    }//GEN-LAST:event_setConditionButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cellStateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cellStateComboBoxItemStateChanged
        rule.setCellState(cellStateComboBox.getSelectedIndex());
    }//GEN-LAST:event_cellStateComboBoxItemStateChanged

    private void toStateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toStateComboBoxItemStateChanged
        rule.setToState(toStateComboBox.getSelectedIndex());
    }//GEN-LAST:event_toStateComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cellStateComboBox;
    private javax.swing.JTextArea conditionTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton setConditionButton;
    private javax.swing.JComboBox toStateComboBox;
    // End of variables declaration//GEN-END:variables
}
