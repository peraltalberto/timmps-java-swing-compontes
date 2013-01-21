/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import java.awt.event.MouseMotionListener;

/**
 *
 * @author aperalta
 */
public interface EditableComponents {
    public abstract boolean isEdicion();
    public abstract void setEdicion();
    public abstract void startResize();
}
