/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import java.awt.Component;
import java.awt.event.MouseEvent;

/**
 *
 * @author aperalta
 */
public class ResizeUI extends JButtonEditable{
    
   Component c;
    public ResizeUI(Component component){
        super.setEdicion(true);
        super.setText("+");
        super.setBounds(component.getX()+component.getWidth()+10, component.getY()+component.getHeight()+10,10 ,10);
        this.c = component;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        super.mouseDragged(me);
        c.setBounds(c.getX(), c.getY(), this.getX()-c.getX()-10,this.getY()-c.getY()-10);
    }
    
}
