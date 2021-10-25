package com.example.test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.test.DictionaryManagement.*;

public class Controller {

    @FXML
    private TextArea wordtarget;
    @FXML
    private TextArea wordexplain;
    @FXML
    private TextField Eng;
    @FXML
    private TextField Vie;
    @FXML
    private TextField English;
    @FXML
    private TextArea Vietnamese;


    Dictionary dict= new Dictionary();



    private ArrayList<Word> array1 = new ArrayList<>();
    
    public void enterWord() {
        String s= English.getText();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
       //DictionaryManagement. insertFromFile();
        DictionaryManagement.readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        int check=0;
        for (Word value : array1) {
            if (word.getWord_target().equals(value.getWord_target())) {
                check = 1;
                break;
            }
        }
        if(word!=null && check!=1) {
            Vietnamese.setText(word.getWord_explain());
        }
        else {
            alert.setContentText("Not Word");
            alert.show();
            check=0;
        }
    }

    @FXML
    ListView<String> listviewword;

    public void k() {
        DictionaryManagement.readFile("dict.txt", dict);

        ArrayList<String> listsuggest = new ArrayList<>();
        ObservableList<String> listg = FXCollections.observableArrayList(listsuggest);
                listviewword.setItems(listg);
    }

    public void c(MouseEvent mouseEvent) {
        wordtarget.setText(listviewword.getSelectionModel().getSelectedItem());
    }
    public void speak() {
        String s= wordtarget.getText();
        //insertFromFile();
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        Voice voice= new Voice(s);
    }
    public void Translate() throws IOException {
        String s= wordtarget.getText();
        //insertFromFile();
        //DictionaryManagement.readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        wordexplain.setText(Translator.translate("en", "vi", s));
    }

    public void speak1() {
        String s= English.getText();
        //insertFromFile();
        Word word = Dictionary.binaryLookup(0,dict.getDict().size()-1,s);
        Voice voice= new Voice(s);
    }

    public void add() {
        String s = Eng.getText();
        //DictionaryManagement.readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0, dict.getDict().size() - 1, s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (word != null) {
            alert.setContentText("This word already exists");
        } else {
            String t = Vie.getText();
            Word word1 = new Word(s, t);
            dict.pushword(word1);
            alert.setContentText("you add completely!");
        }
        alert.show();
        //System.out.println("1");
    }

    public void delete() {
        String s = Eng.getText();
        readFile("dict.txt", dict);
        Word word = Dictionary.binaryLookup(0, dict.getDict().size() - 1, s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(word==null) {
            alert.setContentText("This word already exists");
        }
        else {
            array1.add(word);
            dict.getDict().remove(word);
            alert.setContentText("you delete completely!");
        }
        alert.show();
        //System.out.println("1");
       // System.out.println(array1.get(0).getWord_target());
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        DictionaryManagement.readFile("dict.txt", dict);
//        English.textProperty().addListener((observableValue, oldWord, newWord) -> {
//            //System.out.println(newWord);
//            ArrayList<Word> arrayl = Dictionary.BinarySearch(newWord);
//            if(arrayl.isEmpty()) {
//                listviewword.setVisible(false);
//            }
//            else {
//                listviewword.setVisible(true);
//            }
//            listviewword.getItems().clear();
//            arrayl.forEach(word -> listviewword.getItems().add(word.getWord_target()));
//            System.out.println(arrayl.size());
//        });
//        listviewword.addEventHandler(MouseEvent.MOUSE_CLICKED, event-> {
//            String s = listviewword.getSelectionModel().getSelectedItem();
//            English.setText(s);
//        });
//    }
}
