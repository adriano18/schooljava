package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by AdrianP on 05.06.2017.
 */
public class Placeholder extends JTextField {
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if(getText().isEmpty()){
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setBackground(Color.lightGray);
            g2.setColor(Color.lightGray);
            Font font = g2.getFont();
            g2.setFont(new Font(String.valueOf(font), Font.ITALIC, 13));
            g2.drawString("Meklēt tabulā...", 7, 20);
            g2.dispose();
        }
    }
}