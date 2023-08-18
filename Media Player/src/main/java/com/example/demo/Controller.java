package com.example.demo;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.Node;




public class Controller implements Initializable {
    private Scene scene;

    public void login (ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogIn.fxml"));

        //Parent root = FXMLLoader.load()(getClass().getResource("LogIn.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }


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


        directory = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\music");


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
                    mediaPlayer.play();

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

    public void impo() throws IOException {

        File filepath = null;

        String MName = null;

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File(".")); //sets current directory

        int response = fileChooser.showOpenDialog(null); //select file to open
        //int response = fileChooser.showSaveDialog(null); //select file to save

        if (response == JFileChooser.APPROVE_OPTION) {
            filepath = new File(fileChooser.getSelectedFile().getAbsolutePath());
            MName = filepath.getName();


        }
        File destFile = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\music\\" + MName);



       FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;


        fileInputStream = new FileInputStream(filepath);
        fileOutputStream = new FileOutputStream(destFile);

        int i = 0;

        while ((i = fileInputStream.read()) !=-1){
            fileOutputStream.write(i);

        }

        Resume();





    }

       /* if (filepath.exists()){
            try (FileInputStream is = new FileInputStream(filepath); FileOutputStream os = new FileOutputStream(destFile)){
                if (!filepath.canRead()){
                    filepath.setReadable(true);
                    filepath.setWritable(true);
                }
                if (!destFile.canWrite()){
                    destFile.setReadable(true);
                    destFile.setWritable(true);
                }
                int len;
                float srcFileSize = is.available()/1000.0f;
                float totalCopied = 0.0f;
                byte[] bytes = new byte[1024];
                while((len = is.read(bytes))>0){
                    os.write(bytes, 0,len);
                    totalCopied += len;
                    System.out.print("\rCopied..."+ totalCopied/1000.0f + "kb/" +srcFileSize+"kb");
                    Thread.sleep(5);

                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        */

    void Resume(){

        myListView.getItems().clear();

        directory = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\music");


        songs = new ArrayList<File>();

        files = directory.listFiles();


        if (files != null) {

            for (File file : files) {
                songs.add(file);
                myListView.getItems().add(String.valueOf(file));
                media = new Media(songs.get(songNumber).toURI().toString());

            }
        }



    }



    public void test() throws IOException {

        FileReader reader = new FileReader("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\loginfo\\h.txt");
        int data = reader.read();
        while(data != -1) {
            System.out.print((char)data);
            data = reader.read();
        }
        reader.close();

    }


    public void nextMedia() {



            if (songNumber < songs.size()-1  ){
                songNumber++;
                mediaPlayer.stop();

                media = null;

                media = new Media(songs.get(songNumber).toURI().toString());
                mediaPlayer = new MediaPlayer(media);

                songLabel.setText(songs.get(songNumber).getName());

                mediaPlayer.play();

                if (songNumber == songs.size()){

                    songNumber = 0;

                }


            } else if (songNumber == 0) {

                mediaPlayer.stop();



                directory = new File("C:\\Users\\Avishka\\Documents\\Java Applications\\Media Player\\src\\main\\music");


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

                mediaPlayer.play();


                } else {
                songNumber = 0;
                mediaPlayer.stop();

                System.out.println("hello");

                media = new Media(songs.get(songNumber).toURI().toString());
                mediaPlayer = new MediaPlayer(media);

                songLabel.setText(songs.get(songNumber).getName());
                mediaPlayer.play();


            }





    }
}