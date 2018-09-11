package com.github.placesinindonesia.data;

/**
 * Created by Kei Lazu on 9/11/2018
 * check https://github.com/KeiLazu for more
 */
public class Places {
    private String placesName, country, placesDesc, image;

    public String getPlacesName() {
        return placesName;
    }

    public void setPlacesName(String placesName) {
        this.placesName = placesName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlacesDesc() {
        return placesDesc;
    }

    public void setPlacesDesc(String placesDesc) {
        this.placesDesc = placesDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Places() {
    }

    public Places(String placesName, String country, String placesDesc, String image) {
        this.placesName = placesName;
        this.country = country;
        this.placesDesc = placesDesc;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Places{" +
                "placesName='" + placesName + '\'' +
                ", country='" + country + '\'' +
                ", placesDesc='" + placesDesc + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
