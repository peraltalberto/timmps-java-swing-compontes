/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmp.componets;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author aperalta
 */
public class JButtonImg extends JLabel implements MouseListener {

    ImageIcon imgRelax;
    ImageIcon imgOver;
    ImageIcon imgPress;
    
    public JButtonImg() {
       super("");
        this.imgRelax = new ImageIcon(getClass().getResource("/es/timmp/componets/resources/onRelax.png"));
        this.imgOver = new javax.swing.ImageIcon(getClass().getResource("/es/timmp/componets/resources/onOver.png"));
        this.imgPress = new javax.swing.ImageIcon(getClass().getResource("/es/timmp/componets/resources/onPress.png"));
        super.setIcon(this.imgRelax);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        super.addMouseListener(this);
    }

    public JButtonImg(ImageIcon imgRelax, ImageIcon imgOver, ImageIcon imgPress) {
        this.imgRelax = imgRelax;
        this.imgOver = imgOver;
        this.imgPress = imgPress;
        super.setIcon(this.imgRelax);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        super.addMouseListener(this);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        super.setIcon(this.imgPress);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.setIcon(this.imgOver);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.setIcon(this.imgOver);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.setIcon(this.imgRelax);
    }

    public ImageIcon getImgOver() {
        return imgOver;
    }

    public void setImgOver(ImageIcon imgOver) {
        this.imgOver = imgOver;
    }

    public ImageIcon getImgPress() {
        return imgPress;
    }

    public void setImgPress(ImageIcon imgPress) {
        this.imgPress = imgPress;
    }

    public ImageIcon getImgRelax() {
        return imgRelax;
    }

    public void setImgRelax(ImageIcon imgRelax) {
        this.imgRelax = imgRelax;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Prueba de evento");
    }
    
}
