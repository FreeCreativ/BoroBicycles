/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ood.borobicycles;

//import libraries for aray list and scanner
import java.util.ArrayList;
import java.util.Scanner;

//import libraries for file reading
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import libraries for image handling
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author s3527013
 */
/**
 *
 * @author oghen
 */
public class GUI extends javax.swing.JFrame {

    // Specifies the delimiter for file reading
    private final String DELIMITER = ",";

    //variable to keep track of slected row
    private int rowIndex = -1;

    // the location of bicycles.txt file
    private final String RELATIVE_PATH = "bicycles.txt";

    // Bicycle table model reference
    private BicycleTableModel tableModel;

    // Bicycle arrayList to hold list of bicycles
    ArrayList<Bicycle> bicycleList = new ArrayList<>();

    //array list to hold bicycle images
    private ArrayList<BufferedImage> imageList = new ArrayList<>();

    // Scanner object declaration
    Scanner fileScanner;

    // variable to hold column names
    private String[] columnNames = new String[]{"MAKE", "MODEL", "AGE RANGE", "QUANTITY", "ASSEMBLED"};

    // method to load bicycle data into table with exeption handling capabities
    private void loadBicycles() throws IOException, FileNotFoundException {

        // File object used to read from file
        File inputFile = new File(RELATIVE_PATH);

        // Checks if the file path is good and that it is a file
        if (inputFile.exists() && inputFile.isFile()) {

            // Scanner object to read from file
            fileScanner = new Scanner(inputFile);

            //Process file
            while (fileScanner.hasNextLine()) {
                // read each line
                String line = fileScanner.nextLine();
                // check if line is not empty
                if (line.trim().length() > 0) {
                    //process line assigning each part to the respective variable 
                    String sku = line.split(DELIMITER)[0];
                    double price = Double.parseDouble(line.split(DELIMITER)[1]);
                    String make = line.split(DELIMITER)[2];
                    String model = line.split(DELIMITER)[3];
                    String colour = line.split(DELIMITER)[4];
                    String ageRange = line.split(DELIMITER)[5];
                    String material = line.split(DELIMITER)[6];
                    String feature = line.split(DELIMITER)[7];
                    int quantity = Integer.parseInt(line.split(DELIMITER)[8]);
                    boolean assembled = Boolean.parseBoolean(line.split(DELIMITER)[9]);
                    bicycleList.add(new Bicycle(sku, price, make, model, colour, ageRange, material, feature, quantity, assembled));
                }
            }// End of While loop

            // close file Stream
            fileScanner.close();
            //Otherwise warn user file is invalid and exit
        } else {
            System.err.println("\n!!!!! Error: '" + inputFile.getName() + "' does not exist !!!!!\n\n");
        }
    }
    //method to preload bicycle Images

    private void loadBicycleImages(String imagePath) {

        //loop through main arraylist
        for (int index = 0; index < bicycleList.size(); index++) {
            //get photo filename form stock list item

            String filename = imagePath + bicycleList.get(index).getImageFileName();

            //create buffered image object - set to null if loading fails
            BufferedImage image = null;

            //try to load image
            try {
                image = ImageIO.read(new File(filename));
            } catch (IOException e) {
                //log and report error - but no need to exit or return
                String message = "Unable to load image '" + filename + "'";
                System.err.println("\n!!!!! " + message + " !!!!!\n");
            } finally {
                //add either loaded image or null to arraylist
                imageList.add(image);
            }
        }
    }

    //method to populate tabe and set column headers
    private void initTable() {
        //instantiate the table model
        //link the table model to the table
        tableModel = new BicycleTableModel(columnNames, bicycleList);

        //link the table model to the table
        bicycleTable.setModel(tableModel);
    }

    //method to display image and caption
    private void displayImage() {
        //clear any text in labels
        imageLabel.setText("");
        captionLabel.setText("");

        //clear any icon displayed in label
        imageLabel.setIcon(null);

        //get buffered image
        BufferedImage image = imageList.get(rowIndex);

        //check if image is null
        if (image == null) {
            //set text of label
            imageLabel.setText("Image not available.");
        } else {
            //set photolabel using photo array list
            imageLabel.setIcon(new ImageIcon(image));

            //set text of item label
            captionLabel.setText(bicycleList.get(rowIndex).getFeature());
        }
    }

    /**
     * Creates new form GUI
     */
    public GUI() {
        // load bicycle data  
        try {
            //invoke method to load dinosaur file data
            loadBicycles();
            //check if array list is empty
            if (bicycleList.isEmpty()) {
                //warn and exit
                String message = "Data Error: No data read from input file";
                System.err.println("\n!!!!! " + message + " !!!!!\n");
                System.exit(0);
            }
            
        } catch (FileNotFoundException e) {
            //warn and exit
            System.err.println("\n!!!!! Unable to open file !!!!!\n" + e.getMessage() + "\n");
            System.exit(0);
            
        } catch (IOException e) {
            //warn and exit
            System.err.print("\n!!!!! File read error !!!!!\n" + e.getMessage() + "\n");
            System.exit(0);
            
        } catch (Exception e) {
            System.err.print("\n!!!!! Runtime error !!!!!\n" + e.getMessage() + "\n");
            System.exit(0);
        }

        // load images to List
        loadBicycleImages("bicycles/");

        // load gui components
        initComponents();

        //invoke method to populate data
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bicycleScrollPane = new javax.swing.JScrollPane();
        bicycleTable = new javax.swing.JTable();
        detailsScrollPane = new javax.swing.JScrollPane();
        bicycleTextArea = new javax.swing.JTextArea();
        ImagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        captionLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        saleButton = new javax.swing.JButton();
        stockButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boro Bicycles");
        setResizable(false);

        bicycleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bicycleTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        bicycleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bicycleTableMouseClicked(evt);
            }
        });
        bicycleScrollPane.setViewportView(bicycleTable);

        bicycleTextArea.setEditable(false);
        bicycleTextArea.setColumns(20);
        bicycleTextArea.setRows(5);
        detailsScrollPane.setViewportView(bicycleTextArea);

        ImagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(captionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(captionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        saleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saleButton.setText("SALE");

        stockButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stockButton.setText("STOCK");

        quitButton.setBackground(new java.awt.Color(255, 0, 51));
        quitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("QUIT");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(saleButton)
                .addGap(26, 26, 26)
                .addComponent(stockButton)
                .addGap(27, 27, 27)
                .addComponent(quitButton)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saleButton)
                    .addComponent(stockButton)
                    .addComponent(quitButton))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsScrollPane)
                    .addComponent(bicycleScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bicycleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailsScrollPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonMouseClicked

    private void bicycleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bicycleTableMouseClicked
        // TODO add your handling code here:
        // get index of row clicked by user
        rowIndex = bicycleTable.getSelectedRow();
        displayImage();
        
    }//GEN-LAST:event_bicycleTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JScrollPane bicycleScrollPane;
    private javax.swing.JTable bicycleTable;
    private javax.swing.JTextArea bicycleTextArea;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel captionLabel;
    private javax.swing.JScrollPane detailsScrollPane;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton saleButton;
    private javax.swing.JButton stockButton;
    // End of variables declaration//GEN-END:variables
}
