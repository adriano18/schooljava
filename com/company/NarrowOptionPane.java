package com.company;

import javax.swing.*;

/**
 * Created by AdrianP on 03.06.2017.
 */
public class NarrowOptionPane extends JOptionPane {
    NarrowOptionPane() {

    }
    public int getMaxCharactersPerLineCount() {
        return 100;
    }
}
