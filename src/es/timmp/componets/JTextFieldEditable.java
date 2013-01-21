package es.timmp.componets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author aperalta
 */
public class JTextFieldEditable extends JTextField implements MouseMotionListener {

    private boolean edicion;
    public JTextFieldEditable(){
        super();
        edicion = false;
        addMouseMotionListener(this);
    }
  
    
    @Override
    public void mouseDragged(MouseEvent me) {
        if(isEdicion() && !start){
        super.setLocation(
                super.getX() + me.getX() - super.getWidth() / 2,
                super.getY() + me.getY() - super.getHeight() / 2);
        }
       
   }
       

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    ResizeUI resice;
    boolean start = false;
    public void resizeStart(){
        start = true;
        resice = new ResizeUI(this);
        this.getParent().add(resice);
        this.getParent().repaint();
    }
    public void resizeStop(){
        start = false;
        this.getParent().remove(resice);
        this.getParent().repaint();
    }
    
}