/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobicycles;

/**
 *
 * @author s3527013
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BicycleTableModel extends AbstractTableModel {

    private final List<Bicycle> bicycles;
    private final String[] columnNames = {"Make", "Model", "Age Range", "Quantity", "Assembled"};

    public BicycleTableModel(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }

    @Override
    public int getRowCount() {
        return bicycles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bicycle bicycle = bicycles.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                bicycle.getMake();
            case 1 ->
                bicycle.getModel();
            case 2 ->
                bicycle.getAgeRange();
            case 3 ->
                bicycle.getQuantity();
            case 4 ->
                bicycle.isAssembled();
            default ->
                null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return (columnIndex == 4) ? Boolean.class : String.class;
    }
}
