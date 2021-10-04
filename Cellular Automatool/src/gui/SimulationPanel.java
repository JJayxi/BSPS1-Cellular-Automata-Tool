package gui;

import automata.GameOfLife;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class SimulationPanel extends javax.swing.JPanel {

    private GameOfLife gameOfLife;
    public SimulationPanel() {
	initComponents();
    }
    
    public void setGameOfLife(GameOfLife gameOfLife) {
	this.gameOfLife = gameOfLife;
    }
    
    @Override
    protected void paintComponent(Graphics g1) {
	Graphics2D g = (Graphics2D)g1;
	if(gameOfLife != null)gameOfLife.draw(g, getWidth(), getHeight());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
