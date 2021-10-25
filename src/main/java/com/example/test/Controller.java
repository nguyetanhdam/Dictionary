package com.example.test;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller {
    //@FXML

    @FXML
    private TextField wordtarget, textField;
    @FXML
    private TextArea wordexplain;

    Dictionary dict = new Dictionary();

    public void enterWord(ActionEvent e) {
        String s= wordtarget.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DictionaryManagement.readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        if(word != null) {
            wordexplain.setText(word.getWord_explain());
        }
        else {
            alert.setContentText("Not Word");
            alert.show();
        }
    }

    public void searchWord(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        DictionaryManagement.readFile("dict.txt", dict);
        String str = Dictionary.BinarySearch(wordtarget.getText());
        if(str != null) {
            wordtarget.setText(str);
        }
        else {
            alert.setContentText("Not Word");
            alert.show();
        }
    }

    public void speak() {
        String s = wordtarget.getText();
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        Voice voice = new Voice(s);
    }

    public void Translate() throws IOException {
        String s = wordtarget.getText();
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        wordexplain.setText(Translator.translate("en", "vi", s));
    }

    public void add() {
        String s = wordtarget.getText();
        DictionaryManagement.readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        if(word!= null) {
            alert.setContentText("This word already exists");
        }
        else {
            String t = wordexplain.getText();
            dict.push(new Word(s,t));
            alert.setContentText("you add completely!");
        }
        alert.show();
    }
}
