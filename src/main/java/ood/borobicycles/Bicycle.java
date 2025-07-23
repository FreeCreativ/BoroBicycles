/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 *
 * @author s3527013
 */
public class Bicycle {

    private String sku;
    private Double price;
    private String make;
    private String model;
    private String colour;
    private String ageRange;
    private String material;
    private String feature;
    private int quantity;
    private Boolean assembled;

    public Bicycle(String sku, Double price, String make, String model, String colour, String ageRange, String material, String feature, int quantity, Boolean assembled) {
        this.sku = sku;
        this.price = price;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.ageRange = ageRange;
        this.material = material;
        this.feature = feature;
        this.quantity = quantity;
        this.assembled = assembled;
    }

    public String getSku() {
        return this.sku;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getColour() {
        return this.colour;
    }

    public String getAgeRange() {
        return this.ageRange;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getFeature() {
        return this.feature;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Boolean getAssembled() {
        return this.assembled;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decrementQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public String getLongAgeRange() {
        return this.ageRange;
    }

    public String getFormatedPrice() {
        return this.price.toString();
    }

    public String getImageFileName() {
        return this.sku + ".jpg";
    }
    public String isAssembled(){
        if (assembled) {
            return "Yes";
        } else {
            return "No";
        }
    }
    public String calculateTotalSale(int quantity){
        return "0";
    
    }
}
