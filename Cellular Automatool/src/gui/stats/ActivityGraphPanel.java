package gui.stats;

import automata.stats.Stats;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class ActivityGraphPanel extends javax.swing.JPanel {
    
    private Stats stats;

    public ActivityGraphPanel() {
	initComponents();
    }
    
    public void setStats(Stats stats) {
	this.stats = stats;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	if(stats != null)stats.showActivity((Graphics2D)g, getWidth(), getHeight());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}