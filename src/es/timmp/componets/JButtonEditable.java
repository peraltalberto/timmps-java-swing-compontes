/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

/**
 *
 * @author aperalta
 */
public class JButtonEditable extends JButton implements MouseMotionListener {

    private boolean edicion;
    public JButtonEditable(){
        super();
        edicion = false;
        addMouseMotionListener(this);
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        if(isEdicion()){
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
    public void resizeStart(){
        resice = new ResizeUI(this);
        this.getParent().add(resice);
    }
    public void resizeStop(){
        this.getParent().remove(resice);
    }
}
