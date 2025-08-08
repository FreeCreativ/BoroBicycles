/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

// imports the swing table class
import javax.swing.table.AbstractTableModel;

//imports the ArrayList class
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Models the Bicycle Table model. Used to display bicycle objects in the
 * bicycleTable
 *
 * @author s3527013
 * @author e6411415
 * @author e4621366
 * @author s3516185
 * @version 2.0
 */
public class BicycleTableModel extends AbstractTableModel {

    //fields or column identifiers
    private String[] columnIdentifiers;

    //empty two dimensional object array for to store display data
    private Object[][] data;

    /**
     * BicycleTableModel constructor method
     *
     * @param identifiersArray a string array of identifiers, contains table
     * labels
     * @param bicycleList contains list of bicycle objects
     */
    public BicycleTableModel(String[] identifiersArray, ArrayList<Bicycle> bicycleList) {
        //populate single dimensional array using static array copyOf method 
        columnIdentifiers = Arrays.copyOf(identifiersArray, identifiersArray.length);

        //set the size of two-dimensaional array data using size of arraylist parameter and length of array paramter
        data = new Object[bicycleList.size()][identifiersArray.length];

        //loop through arraylist parameter using for-loop
        for (int index = 0; index < bicycleList.size(); index++) {

            //get current item
            Bicycle bicycle = bicycleList.get(index);

            //get values from current item
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

    /**
     * method to return number of rows
     *
     * @return int the number of table rows
     */
    @Override
    public int getRowCount() {
        //number of rows will be same as length of two dimesional array
        return data.length;

    }

    /**
     * method to return number of columns
     *
     * @return int the number of table columns
     */
    @Override
    public int getColumnCount() {
        //return length of linear array fiels
        return columnIdentifiers.length;
    }

    /**
     * returns the value at the specified row column index.
     *
     * @param row the row index
     * @param column the column index
     * @return Object the value of clicked cell
     */
    @Override
    public Object getValueAt(int row, int column) {
        //get object at insection of row and column in box
        return data[row][column];
    }

    /**
     * disables cell editing
     *
     * @return Boolean false to disable editing
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * method to change the value of a cell
     *
     * @param value the new value to be set
     * @param row the index of the table row
     * @param column the index of the column
     */
    @Override
    public void setValueAt(Object value, int row, int column) {
        //set new value
        data[row][column] = value;

        //force table model to update values displayed by table for the updated element
        fireTableCellUpdated(row, column);
    }

    /**
     * Returns the class of the specified column.
     *
     * @param column the index of the table column
     * @return String the column name from the identifier array
     */
    @Override
    public String getColumnName(int column) {
        return columnIdentifiers[column];
    }

    /**
     * method to check if column class is Boolean
     *
     * @param column the index of the table column
     * @return Class the class type of the column
     */
    @Override
    public Class getColumnClass(int column) {
        //check if class type of column id Boolean, if so rerurn Boolen class
        if (getValueAt(0, column).getClass().equals(Boolean.class)) {
            return Boolean.class;
        } else {
            //other return string class
            return String.class;
        }
    }
}// End of BicycleTableModel class
