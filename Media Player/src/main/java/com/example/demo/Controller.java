package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    @FXML
    private ListView <String> myListView;

    @FXML
    private Pane pane;


    @FXML
    private Label songLabel;

    @FXML
    private Button playButton,pauseButton,restButton;

    @FXML
    private ProgressBar songProgressBar;

    private Media media;

    private MediaPlayer mediaPlayer;


    private File directory;
    private File[] files;


    private ArrayList<File> songs;


    private int songNumber;

    private  boolean running;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        directory = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\demo\\src\\main\\music");


        songs = new ArrayList<File>();

        files = directory.listFiles();


        if (files != null){

            for (File file : files) {
                songs.add(file);
                myListView.getItems().add(String.valueOf(file));
                media = new Media(songs.get(songNumber).toURI().toString());

            }
             myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                    mediaPlayer.stop();

                    media = null;
                    songNumber = 0;



                    directory = new File(myListView.getSelectionModel().getSelectedItem());

                    songs = new ArrayList<File>();

                    songs.add(directory);



                    media = new Media(songs.get(songNumber).toURI().toString());

                    mediaPlayer = new MediaPlayer(media);

                    songLabel.setText(songs.get(songNumber).getName());

                    songNumber = 1;






                }
            });

            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());

        }

    }

    public void playButton(){

        mediaPlayer.play();

    }
    public void pauseMedia(){

        mediaPlayer.pause();

    }
    public void resetMedia(){

        mediaPlayer.seek(Duration.seconds(0.0));

    }


    public void nextMedia() {



            if (songNumber < songs.size()-1  ){
                songNumber++;
                mediaPlayer.stop();

                media = null;

                media = new Media(songs.get(songNumber).toURI().toString());
                mediaPlayer = new MediaPlayer(media);

                songLabel.setText(songs.get(songNumber).getName());

                if (songNumber == songs.size()){

                    songNumber = 0;

                }


            } else if (songNumber == 0) {

                mediaPlayer.stop();



                directory = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\demo\\src\\main\\music");


                songs = new ArrayList<File>();

                files = directory.listFiles();


                if (files != null) {

                    for (File file : files) {
                        songs.add(file);
                        media = new Media(songs.get(songNumber).toURI().toString());

                    }
                }

                mediaPlayer = new MediaPlayer(media);
                songLabel.setText(songs.get(songNumber).getName());


                } else {
                songNumber = 0;
                mediaPlayer.stop();

                System.out.println("hello");

                media = new Media(songs.get(songNumber).toURI().toString());
                mediaPlayer = new MediaPlayer(media);

                songLabel.setText(songs.get(songNumber).getName());


            }





    }
}