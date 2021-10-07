package com.example.test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    //@FXML
   // private TextField Height;
//    Stage window;
//    Scene scene1, scene2;
//    public void Submit(ActionEvent event) {
//        String height = Height.getText();
//        Alert alert= new Alert(Alert.Alert Type.INFORMATION);
//        alert.setContentText("Chiều cao của bạn "+height);
//        alert.show();
//    }
    @FXML
    private TextField wordtarget,wordexplain;

    Dictionary dict= new Dictionary();
   // private  String s;
    private int check =0;
    public void insertFromFile() {
        File myFile = new File("dictionaries.txt");
        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Word new_word = new Word();
                String line = scanner.nextLine();
                String[] word = line.split("\\t");
                new_word.setWord_target(word[0]);
                new_word.setWord_explain(word[1]);
                dict.getDict().add(new_word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dict.getDict().sort((o1,o2)->(o1.getWord_target().compareTo(o2.getWord_target())));
    }
    public void enterWord(ActionEvent e) {
        String s= wordtarget.getText();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        insertFromFile();
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        if(word!=null) {
//            alert.setContentText(word.getWord_explain());
//            alert.show();
            wordexplain.setText(word.getWord_explain());
        }
        else {
            alert.setContentText("Not Word");
            alert.show();
        }
    }
    public void show() {

    }
}
