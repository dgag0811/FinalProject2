package com.example.monikagarg.finalproject;

/**
 * Created by monikagarg on 6/30/2016.
 */
public class Note {
    private String description;
    private byte[] image;
    private int index;

    public Note() {
    }

    public Note(int index, byte[] image, String description) {
        this.image = image;
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() { return index; }
    public void setIndex(int index) {
        this.index = index;
    }
}
