package ood.borobicycles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests class to check the application's functionality without a full
 * GUI.
 */
public class GUITest {

    // test input file
    private final String TEST_FILE_PATH = "test_bicycles.txt";
    private MockGUI mockGui;

    /**
     * A mock class of the GUI to allow access to private members for testing.
     */
    class MockGUI {

        String BICYCLE_FILE_PATH = "bicycles.txt";
        ArrayList<Bicycle> bicycleList;
        JButton saleButton;
        JButton stockButton;

        // Mock method to load bicycles from a specified file path
        public void loadBicycles(String filePath) throws IOException {
            BICYCLE_FILE_PATH = filePath;
            bicycleList = new ArrayList<>();
            try (var reader = Files.lines(Paths.get(BICYCLE_FILE_PATH))) {
                reader.forEach(line -> {
                    String[] data = line.split(",");
                    Bicycle bicycle = new Bicycle(
                            data[0], Double.parseDouble(data[1]), data[2], data[3], data[4],
                            data[5], data[6], data[7], Integer.parseInt(data[8]), Boolean.parseBoolean(data[9])
                    );
                    bicycleList.add(bicycle);
                });
            }
        }

        // Mock method to check stock and enable/disable buttons
        public void checkStock(Bicycle bicycle, JButton saleBtn, JButton stockBtn) {
            saleBtn.setEnabled(true);
            stockBtn.setEnabled(true);
            if (bicycle.getQuantity() == 0) {
                saleBtn.setEnabled(false);
            }
            if (bicycle.getQuantity() == 5) {
                stockBtn.setEnabled(false);
            }
        }
    }

    /**
     * method that runs before each test. Creates a mock `bicycles.txt` file
     * with test data. This is crucial for testing the file-reading logic.
     */
    @BeforeEach
    public void setUp() throws IOException {
        // Create a mock GUI instance
        mockGui = new MockGUI();

        // Create a mock data file for testing using Files.writeString()
        String content = "SKU001,100.0,MakeA,Model1,Red,1-3,Steel,Bell,2,true\n"
                + "SKU002,250.0,MakeB,Model2,Blue,5-8,Aluminium,Basket,0,false\n"
                + "SKU003,500.0,MakeC,Model3,Black,12-15,Carbon,Lights,5,true\n";
        Files.writeString(Paths.get(TEST_FILE_PATH), content);
    }

    /**
     * Tear down method that runs after each test. It cleans up by deleting the
     * mock test data file.
     */
    @AfterEach
    public void tearDown() {
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    // --- Phase 2: Data Loading Tests ---
    /**
     * Test case for valid data loading. This test checks if the `loadBicycles`
     * method successfully reads from a correctly formatted file and populates
     * the `bicycleList` with the expected number of items. It also verifies the
     * properties of a loaded object.
     */
    @Test
    public void testLoadBicycles_ValidFile_Success() throws IOException {
        mockGui.loadBicycles(TEST_FILE_PATH);

        // Assert that the list is not null and has the expected size
        assertNotNull(mockGui.bicycleList);
        assertEquals(3, mockGui.bicycleList.size());

        // Assert a specific property of a loaded bicycle
        Bicycle firstBicycle = mockGui.bicycleList.get(0);
        assertEquals("SKU001", firstBicycle.getSku());
        assertEquals("MakeA", firstBicycle.getMake());
        assertEquals(2, firstBicycle.getQuantity());
    }

    /**
     * Test case for invalid data loading with a non-existent file. This test
     * ensures that the `loadBicycles` method correctly handles a
     * `FileNotFoundException` when the specified file does not exist.
     */
    @Test
    public void testLoadBicycles_InvalidFile_ThrowsException() {
        // Set an invalid file path
        mockGui.BICYCLE_FILE_PATH = "non_existent_file.txt";

        // Assert that calling loadBicycles() throws a FileNotFoundException
        assertThrows(IOException.class, () -> mockGui.loadBicycles(mockGui.BICYCLE_FILE_PATH));
    }

    /**
     * Test case for malformed data in the file. This test creates a file with a
     * non-numeric value where a number is expected, ensuring that the
     * application throws a `NumberFormatException` when attempting to parse the
     * invalid data.
     */
    @Test
    public void testLoadBicycles_MalformedData_ThrowsException() throws IOException {
        // Create a malformed test file
        String malformedContent = "SKU004,invalid,MakeD,Model4,Green,3-5,Aluminium,Bell,1,true\n";
        Files.writeString(Paths.get(TEST_FILE_PATH), malformedContent);

        // Assert that calling loadBicycles() throws a NumberFormatException
        assertThrows(NumberFormatException.class, () -> mockGui.loadBicycles(TEST_FILE_PATH));
    }

    // --- Phase 3: Stock Checking Tests ---
    /**
     * Test case for valid stock level. This test verifies that when a bicycle's
     * quantity is within the normal range (0 < quantity < 5), both the "SALE"
     * and "STOCK" buttons remain enabled.
     */
    @Test
    public void testCheckStock_ValidStock_ButtonsEnabled() {
        // Mock a bicycle with a normal quantity
        Bicycle bicycle = new Bicycle("SKU001", 100.0, "MakeA", "Model1", "Red", "1-3", "Steel", "Bell", 2, true);

        // Mock GUI buttons to check their enabled state
        JButton saleButton = new JButton("SALE");
        JButton stockButton = new JButton("STOCK");

        mockGui.checkStock(bicycle, saleButton, stockButton);

        // Both buttons should be enabled
        assertTrue(saleButton.isEnabled());
        assertTrue(stockButton.isEnabled());
    }

    /**
     * Test case for checking the stock level when it's at zero. This test
     * ensures that the "SALE" button is correctly disabled when a bicycle's
     * quantity reaches the minimum stock level (0).
     */
    @Test
    public void testCheckStock_ZeroStock_SaleButtonDisabled() {
        // Mock a bicycle with zero quantity
        Bicycle bicycle = new Bicycle("SKU002", 250.0, "MakeB", "Model2", "Blue", "5-8", "Aluminium", "Basket", 0, false);

        // Mock GUI buttons
        JButton saleButton = new JButton("SALE");
        JButton stockButton = new JButton("STOCK");

        mockGui.checkStock(bicycle, saleButton, stockButton);

        // Sale button should be disabled, stock button should be enabled
        assertFalse(saleButton.isEnabled());
        assertTrue(stockButton.isEnabled());
    }

    /**
     * Test case for checking the stock level when it's at the maximum. This
     * test verifies that the "STOCK" button is correctly disabled when a
     * bicycle's quantity reaches the maximum stock level (5).
     */
    @Test
    public void testCheckStock_MaxStock_StockButtonDisabled() {
        // Mock a bicycle with maximum quantity
        Bicycle bicycle = new Bicycle("SKU003", 500.0, "MakeC", "Model3", "Black", "12-15", "Carbon", "Lights", 5, true);

        // Mock GUI buttons
        JButton saleButton = new JButton("SALE");
        JButton stockButton = new JButton("STOCK");

        mockGui.checkStock(bicycle, saleButton, stockButton);

        // Sale button should be enabled, stock button should be disabled
        assertTrue(saleButton.isEnabled());
        assertFalse(stockButton.isEnabled());
    }
}
