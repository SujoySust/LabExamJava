package project;

import javafx.scene.paint.Color;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Project extends Application {

    Stage window;
    Scene scene1, studentScene, teacherScene, studentui, teacherui;
    String IP;
    InetAddress ipAddr = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        try {
            ipAddr = InetAddress.getLocalHost();
            ipAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        //FIRST USER INTERFACE //
        
        Button button1 = new Button("Student");
        Button button2 = new Button("Teacher");

        //  STUDENT USER INTERFACE ///;
        button1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {

                    Text text1 = new Text("Enter Your Port: ");
                    text1.setStyle("-fx-font: normal bold 20px 'serif';");
                    text1.setFill(Color.WHITE);
                    TextField textField1 = new TextField();
                    textField1.setStyle(" -fx-font-family: \"Quicksand\";\n" +
                                        "   -fx-font-size: 18;\n" +
                                        "   -fx-padding: 1,1,1,1;\n" +
                                        "   -fx-border-color: grey;\n" +
                                        "   -fx-border-width: 2;\n" +
                                        "   -fx-border-radius: 1;\n" +
                                        "   -fx-border: gone;\n" +
                                        "   -fx-background-color: transparent;\n" +
                                        "   -fx-text-fill: white;");
                    Button pre1 = new Button("Previous");
                        pre1.setStyle("   -fx-background-color: \n"
                                        + "        #000000,\n"
                                        + "        linear-gradient(#7ebcea, #2f4b8f),\n"
                                        + "        linear-gradient(#426ab7, #263e75),\n"
                                        + "        linear-gradient(#395cab, #223768);\n"
                                        + "    -fx-background-insets: 0,1,2,3;\n"
                                        + "    -fx-background-radius: 3,2,2,2;\n"
                                        + "    -fx-padding: 12 30 12 30;\n"
                                        + "    -fx-text-fill: white;\n"
                                        + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");
                    Button next1 = new Button("Next");
                     next1.setStyle("   -fx-background-color: \n"
                                        + "        #000000,\n"
                                        + "        linear-gradient(#7ebcea, #2f4b8f),\n"
                                        + "        linear-gradient(#426ab7, #263e75),\n"
                                        + "        linear-gradient(#395cab, #223768);\n"
                                        + "    -fx-background-insets: 0,1,2,3;\n"
                                        + "    -fx-background-radius: 3,2,2,2;\n"
                                        + "    -fx-padding: 12 30 12 30;\n"
                                        + "    -fx-text-fill: white;\n"
                                        + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");
                    
                    pre1.setOnAction(e -> window.setScene(scene1));
                    next1.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {

                                IP = textField1.getText().toString();
                                WebView myWebView1 = new WebView();
                                ProgressBar progressBar = null;
                                WebEngine engine1 = myWebView1.getEngine();
                                System.out.println(IP);
                                String url = "http://" + IP + "/exam/index.php";
                              //  engine1.javaScriptEnabledProperty();                              
                                engine1.setJavaScriptEnabled(true);
                                engine1.setOnError(this);
                                engine1.load(url);

                                VBox student = new VBox();
                                
                                Button previous;
                                previous=new Button("Previous");
                               
                                HBox hbox =new HBox();
                                
                                hbox.setAlignment(Pos.CENTER);
                                hbox.setSpacing(10);
                                System.out.println(url);
                                student.setSpacing(10);
                                student.setAlignment(Pos.CENTER);
                                Button button3 = new Button("First Page");
                                button3.setStyle("   -fx-background-color: \n"
                                        + "        #000000,\n"
                                        + "        linear-gradient(#7ebcea, #2f4b8f),\n"
                                        + "        linear-gradient(#426ab7, #263e75),\n"
                                        + "        linear-gradient(#395cab, #223768);\n"
                                        + "    -fx-background-insets: 0,1,2,3;\n"
                                        + "    -fx-background-radius: 3,2,2,2;\n"
                                        + "    -fx-padding: 12 30 12 30;\n"
                                        + "    -fx-text-fill: white;\n"
                                        + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");
                                
                                 previous.setStyle("   -fx-background-color: \n"
                                        + "        #000000,\n"
                                        + "        linear-gradient(#7ebcea, #2f4b8f),\n"
                                        + "        linear-gradient(#426ab7, #263e75),\n"
                                        + "        linear-gradient(#395cab, #223768);\n"
                                        + "    -fx-background-insets: 0,1,2,3;\n"
                                        + "    -fx-background-radius: 3,2,2,2;\n"
                                        + "    -fx-padding: 12 30 12 30;\n"
                                        + "    -fx-text-fill: white;\n"
                                        + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");
                                button3.setOnAction(e -> window.setScene(scene1));
                                previous.setOnAction(e -> window.setScene(studentui));
                                hbox.getChildren().addAll(previous,button3);
                                student.setStyle("-fx-background-color: #2f4f4f;");
                                student.getChildren().addAll(hbox, myWebView1);
                                studentScene = new Scene(student, 900, 650);

                                window.setScene(studentScene);

                            } catch (Exception e) {
                                System.out.println("QQQQQQQQQQQQQQQQQQQ");
                            }
                        }
                    });

                    GridPane studentUiLayout = new GridPane();
                    studentUiLayout.setPadding(new Insets(10, 10, 10, 10));
                    studentUiLayout.setVgap(15);
                    studentUiLayout.setHgap(15);
                    studentUiLayout.setAlignment(Pos.CENTER);
                    studentUiLayout.add(text1, 2, 0);
                    studentUiLayout.add(textField1, 2, 1);
                    studentUiLayout.add(pre1, 0, 1);
                    studentUiLayout.add(next1, 4, 1);
                    studentUiLayout.setStyle("-fx-background-color: #2f4f4f;");
                    studentui = new Scene(studentUiLayout, 600, 500);
                    window.setScene(studentui);

                } catch (Exception e) {
                    System.out.println("Exception on first");
                }

            }
        });

        //  STUDENT USER INTERFACE ///;
       
                               
        /// Teacher User Interface ///
        button2.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {

                    Text ipaddress = new Text("IP ADDRESS : " + ipAddr.getHostAddress().toString());
                    ipaddress.setStyle("-fx-font: normal bold 20px 'serif';");
                    ipaddress.setFill(Color.WHITE);
                    Button pre = new Button("Previous");
                    Button next = new Button("Next");
                    pre.setOnAction(e -> window.setScene(scene1));
                    next.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                WebView myWebView2 = new WebView();
                                WebEngine engine2 = myWebView2.getEngine();
                                engine2.load("http://" + ipAddr.getHostAddress() + "/exam/admin/login.php");
                                VBox teacher = new VBox();
                                teacher.setSpacing(10);
                                teacher.setAlignment(Pos.CENTER);
                                Button button4 = new Button("First Page");
                                button4.setStyle("   -fx-background-color: \n"
                                        + "        #000000,\n"
                                        + "        linear-gradient(#7ebcea, #2f4b8f),\n"
                                        + "        linear-gradient(#426ab7, #263e75),\n"
                                        + "        linear-gradient(#395cab, #223768);\n"
                                        + "    -fx-background-insets: 0,1,2,3;\n"
                                        + "    -fx-background-radius: 3,2,2,2;\n"
                                        + "    -fx-padding: 12 30 12 30;\n"
                                        + "    -fx-text-fill: white;\n"
                                        + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");
                                button4.setOnAction(e -> window.setScene(scene1));
                                teacher.setStyle("-fx-background-color: #2f4f4f;");
                                teacher.getChildren().addAll(button4, myWebView2);
                                teacherScene = new Scene(teacher, 900, 650);
                                window.setScene(teacherScene);

                            } catch (Exception e) {
                                System.out.println("Wrong!!!");
                            }

                        }
                    });
                    GridPane teacherUiLayout = new GridPane();
                    teacherUiLayout.setPadding(new Insets(10, 10, 10, 10));
                    teacherUiLayout.setVgap(15);
                    teacherUiLayout.setHgap(15);
                    teacherUiLayout.setAlignment(Pos.CENTER);
                    teacherUiLayout.add(ipaddress, 0, 0);
                    teacherUiLayout.add(pre, 0, 2);
                    teacherUiLayout.add(next, 2, 2);

                    pre.setStyle("   -fx-background-color: \n"
                            + "        linear-gradient(#ffd65b, #e68400),\n"
                            + "        linear-gradient(#ffef84, #f2ba44),\n"
                            + "        linear-gradient(#ffea6a, #efaa22),\n"
                            + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n"
                            + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n"
                            + "    -fx-background-radius: 30;\n"
                            + "    -fx-background-insets: 0,1,2,3,0;\n"
                            + "    -fx-text-fill: #654b00;\n"
                            + "    -fx-font-weight: bold;\n"
                            + "    -fx-font-size: 20px;\n"
                            + "    -fx-padding: 10 20 10 20;");
                    next.setStyle("   -fx-background-color: \n"
                            + "        linear-gradient(#ffd65b, #e68400),\n"
                            + "        linear-gradient(#ffef84, #f2ba44),\n"
                            + "        linear-gradient(#ffea6a, #efaa22),\n"
                            + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n"
                            + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n"
                            + "    -fx-background-radius: 30;\n"
                            + "    -fx-background-insets: 0,1,2,3,0;\n"
                            + "    -fx-text-fill: #654b00;\n"
                            + "    -fx-font-weight: bold;\n"
                            + "    -fx-font-size: 20px;\n"
                            + "    -fx-padding: 10 20 10 20;");
                    teacherUiLayout.setStyle("-fx-background-color: #2f4f4f;");
                    teacherui = new Scene(teacherUiLayout, 400, 300);
                    window.setScene(teacherui);

                } catch (Exception E) {

                    System.out.println("Teacher First ui exception");

                }
            }
        });

        /// Teacher User Interface ///
      
        
        ///First  Scene Interface ///
        
        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.setVgap(15);
        layout1.setHgap(15);
        layout1.setAlignment(Pos.CENTER);
        layout1.add(button1, 0, 2);
        layout1.add(button2, 0, 3);
        button1.setStyle("   -fx-background-color: \n"
                + "        linear-gradient(#ffd65b, #e68400),\n"
                + "        linear-gradient(#ffef84, #f2ba44),\n"
                + "        linear-gradient(#ffea6a, #efaa22),\n"
                + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n"
                + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,2,3,0;\n"
                + "    -fx-text-fill: #654b00;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 20px;\n"
                + "    -fx-padding: 10 20 10 20;");
        button2.setStyle("   -fx-background-color: \n"
                + "        linear-gradient(#ffd65b, #e68400),\n"
                + "        linear-gradient(#ffef84, #f2ba44),\n"
                + "        linear-gradient(#ffea6a, #efaa22),\n"
                + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n"
                + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,2,3,0;\n"
                + "    -fx-text-fill: #654b00;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 20px;\n"
                + "    -fx-padding: 10 20 10 20;");
        layout1.setStyle("-fx-background-color: #2f4f4f;");
        scene1 = new Scene(layout1, 500, 500);
        window.setScene(scene1);
        
        ///First  Scene Interface ///
        
        window.setResizable(false);
        window.show();
        window.setX(200);
        window.setY(10);
        window.setTitle("Online Examination");
        
        
    }
}
