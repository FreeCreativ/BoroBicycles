/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 *
 * @author s3527013
 */
// imports the swing table class
import javax.swing.table.AbstractTableModel;

//import libraries for aray list
import java.util.ArrayList;
import java.util.Arrays;

public class BicycleTableModel extends AbstractTableModel {

    //fields
    //column identifiers
    private String[] columnIdentifiers;

    //empty two dimensional object array for to store display data
    private Object[][] data;

    //contructor method
    public BicycleTableModel(String[] identifiersArray, ArrayList<Bicycle> bicycleList) {
        //populate single dimensional array using static array copyOf method 
        columnIdentifiers = Arrays.copyOf(identifiersArray, identifiersArray.length);

        //set size of data two-dimensaional array using size of arraylist parameter and length of array paramter
        data = new Object[bicycleList.size()][identifiersArray.length];

        //loop through arraylist parameter using for-loop
        for (int index = 0; index < bicycleList.size(); index++) {

            //get current item
            Bicycle bicycle = bicycleList.get(index);

            //get values from current item - excepy assembled
            String make = bicycle.getMake();
            String model = bicycle.getModel();
            String ageRange = bicycle.getAgeRange();
            int quantity = bicycle.getQuantity();

            //for assembled - will return a boolean as jTable automatically displays as check box
            boolean assembled = bicycle.getAssembled();

            //create an object array populated from the current item
            Object[] dataRow = {make, model, ageRange, quantity, assembled};

            //copy the one dimensional array as a new row in the two dimensional data array
            data[index] = Arrays.copyOf(dataRow, identifiersArray.length);

        }//end of for loop
    }

    /*
     * Override inherited abstract method
     */
    //method to return number of rows
    @Override
    public int getRowCount() {
        //number of rows will be same as length of two dimesional array
        return data.length;

    }

    //method to return number of columns
    @Override
    public int getColumnCount() {
        //return length of linear array fiels
        return columnIdentifiers.length;
    }

    //method to return value where user clicks in table
    @Override
    public Object getValueAt(int row, int column) {
        //get object at insection of row and column in box
        return data[row][column];
    }

    // method to disable cell editing by overiding the behaviour of isCellEditable method
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /*
     * Override inherited (non abstract) methods
     */
    @Override
    public void setValueAt(Object value, int row, int column) {
        //set new value
        data[row][column] = value;

        //force table model to update values displayed by table for the updated element
        fireTableCellUpdated(row, column);
    }

    @Override
    //override method so to set column headers
    public String getColumnName(int column) {
        return columnIdentifiers[column];
    }

    @Override
    //override method such that only booleans are shown typed
    public Class getColumnClass(int column) {
        //check if class type of column ib Boolean, if so rerurn Boolen class
        if (getValueAt(0, column).getClass().equals(Boolean.class)) {
            return Boolean.class;
        } else {
            //other return string class
            return String.class;
        }
    }
}
