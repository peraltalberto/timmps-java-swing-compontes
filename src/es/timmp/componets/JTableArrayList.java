/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import es.timmp.componets.util.TZUtils;
import es.timmp.exceptions.TimmpsException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aperalta
 */
public class JTableArrayList<T> extends JTable implements MouseListener {

    ArrayList<T> list;
    T selectObject;
    HashMap caps;
    DefaultTableModel model = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            return isTableEditable( row,  column);
        }
    };
    String propertyCaps[];
    String valuesCaps[];
    boolean editDef;
    
    public boolean isTableEditable(int row, int column){
        return editDef;
    }

    public boolean isEditDef() {
        return editDef;
    }

    public void setEditDef(boolean editDef) {
        this.editDef = editDef;
    }
    
    
    public JTableArrayList() {
        super(null,null,null);
     
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        System.out.println(list.size());
        this.list = list;
        System.out.println(this.list.size());
        cargarFilas();

    }

   
    public DefaultTableModel getDefaultModel() {
        return model;
    }

    public HashMap getCaps() {
        return caps;
    }

    public void setCaps(HashMap caps) {
        this.caps = caps;
        cargarColumnas();
    }

    public void setCaps(String[] properties, String[] strings) {
        HashMap hm = new HashMap();
        if (properties.length != strings.length) {
            new TimmpsException("properties distinto tamaño que strings");
        } else {
            for (int i = 0; i < properties.length; i++) {
                hm.put(properties[i], strings[i]);
            }
            this.caps = hm;
            cargarColumnas();
        }


    }

    public void addElement(T e) {
        list.add(e);
        cargarFilas();
    }
    public T getSelectElement(){
        return list.get(this.getSelectedRow());
    }
    private void cargarColumnas() {

        if (this.model.getColumnCount() > 0) {
            //this.model = new DefaultTableModel();
            HashMap cabs = this.caps;
            this.model.setColumnIdentifiers(cabs.values().toArray());

        }else{ 
            HashMap cabs = this.caps;
            Iterator it = cabs.keySet().iterator();
            while (it.hasNext()) {
                this.model.addColumn(cabs.get(it.next()));
            }
        }
        super.setModel(model);
    }

    private void cargarFilas() {
        try {
            HashMap cabs = this.caps;
           if (this.model.getRowCount() > 0) {
               //this.model = new DefaultTableModel();
               //System.out.println("tamaño: "+this.model.getRowCount()); 
               for (int i = this.model.getRowCount()-1; i >=0 ; i--) {
                  // System.out.println(i); 
                   this.model.removeRow(i);
                    
                }
            }
            
            for (int i = 0; i < this.list.size(); i++) {
                Object[] fila = new Object[cabs.size()];;
                Object o = this.list.get(i);
                int x = 0;
                Iterator itt = cabs.keySet().iterator();
                while (itt.hasNext()) {
                    try {

                        Method m = o.getClass().getMethod(TZUtils.getName((String) itt.next()));

                        if (!m.getReturnType().equals(Set.class)) {
                            fila[x] = m.invoke(o);
                        }

                    } catch (IllegalAccessException ex) {
                    } catch (IllegalArgumentException ex) {
                    } catch (InvocationTargetException ex) {
                    } catch (NoSuchMethodException ex) {
                    } catch (SecurityException ex) {
                    }
                    x++;
                }
                model.addRow(fila);
            }

            super.setModel(model);
        } catch (NullPointerException e) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
