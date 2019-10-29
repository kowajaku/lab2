package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

class Paragraph {
    public String tekst;
    public Paragraph(String A)
    {
        setContent(A);
    }
    public void setContent(String A) {
        this.tekst=A;
    }

    void writeHTML(PrintStream out) {
        out.printf("<p>%s</p>",tekst);
    }



}
