package com.example.wikway1;

public class JobAd {
    public String title, imageLink;
    public boolean fav;
    public JobAd(String title,String imageLink){
        this.title=title;
        this.imageLink = imageLink;
        fav = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
