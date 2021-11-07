package gui;

import automata.SimulationDisplayer;
import automata.Simulator;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.SwingUtilities;


public class SimulationPanel extends javax.swing.JPanel {

    private SimulationDisplayer simulationDisplayer;
    public SimulationPanel() {
	initComponents();
    }
    
    public void setSimulator(Simulator simulator) {
	if(simulationDisplayer == null)
	    simulationDisplayer = new SimulationDisplayer(simulator, getWidth(), getHeight());
	else
	    simulationDisplayer.setSimulator(simulator);
    }
    
    @Override
    protected void paintComponent(Graphics g1) {
	Graphics2D g = (Graphics2D)g1;
	
	
	if(simulationDisplayer != null){
	    simulationDisplayer.draw(g, getWidth(), getHeight());
	    
	    if(currMouse != null) 
		simulationDisplayer.highlightCell(g, 
			simulationDisplayer.screenToSim(currMouse));
	}
    }
    
    public void setCell(MouseEvent evt, int state) {
	Point2D cellPos = simulationDisplayer.screenToSim(evt.getPoint());
	
	Simulator simulator = simulationDisplayer.getSimulator();
	
	if( cellPos.getX() < 0 || cellPos.getY() < 0 || 
	    cellPos.getX() > simulator.gridWidth - 1 ||
	    cellPos.getY() > simulator.gridHeight - 1 )return;
	
	simulator.replaceCellValue((int)cellPos.getX(), (int)cellPos.getY(), state);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

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
    
    
    private Point2D prevMouse, currMouse;
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(SwingUtilities.isRightMouseButton(evt)) {
	    simulationDisplayer.pan(
		    new Point2D.Double(
			    evt.getX() - prevMouse.getX(),
			    evt.getY() - prevMouse.getY()));
	    prevMouse.setLocation(evt.getPoint());
	    repaint();
	}
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(SwingUtilities.isRightMouseButton(evt))
	    prevMouse = evt.getPoint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        simulationDisplayer.changeZoom(evt.getWheelRotation(), evt.getPoint());
	repaint();
    }//GEN-LAST:event_formMouseWheelMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        currMouse = evt.getPoint();
	repaint();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
