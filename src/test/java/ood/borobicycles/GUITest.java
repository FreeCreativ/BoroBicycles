/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ood.borobicycles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author okafo
 */
public class GUITest {

    public GUITest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    //    
    //    @BeforeAll
    //    public static void setUpClass() {
    //    }
    //    
    //    @AfterAll
    //    public static void tearDownClass() {
    //    }
    //    
    //    @BeforeEach
    //    public void setUp() {
    //    }
    //    
    //    @AfterEach
    //    public void tearDown() {
    //    }

    /**
     * Test of checkStock method, of class GUI.
     */
    @org.junit.jupiter.api.Test
    public void testCheckStock() {
        System.out.println("checkStock");
        Bicycle bicycle = null;
        GUI instance = new GUI();
        instance.checkStock(bicycle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of log method, of class GUI.
     */
    @org.junit.jupiter.api.Test
    public void testLog() {
        System.out.println("log");
        int units = 0;
        String operation = "";
        GUI instance = new GUI();
        instance.log(units, operation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveData method, of class GUI.
     */
    @org.junit.jupiter.api.Test
    public void testSaveData() throws Exception {
        System.out.println("saveData");
        GUI instance = new GUI();
        instance.saveData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class GUI.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
