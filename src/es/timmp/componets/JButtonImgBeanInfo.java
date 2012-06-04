/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import java.awt.Image;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author aperalta
 */
public class JButtonImgBeanInfo extends SimpleBeanInfo{
  Image icon;
     Image icon32;
     Image iconM;
     Image icon32M;
     
     public JButtonImgBeanInfo(){
         icon = loadImage("/es/timmp/componets/beanInfo/jbi16.png");
         icon32 = loadImage("/es/timmp/componets/beanInfo/jbi32.png");
         iconM = loadImage("/es/timmp/componets/beanInfo/jbi16.png");
         icon32M = loadImage("/es/timmp/componets/beanInfo/jbi32.png");
     }
     
     @Override
     public Image getIcon(int i){
         switch(i)
         {
         case 1:
             return icon;
 
         case 2:
             return icon32;
 
         case 3:
             return iconM;
 
         case 4:
             return icon32M;
         }
         return null;
    }
}
