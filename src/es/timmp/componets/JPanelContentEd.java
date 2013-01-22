/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import es.timmp.componets.util.TZUtils;
import java.awt.Component;
import java.awt.LayoutManager;
import java.io.File;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author aperalta
 */
public class JPanelContentEd extends JPanel {

    private String xml = "<panel><components>"
            + "<component name=\"JButton\" class=\"javax.swing.JButton\" "
            + "x=\"50\" y=\"50\" widht=\"50\" heigth=\"50\">"
            + "<text>prueba</text>"
            + "</component></components></panel>";
    
    
    
    
    
    
    
    
    
    public void setComponents(String xml){
     try {
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xml));

	  Document doc = dBuilder.parse(is);
	  doc.getDocumentElement().normalize();

	  System.out.println("El elemento raÃ­z es: " + doc.getDocumentElement().getNodeName());
	  NodeList componentes = doc.getElementsByTagName("component");

	  for (int i = 0; i < componentes.getLength(); i ++) {

	    Node persona = componentes.item(i);

	    if (persona.getNodeType() == Node.ELEMENT_NODE) {

            Element elemento = (Element) persona;
            System.out.println("clase"+ elemento.getAttribute("class"));
            Class c = Class.forName(elemento.getAttribute("class"));
            Component o = (Component) c.newInstance();
            
            NodeList ndl = elemento.getChildNodes();
            for (int j = 0; j < ndl.getLength(); j ++) {
                Node nd = ndl.item(0);
                System.out.println(nd.getNodeName());
                Class[] types = new Class[] {String.class};
                for (Method m : c.getMethods()){
                   
                   if(m.getName().equals(TZUtils.setName(nd.getNodeName()))){
                         System.out.println(m.getName()+" -- "+TZUtils.setName(nd.getNodeName()));
                         m.invoke(o,getTagValue(nd.getNodeName(),elemento));
                   }
                }
                o.setBounds(Integer.parseInt(elemento.getAttribute("x")), 
                    Integer.parseInt(elemento.getAttribute("y")), 
                    Integer.parseInt(elemento.getAttribute("widht")), 
                    Integer.parseInt(elemento.getAttribute("heigth")));
                    o.setName(elemento.getAttribute("name"));
                
                this.add((Component)c.cast(o));
            }

	    }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }

    }
   
    @Override
    public void setLayout(LayoutManager mgr) {
        super.setLayout(null);
        System.err.println("This component does not support layout");
    }
   
    public String getXmlComponents(){
        String xml = "<panel>\n\t<components>";
        Component[] cp = this.getComponents();
        for(Component c : cp){
            
                System.out.println(c.getClass());
                xml += "\n\t\t<component name=\""+c.getName()+"\" class=\""+c.getClass().getName()+"\" "
                + "x=\""+c.getX()+"\" y=\""+c.getY()+"\" widht=\""+c.getWidth()
            
                        +"\" heigth=\""+c.getHeight()+"\">";
           try {
                try {
                    xml += "\n\t\t\t<text>"+c.getClass().getMethod("getText").invoke(c) +"</text>";
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(JPanelContentEd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(JPanelContentEd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(JPanelContentEd.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(JPanelContentEd.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(JPanelContentEd.class.getName()).log(Level.SEVERE, null, ex);
            }
           xml += "\n\t\t</component>";
        }
        xml +="\n\t</components>\n</panel>";
        return xml;
    
    }
    
    
    private static String getTagValue(String sTag, Element eElement)
 {
	  NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	  Node nValue = (Node) nlList.item(0);

	  return nValue.getNodeValue();

 }
     public static void main(String args[]) {
        JPanelContentEd jp = new JPanelContentEd();
        jp.setComponents("");
        
    }
}
