package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;


public class Photo {
    public Photo(String url){
        this.url =url;
    }
    public String url;
    public void writeHTML(PrintStream out){
        out.printf("<img src=\"%s\" alt=\"Smiley face\" height=\"42\" width=\"42\"/>\n",url);
    }
}
