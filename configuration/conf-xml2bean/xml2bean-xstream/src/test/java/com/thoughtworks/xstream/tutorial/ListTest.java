package com.thoughtworks.xstream.tutorial;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.*;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void createXMlFromObject() throws MalformedURLException {
        JazzArtist2 artist2 = new JazzArtist2("Benny Goodman",
                true, new URL("http://www.bennygoodman.com/"));
        Album2 album3 = new Album2("In Stockholm", 5, 1959,"swing");
        Album2 album4 = new Album2("A Jazz Holiday", 3, 1928,"swing");
        artist2.addAlbum(album3);
        artist2.addAlbum(album4);

//        XStream xStream2 = new XStream(new DomDriver());
        XStream xStream2 = new XStream();
        xStream2.processAnnotations(JazzArtist2.class);
        System.out.println(xStream2.toXML(artist2));
    }
}

@XStreamAlias("artist")
class JazzArtist2 {
    public String name;
    @XStreamConverter(value = BooleanConverter.class,
            booleans = { true, false },
            strings = { "Yes", "No" })
    public boolean isAlive;
    public URL url;
    @XStreamImplicit
    public List<Album2> albums = new ArrayList<Album2>();

    public JazzArtist2(String name, boolean isAlive, URL url) {
        this.name = name;
        this.isAlive = isAlive;
        this.url = url;
    }

    public void addAlbum(Album2 album) {
        albums.add(album);
    }

}

@XStreamAlias("album")
class Album2 {
    public String title;
    @XStreamOmitField
    public int noOfRecords;
    public int year;
    @XStreamAsAttribute
    public String genre;

    public Album2(String title, int noOfRecords, int year,String genre) {
        this.title = title;
        this.noOfRecords = noOfRecords;
        this.year = year;
        this.genre = genre;
    }
}