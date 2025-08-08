/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 *
 * @author s3527013
 * @author e6411415
 * @author e4621366
 * @author s3516185
 * @version 4.0
 */
public class Transaction {

    // class properties
    private String sku;
    private String make;
    private String model;
    private Double price;
    private int units;
    private String operation;

    /* ACCESSOR METHODS */
    // sku accessor method
    public String getSku() {
        return this.sku;
    }

    // make accessor method
    public String getMake() {
        return this.make;
    }

    // model accessor method
    public String getModel() {
        return this.model;
    }

    // price accessor method
    public Double getPrice() {
        return this.price;
    }

    // units accessor method
    public int getUnits() {
        return this.units;
    }

    // operation accessor method
    public String getOperation() {
        return this.operation;
    }

    // Constructor Method
    public Transaction(String sku, String make, String model, Double price, int units, String operation) {
        this.sku = sku;
        this.make = make;
        this.model = model;
        this.price = price;
        this.units = units;
        this.operation = operation;
    }

}
