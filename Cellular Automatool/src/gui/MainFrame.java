package gui;

import automata.Automata;
import automata.Simulator;
import automata.modular.*;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.MiscUtil;

/**
 * Automatically generated class with the swing ui editor. The swing parts are
 * automatically created, the rest is done manually. This frame is the simulator
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * The simulator object which contains the running cellular automata
     */
    private Simulator simulator;

    /**
     * The timer allows to time the delay between each step of the cellular
     * automata.
     */
    private Timer timer;

    public MainFrame() {
	initComponents();	

	//Change the name of the window
	setTitle("Cellular Automatool");

	/*
	This is game of life created with the modular automata class.
	*/
//	ModularAutomata wireframe = new ModularAutomata(4);
//	wireframe.addRule(new Rule(1, 2, new ConditionTrue()));
//	wireframe.addRule(new Rule(2, 3, new ConditionTrue()));
//	wireframe.addRule(new Rule(3, 1, new ConditionNeighbourStateEqual(1, 1)));
//	wireframe.addRule(new Rule(3, 1, new ConditionNeighbourStateEqual(1, 2)));
//	ModularAutomata.saveToXMLFile(wireframe, "wireframe.xml");
	
	loadFromFile("gameOfLife.xml");

	/*
	we created a new timer whose speed depends on the value of the slider.
	For each tick, the timer:
	- updates the simulation
	- draws the simulation
	- draws the graphs
	 */
	timer = new Timer(simulationSpeedSlider.getValue(), (t) -> {
	    simulator.update();
	    updateView();
	});
    }
    
    private void updateView() {
	simulationPanel.repaint();
	activityPanel.repaint();
	cellCountGraphPanel.repaint();
	stepsCountLabel.setText(String.valueOf(simulator.getStats().getStepsCount()));
    }
    
    private void resetSimulation(Automata automata, int width, int height) {
	//we set the running simulation to a new simulation that is width by height wide
	//and runs the previously made game of life
	simulator = new Simulator(width, height, automata);
	
	//we set the panel that displays simulations to display the current running simulation
	simulationPanel.setSimulator(simulator);

	//we set the panel that displays the graphics to display the statistics of the
	//current running simulation
	activityPanel.setStats(simulator.getStats());
	cellCountGraphPanel.setStats(simulator.getStats());
    }
    
    private void resetSimulation() {
	 resetSimulation(simulator.getAutomata(), 
			Integer.valueOf(simulationSizeTextField.getText()),
			Integer.valueOf(simulationSizeTextField.getText()));
    }
    
    private void loadFromFile(String filename) {
	ModularAutomata automata = ModularAutomata.fromXMLFile(filename);
	stateList.setListData(automata.getStateStringArray());
	stateList.setSelectedIndex(0);
	//color the items in the list
	stateList.setCellRenderer(new StateListCellRenderer());
	
	resetSimulation(automata, 
			Integer.valueOf(simulationSizeTextField.getText()),
			Integer.valueOf(simulationSizeTextField.getText()));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simulationGroupPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        simulationSpeedSlider = new javax.swing.JSlider();
        pauseButton = new javax.swing.JButton();
        simulationPanel = new gui.SimulationPanel();
        skipStepsButton = new javax.swing.JButton();
        skipStepsTextField = new javax.swing.JTextField();
        loadAutomataButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        randomizeGridButton = new javax.swing.JButton();
        clearGridButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stateList = new javax.swing.JList();
        simulationSizeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        statsGroupPanel = new javax.swing.JPanel();
        activityPanel = new gui.stats.ActivityGraphPanel();
        jLabel2 = new javax.swing.JLabel();
        cellCountGraphPanel = new gui.stats.CellCountGraphPanel();
        jLabel1 = new javax.swing.JLabel();
        clearStatsButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        stepsCountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Speed:");

        simulationSpeedSlider.setMajorTickSpacing(50);
        simulationSpeedSlider.setMaximum(250);
        simulationSpeedSlider.setMinimum(2);
        simulationSpeedSlider.setValue(100);
        simulationSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                simulationSpeedSliderStateChanged(evt);
            }
        });

        pauseButton.setText("Start");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        simulationPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        simulationPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simulationPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout simulationPanelLayout = new javax.swing.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        simulationPanelLayout.setVerticalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        skipStepsButton.setText("Skip steps");
        skipStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipStepsButtonActionPerformed(evt);
            }
        });

        loadAutomataButton.setText("Load Automata");
        loadAutomataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAutomataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout simulationGroupPanelLayout = new javax.swing.GroupLayout(simulationGroupPanel);
        simulationGroupPanel.setLayout(simulationGroupPanelLayout);
        simulationGroupPanelLayout.setHorizontalGroup(
            simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulationGroupPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, simulationGroupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simulationSpeedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, simulationGroupPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(loadAutomataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(skipStepsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(skipStepsTextField))
                .addGap(241, 241, 241))
            .addComponent(simulationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        simulationGroupPanelLayout.setVerticalGroup(
            simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationGroupPanelLayout.createSequentialGroup()
                .addComponent(simulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pauseButton)
                    .addComponent(skipStepsButton)
                    .addComponent(loadAutomataButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(simulationSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(skipStepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        randomizeGridButton.setText("Randomize");
        randomizeGridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeGridButtonActionPerformed(evt);
            }
        });

        clearGridButton.setText("Clear");
        clearGridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGridButtonActionPerformed(evt);
            }
        });

        stateList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(stateList);

        simulationSizeTextField.setText("150");
        simulationSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulationSizeTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Size:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(randomizeGridButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearGridButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simulationSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(randomizeGridButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearGridButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simulationSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout activityPanelLayout = new javax.swing.GroupLayout(activityPanel);
        activityPanel.setLayout(activityPanelLayout);
        activityPanelLayout.setHorizontalGroup(
            activityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        activityPanelLayout.setVerticalGroup(
            activityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Activity");

        javax.swing.GroupLayout cellCountGraphPanelLayout = new javax.swing.GroupLayout(cellCountGraphPanel);
        cellCountGraphPanel.setLayout(cellCountGraphPanelLayout);
        cellCountGraphPanelLayout.setHorizontalGroup(
            cellCountGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        cellCountGraphPanelLayout.setVerticalGroup(
            cellCountGraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("State Distribution");

        clearStatsButton.setText("Clear Stats");
        clearStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStatsButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Steps Count:");

        stepsCountLabel.setText(" ");

        javax.swing.GroupLayout statsGroupPanelLayout = new javax.swing.GroupLayout(statsGroupPanel);
        statsGroupPanel.setLayout(statsGroupPanelLayout);
        statsGroupPanelLayout.setHorizontalGroup(
            statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cellCountGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(statsGroupPanelLayout.createSequentialGroup()
                        .addComponent(clearStatsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stepsCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statsGroupPanelLayout.setVerticalGroup(
            statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cellCountGraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearStatsButton)
                    .addComponent(jLabel5)
                    .addComponent(stepsCountLabel))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simulationGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statsGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simulationGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statsGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomizeGridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeGridButtonActionPerformed
	if (timer.isRunning()) pauseButton.doClick();
	
	simulator.randomizeGrid();
	updateView();
    }//GEN-LAST:event_randomizeGridButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
	if (timer.isRunning()) {
	    timer.stop();
	    pauseButton.setText("Continue");
	} else {
	    timer.start();
	    pauseButton.setText("Pause");
	}
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void simulationSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_simulationSpeedSliderStateChanged
	timer.setDelay(simulationSpeedSlider.getValue());
    }//GEN-LAST:event_simulationSpeedSliderStateChanged

    private void skipStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipStepsButtonActionPerformed
	for (int i = 0; i < Integer.valueOf(skipStepsTextField.getText()); i++) {
	    simulator.update();
	}
	updateView();
    }//GEN-LAST:event_skipStepsButtonActionPerformed

    private void simulationSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationSizeTextFieldActionPerformed
        if (timer.isRunning()) pauseButton.doClick();
	resetSimulation();
	updateView();
    }//GEN-LAST:event_simulationSizeTextFieldActionPerformed

    private void clearGridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearGridButtonActionPerformed
        if (timer.isRunning()) pauseButton.doClick();
	simulator.clearToState(stateList.getSelectedIndex());
	updateView();
    }//GEN-LAST:event_clearGridButtonActionPerformed

    private void loadAutomataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAutomataButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
	fileChooser.setAcceptAllFileFilterUsed(false);
	fileChooser.setFileFilter(new FileNameExtensionFilter("automaton .xml file", "xml"));
	if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    loadFromFile(fileChooser.getSelectedFile().getAbsolutePath());
	    updateView();
	}

    }//GEN-LAST:event_loadAutomataButtonActionPerformed

    private void clearStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStatsButtonActionPerformed
        simulator.getStats().clear();
	updateView();
    }//GEN-LAST:event_clearStatsButtonActionPerformed

    private void simulationPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulationPanelMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
	    simulationPanel.setCell(evt, stateList.getSelectedIndex());
	    repaint();
	}
    }//GEN-LAST:event_simulationPanelMouseClicked
    
    // <editor-fold defaultstate="collapsed" desc="StateListRenderer">
    //Thank this legend: https://coderanch.com/t/335943/java/Changing-background-color-JList
    private class StateListCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            c.setBackground(MiscUtil.colorFromState(index, simulator.getAutomata().getNumberOfStates()));
            return c;
        }
    }
    //</editor-fold>
    
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Windows".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new MainFrame().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.stats.ActivityGraphPanel activityPanel;
    private gui.stats.CellCountGraphPanel cellCountGraphPanel;
    private javax.swing.JButton clearGridButton;
    private javax.swing.JButton clearStatsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadAutomataButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton randomizeGridButton;
    private javax.swing.JPanel simulationGroupPanel;
    private gui.SimulationPanel simulationPanel;
    private javax.swing.JTextField simulationSizeTextField;
    private javax.swing.JSlider simulationSpeedSlider;
    private javax.swing.JButton skipStepsButton;
    private javax.swing.JTextField skipStepsTextField;
    private javax.swing.JList stateList;
    private javax.swing.JPanel statsGroupPanel;
    private javax.swing.JLabel stepsCountLabel;
    // End of variables declaration//GEN-END:variables
}
