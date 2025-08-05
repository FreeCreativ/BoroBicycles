/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ood.borobicycles;

/**
 *
 * @author oghen
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This is the main GUI class for the BoroBicycles application.
 * It creates a fixed, non resizable, well-balanced and elegant GUI based on the company’s design specifications.
 */
public class GUI extends JFrame {

    // Declaring named components for clarity and future reference
    private JTable saleItemsTable;
    private JTextArea itemDetailsArea;
    private JLabel itemImageLabel;
    private JLabel itemMakeModelLabel;

    // Sample item data: ID, Make, Model, Price, Description, Image Path
    private Object[][] itemData = {
            {"001", "Giant", "Escape 3", "$400", "A reliable city bike with lightweight frame.", "images/giant_escape.jpg"},
            {"002", "Trek", "Marlin 5", "$550", "A rugged mountain bike built for trail adventures.", "images/trek_marlin.jpg"},
            {"003", "Cannondale", "Quick 4", "$620", "A fast fitness bike with an upright ride.", "images/cannondale_quick.jpg"}
    };

    public GUI() {
        setTitle("Boro Bicycles"); // Window title
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // Prevent resizing for consistency
        setLayout(new BorderLayout(10, 10)); // Border layout with spacing

        add(buildMainContent(), BorderLayout.CENTER); // Center content panel
        add(buildButtonsPanel(), BorderLayout.SOUTH); // Bottom button panel

        pack(); // Fit components
        setLocationRelativeTo(null); // Center window
        setVisible(true); // Show GUI
    }

    // Main content panel containing table, text area and image panel
    private JPanel buildMainContent() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 2 columns: left and right

        // LEFT: Table and text area stacked vertically
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));

        // Define column headers for table
        String[] columns = {"ID", "Make", "Model", "Price"};

        // Make table cells non-editable
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Fill table with item data (excluding description and image)
        for (Object[] row : itemData) {
            model.addRow(new Object[]{row[0], row[1], row[2], row[3]});
        }

        saleItemsTable = new JTable(model);
        saleItemsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single row selection only

        // Event: when user selects a row, show details and image
        saleItemsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = saleItemsTable.getSelectedRow();
                if (selectedRow >= 0) {
                    itemDetailsArea.setText((String) itemData[selectedRow][4]); // Full description
                    itemMakeModelLabel.setText(itemData[selectedRow][1] + " " + itemData[selectedRow][2]);

                    // Load and scale image using ClassLoader
                    String imagePath = (String) itemData[selectedRow][5];
                    java.net.URL imgURL = getClass().getClassLoader().getResource(imagePath);
                    if (imgURL != null) {
                        ImageIcon icon = new ImageIcon(imgURL);
                        Image scaled = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                        itemImageLabel.setIcon(new ImageIcon(scaled));
                    } else {
                        itemImageLabel.setIcon(null);
                        System.err.println("Image not found: " + imagePath);
                    }
                }
            }
        });

        // Wrap table in scroll pane
        JScrollPane tableScrollPane = new JScrollPane(saleItemsTable);

        // Setup text area for full item description
        itemDetailsArea = new JTextArea(4, 40);
        itemDetailsArea.setEditable(false); // Read-only
        itemDetailsArea.setLineWrap(true);
        itemDetailsArea.setWrapStyleWord(true);
        JScrollPane textScrollPane = new JScrollPane(itemDetailsArea);

        // Add table on top and text area below it
        leftPanel.add(tableScrollPane, BorderLayout.CENTER);
        leftPanel.add(textScrollPane, BorderLayout.SOUTH);

        // RIGHT: image and make/model label stacked vertically
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));

        itemImageLabel = new JLabel();
        itemImageLabel.setHorizontalAlignment(JLabel.CENTER);

        itemMakeModelLabel = new JLabel("", JLabel.CENTER); // Initially empty

        rightPanel.add(itemImageLabel, BorderLayout.CENTER); // Image in center
        rightPanel.add(itemMakeModelLabel, BorderLayout.SOUTH); // Make/Model below image

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        return mainPanel;
    }

    // Build panel with SALE, STOCK, and QUIT buttons
    private JPanel buildButtonsPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton saleButton = new JButton("SALE");
        JButton stockButton = new JButton("STOCK");
        JButton quitButton = new JButton("QUIT");

        // Set red background for quit button
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);

        // QUIT exits application (also handled by window close)
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(saleButton);
        buttonPanel.add(stockButton);
        buttonPanel.add(quitButton);

        return buttonPanel;
    }

    // Entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
