/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 * Models the Bicycle Entity. For creating bicycle objects
 *
 * @author s3527013
 * @author e6411415
 * @author e4621366
 * @author s3516185
 * @version 2.0
 *
 */
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

    /**
     * Bicycle Constructor method
     *
     * @param sku value of bicycle SKU
     * @param price the price of the bicycle
     * @param make the make of the bicycle
     * @param model the make of the bicycle
     * @param colour the colour of the bicycle
     * @param ageRange contains the suitable age of the rider
     * @param material contains the material of the bicycle
     * @param feature the feature of the bicycle
     * @param quantity contains the number of bicycles
     * @param assembled decides if the bicycle is assembled before sale
     *
     */
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

    /**
     * fetches the sku of the bicycle
     *
     * @return String sku
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * fetches the price of the bicycle
     *
     * @return Double Price
     */
    public Double getPrice() {
        return this.price;
    }

    /**
     * returns the make of the bicycle
     *
     * @return String make
     */
    public String getMake() {
        return this.make;
    }

    /**
     * gets the model of the bicycle
     *
     * @return String model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * returns the colour of the bicycle
     *
     * @return String colour
     */
    public String getColour() {
        return this.colour;
    }

    /**
     * gets the suitable age range of the users
     *
     * @return String ageRange
     */
    public String getAgeRange() {
        return this.ageRange;
    }

    /**
     * returns the material of the bicycle
     *
     * @return String material
     */
    public String getMaterial() {
        return this.material;
    }

    /**
     * returns the feature of the bicycle
     *
     * @return String feature
     */
    public String getFeature() {
        return this.feature;
    }

    /**
     * returns the remaining quantity of the bicycle
     *
     * @return int quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * returns the assembled status
     *
     * @return Boolean assembled
     */
    public Boolean getAssembled() {
        return this.assembled;
    }

    /**
     * Increases the bicycle quantity
     *
     * @param amount sets the increment quantity
     */
    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    /**
     * Reduces the quantity of the Bicycle
     *
     * @param amount sets the decrement quantity
     */
    public void decrementQuantity(int amount) {
        this.quantity -= amount;
    }

    /**
     * formats the age range to human readable message
     *
     * @return String formatted age range
     */
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

    /**
     * formats and adds a currency symbol to the price
     *
     * @return String formatted price with currency symbol
     */
    public String getFormattedPrice() {
        return String.format("£ %.2f", this.price);
    }

    /**
     * Overloaded method to handle the total sales price. Formats and adds a
     * currency symbol to the price
     *
     * @param amount total sales price value
     * @return String formatted total sales price with currency symbol
     */
    public String getFormattedPrice(double amount) {
        return String.format("£ %.2f", amount);
    }

    /**
     * returns the image file name in string format
     *
     * @return String Image file name
     */
    public String getImageFileName() {
        return this.sku + ".jpg";
    }

    /**
     * Checks if the bicycle is assembled before sale
     *
     * @return String Yes if true, No if false
     */
    public String isAssembled() {
        if (this.assembled) {
            return "Yes";
        } else {
            return "No";
        }
    }

    /**
     * returns the value of price by quantity with a currency symbol
     *
     * @param quantity The number of bicycle sold
     * @return String price by quantity with a currency symbol
     */
    public String calculateTotalSale(int quantity) {
        return getFormattedPrice(quantity * this.price);
    }
}// End of  Bicycle class
