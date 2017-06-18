package com.company;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class OpenFileFilter extends FileFilter {
    public String fileExt = "";
    String txtExt = ".tsv";


    public OpenFileFilter(String extension) {
        fileExt = extension;
    }

    @Override public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return  (f.getName().toLowerCase().endsWith(fileExt));
    }

    public String getDescription() {
        if(fileExt.equals(txtExt ))
            return  "Text Files (*" + fileExt + ")";
        else
            return ("Tab-separated values (.tsv)");
    }
}
