package gui;

import automata.Automata;
import automata.Simulator;
import automata.modular.ModularAutomata;
import automata.modular.Rule;
import automata.modular.conditions.ConditionNeighbourStateEqual;
import automata.modular.conditions.ConditionNeighbourStateLessThan;
import automata.modular.conditions.ConditionNeighbourStateMoreThan;
import automata.presets.RockPaperScissors;
import javax.swing.Timer;

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
	ModularAutomata modularGoL = new ModularAutomata(2);
	modularGoL.addRule(new Rule(0, 1, new ConditionNeighbourStateEqual(1, 3)));
	modularGoL.addRule(new Rule(1, 0, new ConditionNeighbourStateMoreThan(1, 3)));
	modularGoL.addRule(new Rule(1, 0, new ConditionNeighbourStateLessThan(1, 2)));
	ModularAutomata.saveToXMLFile(modularGoL, "gameOfLife.xml");
	
	Automata automata = new RockPaperScissors();

	//we set the running simulation to a new simulation that is 160 by 160 wide
	//and runs the previously made game of life
	simulator = new Simulator(150, 150, automata); //modularGoL);

	//we set the panel that displays simulations to display the current running simulation
	simulationPanel.setSimulator(simulator);

	//we set the panel that displays the graphics to display the statistics of the
	//current running simulation
	activityPanel.setStats(simulator.getStats());
	cellCountGraphPanel.setStats(simulator.getStats());

	/*
	we created a new timer whose speed depends on the value of the slider.
	For each tick, the timer:
	- updates the simulation
	- draws the simulation
	- draws the graphs
	 */
	timer = new Timer(simulationSpeedSlider.getValue(), (t) -> {
	    simulator.update();
	    simulationPanel.repaint();
	    activityPanel.repaint();
	    cellCountGraphPanel.repaint();
	});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        randomizeGridButton = new javax.swing.JButton();
        clearGridButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jSplitPane2 = new javax.swing.JSplitPane();
        simulationGroupPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        simulationSpeedSlider = new javax.swing.JSlider();
        pauseButton = new javax.swing.JButton();
        simulationPanel = new gui.SimulationPanel();
        skipStepsButton = new javax.swing.JButton();
        skipStepsTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        statsGroupPanel = new javax.swing.JPanel();
        activityPanel = new gui.stats.ActivityGraphPanel();
        jLabel2 = new javax.swing.JLabel();
        cellCountGraphPanel = new gui.stats.CellCountGraphPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        randomizeGridButton.setText("Randomize");
        randomizeGridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeGridButtonActionPerformed(evt);
            }
        });

        clearGridButton.setText("Clear");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(randomizeGridButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(clearGridButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(470, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jLabel3.setText("Speed:");

        simulationSpeedSlider.setMajorTickSpacing(50);
        simulationSpeedSlider.setMaximum(250);
        simulationSpeedSlider.setMinimum(2);
        simulationSpeedSlider.setValue(200);
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

        javax.swing.GroupLayout simulationPanelLayout = new javax.swing.GroupLayout(simulationPanel);
        simulationPanel.setLayout(simulationPanelLayout);
        simulationPanelLayout.setHorizontalGroup(
            simulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
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

        jButton1.setText("Load Automata");

        javax.swing.GroupLayout simulationGroupPanelLayout = new javax.swing.GroupLayout(simulationGroupPanel);
        simulationGroupPanel.setLayout(simulationGroupPanelLayout);
        simulationGroupPanelLayout.setHorizontalGroup(
            simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simulationGroupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(simulationGroupPanelLayout.createSequentialGroup()
                        .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, simulationGroupPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(simulationSpeedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, simulationGroupPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(skipStepsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(skipStepsTextField))))
                .addContainerGap())
        );
        simulationGroupPanelLayout.setVerticalGroup(
            simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simulationGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pauseButton)
                    .addComponent(skipStepsButton)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(simulationGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(simulationSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(skipStepsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(simulationGroupPanel);

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

        javax.swing.GroupLayout statsGroupPanelLayout = new javax.swing.GroupLayout(statsGroupPanel);
        statsGroupPanel.setLayout(statsGroupPanelLayout);
        statsGroupPanelLayout.setHorizontalGroup(
            statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statsGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cellCountGraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(activityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
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
                .addContainerGap(309, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(statsGroupPanel);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomizeGridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeGridButtonActionPerformed
	if (timer.isRunning()) {
	    pauseButton.doClick();
	}
	simulator.randomizeGrid();
	simulationPanel.repaint();
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
	simulationPanel.repaint();
	activityPanel.repaint();
	cellCountGraphPanel.repaint();
    }//GEN-LAST:event_skipStepsButtonActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton randomizeGridButton;
    private javax.swing.JPanel simulationGroupPanel;
    private gui.SimulationPanel simulationPanel;
    private javax.swing.JSlider simulationSpeedSlider;
    private javax.swing.JButton skipStepsButton;
    private javax.swing.JTextField skipStepsTextField;
    private javax.swing.JPanel statsGroupPanel;
    // End of variables declaration//GEN-END:variables
}
