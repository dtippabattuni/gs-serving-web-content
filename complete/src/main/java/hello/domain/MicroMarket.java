/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.domain;

/**
 *
 * @author dtippabattuni
 */
public class MicroMarket {
    private String zipCode;
    private double radius;
    private double areaLength;
    private double areaWidth;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(double areaLength) {
        this.areaLength = areaLength;
    }

    public double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(double areaWidth) {
        this.areaWidth = areaWidth;
    }
}
