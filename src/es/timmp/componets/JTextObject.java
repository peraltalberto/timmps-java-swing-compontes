/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import es.timmp.componets.util.TZUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 *
 * @author aperalta
 */
public class JTextObject extends JTextField {
    
    
    private Object selectObject;
    private String propertyPrint;

    public JTextObject() {
        
    }

    public JTextObject( Object selectObject, Document doc, String text, int columns) {
        super(doc, text, columns);
       
        this.selectObject = selectObject;
    }
    JButton jb = new JButton("p");

    public JTextObject( Object selectObject, String text, int columns) {
        super(text, columns);
        
        this.selectObject = selectObject;
    }

    public JTextObject( Object selectObject, int columns) {
        super(columns);
        
        this.selectObject = selectObject;
    }

    public JTextObject( Object selectObject, String text) {
        super(text);
        
        this.selectObject = selectObject;
    }

    public JTextObject( Object selectObject) {
        
        this.selectObject = selectObject;
    }

    public Object getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Object selectObject) {
       
            this.selectObject = selectObject;
            this.updateText();
    }

    public void updateText(){
        try {
            
                    Method m = this.selectObject.getClass().getMethod(TZUtils.getName(this.propertyPrint));
                    this.setText(String.valueOf(m.invoke(this.selectObject)));
                    
        } catch (NullPointerException ex){
            this.setText("");        
            
        } catch (IllegalAccessException ex) {
            this.setText("");  
          
        } catch (IllegalArgumentException ex) {
            this.setText("");  
            
        } catch (InvocationTargetException ex) {
            this.setText("");  
            
        } catch (NoSuchMethodException ex) {
            this.setText("");  
            
        } catch (SecurityException ex) {
            this.setText("");  
            
        }
    
    }
    public String getPropertyPrint() {
        return propertyPrint;
    }

    public void setPropertyPrint(String propertyPrint) {
        this.propertyPrint = propertyPrint;
        this.updateText();
    }

   
    
    
}
