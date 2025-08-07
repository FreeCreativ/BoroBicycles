/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 *
 * @author s3527013
 */
// Models the Bicycle Entity
public class Bicycle {

    // class properties
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

    // Constructor Method
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

    // Accessor Methods
    // fetches the sku of the bicycle
    public String getSku() {
        return this.sku;
    }

    // fetches the price of the bicycle
    public Double getPrice() {
        return this.price;
    }

    // returns the make of the bicycle
    public String getMake() {
        return this.make;
    }

    // gets the model of the bicycle
    public String getModel() {
        return this.model;
    }

    // returns the colour of the bicycle
    public String getColour() {
        return this.colour;
    }

    // gets the suitable age range of the users
    public String getAgeRange() {
        return this.ageRange;
    }

    // returns the material of the bicycle
    public String getMaterial() {
        return this.material;
    }

    // returns the feature of the bicycle
    public String getFeature() {
        return this.feature;
    }

    // returns the remaining quantity of the bicycle 
    public int getQuantity() {
        return this.quantity;
    }

    // returns the assembled status
    public Boolean getAssembled() {
        return this.assembled;
    }

    // Service Methods
    //Increases the bicycle quantity
    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    // Reduces the quantity of the Bicycle
    public void decrementQuantity(int amount) {
        this.quantity -= amount;
    }

    // formats the age range to human readable message
    public String getLongAgeRange() {
        return switch (this.ageRange) {
            case "1-3" ->
                "Suitable for children aged one to three years old.";
            case "3-5" ->
                "Suitable for children aged three to five years old.";
            case "5-8" ->
                "Suitable for children aged five to eight years old.";
            case "8-11" ->
                "Suitable for children aged eight to eleven years old.";
            case "12-15" ->
                "Suitable for children aged twelve to fifteen years old.";
            default ->
                "Not suitable for children above fifteen years old";
        };
    }

    // formats and adds a currency symbol to the price
    public String getFormattedPrice() {
        return String.format("£ %.2f", this.price);
    }

    // Overloaded method to handle the total sales price.
    public String getFormattedPrice(double amount) {
        return String.format("£ %.2f", amount);
    }

    // returns an actual file path in string format
    public String getImageFileName() {
        return this.sku + ".jpg";
    }

    // Checks if the bicycle is assembled or not
    public String isAssembled() {
        if (this.assembled) {
            return "Yes";
        } else {
            return "No";
        }
    }

    // returns the value of price by quantity with a currency symbol
    public String calculateTotalSale(int quantity) {
        return getFormattedPrice(quantity * this.price);
    }
}// End of  Bicycle class
