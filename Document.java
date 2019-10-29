package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;


class Document{
    public String title;
    public Photo photo;

    public List<Section> sections;

    public Document(String A)
    {
        this.title=A;
        sections = new ArrayList<>();
    }
    public Document setTitle(String title){

        this.title = title;
        return this;
    }

    public Document setPhoto(String photoUrl){
        this.photo=new Photo(photoUrl);
        return this;
    }

    public void addSection(String sectionTitle){

        sections.add(new Section(sectionTitle));
        return ;
    }
    public Document addSection(Section s)
    {
        sections.add(s);
        return this;
    }


    public void writeHTML(PrintStream out) {

        out.printf("<h1>%s</h1>",title);
        photo.writeHTML(out);
        for(int i=0;i<sections.size();i++)
        {
            sections.get(i).writeHTML(out);
        }

    }

    public void addPhoto(String A)
    {
        photo=new Photo(A);
    }
}
