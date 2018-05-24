/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Populacao;

/**
 *
 * @author diegohenriquedeabreu
 */
public class No {

    private float latitude;
    private float longitude;
    private int label;

    public No(int label, float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.label = label;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

}
