package com.example.tmara.lazylistpicasso;

/**
 * Created by tmara on 11/07/2016.
 */
public class RowModel {

    private String image;
    private String title;
    private String descritpion;

    public RowModel(){

    }

    public RowModel(String image, String title, String descritpion){
        this.image = image;
        this.title = title;
        this.descritpion = descritpion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}
