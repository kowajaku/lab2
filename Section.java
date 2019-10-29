package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

class Section {
    public String title;
    public List<Paragraph> paragraphs;

    public Section(String A)
    {
        paragraphs = new ArrayList<>();
        this.title=A;
    }
    public void setTitle(String title) {
        this.title=title;
    }

    public void addParagraph(String paragraphText) {
        paragraphs.add(new Paragraph(paragraphText));
    }

    public void addParagraph(Paragraph p) {
        paragraphs.add(p);
    }

    void writeHTML(PrintStream out) {
        out.printf("<h2>%s</h2>",title);
        for(int i=0;i<paragraphs.size();i++)
        {
            paragraphs.get(i).writeHTML(out);
        }
    }
}
