/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author ayah
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    Op o = new Op();
    @FXML
    private Label label2;
    @FXML
    private Label lbl;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        ArrayList<String> results = o.read();
        for (String result : results) {
            label2.setText("postfix is : " + result.toString());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction2(ActionEvent event2) {

        label.setText("infix is : " + getLine());//display s infix equation

    }

    public String getLine() {//get file's data
        String l = null;

        File x = new File("Poly"); //This is used to input the movies text
        ArrayList<String> result = new ArrayList<>();
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");//handle
            }

            while (input.hasNext()) //checks if the file has nextLine
            {
                l = input.nextLine(); // This is used to get to the next line and trim thm from the sides
            }
        }
        return l;
    }

}
