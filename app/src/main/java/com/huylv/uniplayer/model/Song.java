package com.huylv.uniplayer.model;

import android.net.Uri;

import java.io.File;

import io.realm.RealmObject;

/**
 * Created by HuyLV-CT on 18-Aug-16.
 */
public class Song extends RealmObject {
    private String name;
    private String artist;
    private String filePath;
    private String downloadLink;
    private int length;
    private String bitmapString;
    private boolean availableOnServer;

    public Song(String name, String artist, String filePath, int length, String bitmapString) {
        this.name = name;
        this.artist = artist;
        this.filePath = filePath;
        this.length = length;
        this.bitmapString = bitmapString;
    }

    public Song() {
    }

    public Song(String name, String artist, String downloadLink, int length) {
        this.name = name;
        this.artist = artist;
        this.downloadLink = downloadLink;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getBitmapString() {
        return bitmapString;
    }

    public void setBitmapString(String bitmapString) {
        this.bitmapString = bitmapString;
    }

    public boolean isAvailableOnServer() {
        return availableOnServer;
    }

    public void setAvailableOnServer(boolean availableOnServer) {
        this.availableOnServer = availableOnServer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public void setAll(String name, String artist, String filePath){
        this.name = name;
        this.artist = artist;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", filePath='" + filePath + '\'' +
                ", downloadLink='" + downloadLink + '\'' +
                ", length=" + length +
                '}';
    }

    public boolean equals(Song s) {
        return name.equalsIgnoreCase(s.getName()) && artist.equalsIgnoreCase(s.getArtist());
    }

    public Uri getSongUri() {
        return Uri.fromFile(new File(filePath));
    }
}
