/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package moviebookingfx;



import Class.*;

import com.objectdb.o.MSS;

import java.net.URL;

import java.util.ArrayList;

import java.util.List;

import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;

import javafx.event.EventHandler;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.geometry.Insets;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.*;



/**

 *

 * @author Sivakorn

 */

public class ManageMovieControlller implements Initializable {



    @FXML

    private ScrollPane scrollpane;



    @FXML

    private AnchorPane showingpane;



    @FXML

    private AnchorPane manage;



    @FXML

    private ComboBox movieselector;



    @FXML

    private Label header;



    @FXML

    private ComboBox screenselector;



    @FXML

    private ComboBox sizeselect;



    @FXML

    private ScrollPane timepane;



    @FXML

    private AnchorPane moviemange;



    @FXML

    private ComboBox movieselector1;



    @FXML

    private TextField moviename;



    @FXML

    private TextField lenghth;



    @FXML

    private TextField releasedate;



    @FXML

    private TextField image;



    @FXML

    private TextField language;



    @FXML

    private TextField ratename;



    @FXML

    private Button mconfirmbtn;



    @FXML

    private Button mcancelbtn;



    @FXML

    private TextField genre;



    private List<Pane> cinema = new ArrayList<Pane>();

    private DataService _dataService;

    private List<List<Theater>> theater = new ArrayList<List<Theater>>();

    private List<Movie> movie = new ArrayList<Movie>();

    private int theater_id = 0;

    private String nowmovie = "New Movie";



    @Override

    public void initialize(URL url, ResourceBundle rb) {

        // TODO

        update();



    }



    public Pane createPane(List<Theater> theater) {

        Pane pane = new Pane();

        pane.minHeight(100);

        pane.minWidth(600);

        pane.setStyle("-fx-border-color:red;");

        pane.setPadding(new Insets(8));

        Label movie_label = new Label(String.format("MOVIE : %-20s DURATION : %-20d LANGUAGE : %-20s\nGENRE: %-20s RATE: %-20s RELEASEDATE : %-20s", theater.get(0).getMovie().getName(), theater.get(0).getMovie().getLength(), theater.get(0).getMovie().getLanguage(), theater.get(0).getMovie().getGenre(), theater.get(0).getMovie().getRatename(), theater.get(0).getMovie().getReleaseDate()));



        Label theater_label = new Label(String.format("THEATER %2d %s", theater.get(0).getTheater_id(), theater.get(0).getScreen().getName()));

        theater_label.setLayoutX(200);

        theater_label.setLayoutY(5);

        theater_label.setStyle("-fx-font-size:25px;");

        Image image = new Image(theater.get(0).getMovie().getImage(), 100, 150, false, true);

        ImageView imageView = new ImageView(image);

        imageView.setLayoutX(13);

        imageView.setLayoutY(39);



        for (Theater theater1 : theater) {

            movie_label = new Label(String.format("%s \nTime : %-20s Status :%-20s", movie_label.getText(), theater1.getTime(), theater1.getStatus()));

        }

        movie_label.setLayoutX(126);

        movie_label.setLayoutY(48);

        Button btn = new Button("MANANGE >>");

        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                theater_id = theater.get(0).getTheater_id() - 1;

                settingplan();

            }

        });

        btn.setLayoutX(475);

        btn.setLayoutY(160);

        pane.getChildren().addAll(movie_label, theater_label, imageView, btn);

        pane.setId("" + theater.get(0).getTheater_id());

        return pane;

    }



    public void settingplan() {

        header.setText("THEATER : " + theater.get(theater_id).get(0).getTheater_id());

        movieselector.getItems().clear();

        screenselector.getItems().clear();

        sizeselect.getItems().clear();

        for (Movie movie1 : movie) {

            movieselector.getItems().add(movie1.getName() + "(" + movie1.getLanguage() + ")");

            movieselector.setPromptText(theater.get(theater_id).get(0).getMovie().getName() + "(" + theater.get(theater_id).get(0).getMovie().getLanguage() + ")");

        }

        screenselector.getItems().addAll("Digital Screen", "4DX Screen", "Imax Screen", "3D Screen", "Ultra Screen");

        screenselector.setPromptText(theater.get(theater_id).get(0).getScreen().getName());

        sizeselect.getItems().addAll("Small", "Medium", "Large");

        sizeselect.setPromptText(theater.get(theater_id).get(0).getSize());

        createtimepane();

        //timepane.getChildren().add(manage)

    }



    public void createtimepane() {

        GridPane timegrid = new GridPane();

        timegrid.setMinSize(450, 250);

        timegrid.setHgap(100);

        timegrid.getColumnConstraints().add(new ColumnConstraints(450));

        List<TextField> inputtime = new ArrayList<TextField>();

        List<Label> label_status = new ArrayList<Label>();

        Button newtimebtn = new Button("NEW TIME");



        //cost += theater.getScreen().getPrice();

        for (Theater theater1 : theater.get(theater_id)) {

            Pane pane = new Pane();

            pane.setPadding(new Insets(2));

            pane.minHeight(50);

            pane.minWidth(50);

            pane.setStyle("-fx-border-color:red;");

            Label label = new Label("TIME " + (inputtime.size() + 1) + " : ");

            label.setLayoutX(13);

            label.setLayoutY(13);

            Label status = new Label("STATUS : " + theater1.getStatus());

            label_status.add(status);

            status.setLayoutX(170);

            status.setLayoutY(13);

            TextField text = new TextField(theater1.getTime());

            text.setMaxWidth(60);

            text.setLayoutX(60);

            text.setLayoutY(10);



            inputtime.add(text);

            Button statusbtn = new Button("STATUS");

            statusbtn.setLayoutX(305);

            statusbtn.setLayoutY(10);

            statusbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override

                public void handle(MouseEvent event) {

                    if (status.getText().equals("STATUS : SHOWING")) {

                        status.setText("STATUS : DONE");

                    } else {

                        status.setText("STATUS : SHOWING");

                    }

                }

            });

            pane.getChildren().addAll(label, text, status, statusbtn);

            timegrid.add(pane, 0, inputtime.size() - 1);



        }

        newtimebtn.setLayoutX(513);

        newtimebtn.setLayoutY(356);

        newtimebtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                Pane pane = new Pane();

                pane.setPadding(new Insets(2));

                pane.minHeight(50);

                pane.minWidth(50);

                pane.setStyle("-fx-border-color:red;");

                Label label = new Label("TIME " + (inputtime.size() + 1) + " : ");

                label.setLayoutX(13);

                label.setLayoutY(13);

                TextField text = new TextField("00:00");

                text.setMaxWidth(60);

                text.setLayoutX(60);

                text.setLayoutY(10);

                Label status = new Label("STATUS : " + "SHOWING");

                label_status.add(status);

                status.setLayoutX(170);

                status.setLayoutY(13);

                Button statusbtn = new Button("STATUS");

                statusbtn.setLayoutX(305);

                statusbtn.setLayoutY(10);

                statusbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override

                    public void handle(MouseEvent event) {

                        if (status.getText().equals("STATUS : SHOWING")) {

                            status.setText("STATUS : DONE");



                        } else {

                            status.setText("STATUS : SHOWING");

                        }

                    }

                });

                inputtime.add(text);

                pane.getChildren().addAll(label, text, status, statusbtn);

                timegrid.add(pane, 0, inputtime.size() - 1);

            }

        });

        Button removebtn = new Button("REMOVE");

        removebtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                timegrid.getChildren().remove(inputtime.size() - 1);

                inputtime.remove(inputtime.size() - 1);

            }

        });

        removebtn.setMinWidth(72);

        removebtn.setLayoutX(513);

        removebtn.setLayoutY(323);



        Button cancelbtn = new Button("CANCEL");



        cancelbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                settingplan();

            }

        });

        cancelbtn.setLayoutX(360);

        cancelbtn.setLayoutY(400);



        //return timegrid;

        Button confirm = new Button("CONFIRM");

        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent event) {

                _dataService.transactionBegin();

                Movie mtemp;

                if (movieselector.getValue() != null) {

                    mtemp = getmovie("" + movieselector.getValue());

                } else {

                    mtemp = theater.get(theater_id).get(0).getMovie();

                }

                String stemp;

                if (sizeselect.getValue() != null) {

                    stemp = sizeselect.getValue() + "";

                } else {

                    stemp = theater.get(theater_id).get(0).getSize();

                }

                if (screenselector.getValue() != null) {

                    if ((screenselector.getValue() + "").equals("Digital Screen")) {

                        theater.get(theater_id).get(0).getScreen().createdigitalscreen();

                    } else if ((screenselector.getValue() + "").equals("4DX Screen")) {

                        theater.get(theater_id).get(0).getScreen().create4dxscreen();

                    } else if ((screenselector.getValue() + "").equals("Imax Screen")) {

                        theater.get(theater_id).get(0).getScreen().createimaxscreen();;

                    } else if ((screenselector.getValue() + "").equals("3D Screen")) {

                        theater.get(theater_id).get(0).getScreen().create3dscreen();

                    } else {

                        theater.get(theater_id).get(0).getScreen().createultrascreen();

                    }

                }

                _dataService.transactionCommit();

                _dataService.transactionBegin();

                for (int i = theater.get(theater_id).size() - 1; i >= inputtime.size(); i--) {

                    if (i != 0) {

                        //_dataService.transactionBegin();

                        theater.get(theater_id).get(0).getScreen().removeTheater(theater.get(theater_id).get(i));

                        theater.get(theater_id).get(0).getMovie().removeTheater(theater.get(theater_id).get(i));

                        // theater.get(theater_id).get(i).getScreen().removeTheater(theater.get(theater_id).get(i));

                        //_dataService.transactionCommit();

                        for (List<Seats> seat : theater.get(theater_id).get(i).getSeats()) {

                            for (Seats seats : seat) {

                                _dataService.getEm().remove(seats);

                            }

                        }



                        _dataService.remove(theater.get(theater_id).get(i).getId());

                    }

                }

                //_dataService.transactionBegin();

                _dataService.transactionCommit();

                _dataService.transactionBegin();

                for (int i = 0; i < inputtime.size(); i++) {



                    if (i < theater.get(theater_id).size()) {

                        if (label_status.get(i).getText().equals("STATUS : SHOWING")) {

                            theater.get(theater_id).get(i).setStatus("SHOWING");

                        } else {

                            theater.get(theater_id).get(i).setStatus("DONE");

                        }

                        if (movieselector.getValue() != null) {

                            theater.get(theater_id).get(i).getMovie().removeTheater(theater.get(theater_id).get(i));

                            mtemp.addTheater(theater.get(theater_id).get(i));

                        }

                        if (sizeselect.getValue() != null && !((sizeselect.getValue() + "").equals(theater.get(theater_id).get(i).getSize()))) {



                            theater.get(theater_id).get(i).setSize(sizeselect.getValue() + "");

                            for (List<Seats> seat : theater.get(theater_id).get(i).getSeats()) {

                                for (Seats seats : seat) {

                                    _dataService.getEm().remove(seats);

                                }

                            }

                            if ((sizeselect.getValue() + "").equals("Large")) {

                                theater.get(theater_id).get(i).createLargeTheater();

                            } else if ((sizeselect.getValue() + "").equals("Medium")) {

                                theater.get(theater_id).get(i).createMediumTheater();

                            } else {

                                theater.get(theater_id).get(i).createSmallTheater();

                            }

                        }

                        theater.get(theater_id).get(i).setTime(inputtime.get(i).getText());



                    } else {

                        if (label_status.get(i).getText().equals("STATUS : SHOWING")) {

                            Theater newtheater = new Theater(stemp, mtemp, _dataService.getScreen(theater_id + 1), inputtime.get(i).getText(), theater_id + 1, "SHOWING");

                        } else {

                            Theater newtheater = new Theater(stemp, mtemp, _dataService.getScreen(theater_id + 1), inputtime.get(i).getText(), theater_id + 1, "DONE");



                        }



                    }

                }

                _dataService.transactionCommit();

                update();

            }

        });

        confirm.setLayoutX(430);

        confirm.setLayoutY(400);

        manage.getChildren().addAll(newtimebtn, removebtn, cancelbtn, confirm);

        timepane.setContent(timegrid);



    }



    public void settingmovie() {

        movieselector1.getItems().clear();

        movieselector1.getItems().add("New Movie");

        for (Movie movie1 : movie) {

            movieselector1.getItems().add(movie1.getName() + "(" + movie1.getLanguage() + ")");

        }

            movieselector1.getSelectionModel().selectFirst();

            movieselector1.valueProperty().addListener(new ChangeListener<String>() {

                @Override

                public void changed(ObservableValue ov, String t, String t1) {

                    setmovie(t1);

                }

            });



    }



    public void setmovie(String movietemp) {

        if (movietemp.equals("New Movie")) {

            moviename.setText("");

            lenghth.setText("");

            releasedate.setText("");

            image.setText("");

            ratename.setText("");

            language.setText("");

            genre.setText("");

        } else {

            for (Movie movie1 : movie) {

                if ((movie1.getName() + "(" + movie1.getLanguage() + ")").equals(movietemp)) {

                    moviename.setText(movie1.getName());

                    lenghth.setText(String.valueOf(movie1.getLength()));

                    releasedate.setText(movie1.getReleaseDate());

                    image.setText(movie1.getImage());

                    ratename.setText(movie1.getRatename());

                    language.setText(movie1.getLanguage());

                    genre.setText(movie1.getGenre());

                }

            }

        }

    }



    public Movie getmovie(String temp) {

        for (Movie movie1 : movie) {

            if ((movie1.getName() + "(" + movie1.getLanguage() + ")").equals(temp)) {

                return movie1;

            }

        }

        return movie.get(0);

    }



    public void update() {

        theater.clear();

        _dataService = new DataService();

        movie = _dataService.getAllMovie();

        GridPane gridpane = new GridPane();

        gridpane.setStyle("-fx-border-color:blue;");

        gridpane.setMinSize(229, 630);

        gridpane.setHgap(100);

        gridpane.getColumnConstraints().add(new ColumnConstraints(600));

        scrollpane.setContent(gridpane);

        for (int i = 1; i < 11; i++) {

            theater.add(_dataService.getTheater(i));

            cinema.add(createPane(theater.get(i - 1)));

            gridpane.add(cinema.get(cinema.size() - 1), 0, i - 1);

        }

        settingplan();

        settingmovie();

        //_dataService.closeConnection();

    }



    public void enddayclear() {

        _dataService.transactionBegin();

        for (List<Theater> list : theater) {

            for (Theater theater1 : list) {

                for (List<Seats> seat : theater1.getSeats()) {

                    for (Seats seats : seat) {

                        seats.setIsBook(false);

                    }

                }

            }

        }

        _dataService.transactionCommit();

    }



    public void movieconfirm() {

        int temprate = 0;

        if (ratename.getText().equals("G")) {

            temprate = 0;

        } else {

            temprate = Integer.parseInt(ratename.getText().replace("+", ""));

        }

        if (movieselector1.getValue().equals("New Movie")) {

            _dataService.createMovie(new Movie(moviename.getText(), Integer.parseInt(lenghth.getText()), genre.getText(), releasedate.getText(), image.getText(), temprate, language.getText()));

        } else {

            for (Movie movie1 : movie) {

                if ((movie1.getName() + "(" + movie1.getLanguage() + ")").equals(movieselector1.getValue())) {

                    _dataService.transactionBegin();

                    movie1.setName(moviename.getText());

                    movie1.setLength(Integer.parseInt(lenghth.getText()));

                    movie1.setReleaseDate(releasedate.getText());

                    movie1.setImage(image.getText());

                    movie1.setRatename(ratename.getText());

                    movie1.setGenre(genre.getText());

                    movie1.setRate(temprate);

                    _dataService.transactionCommit();

                }

            }

        }

        nowmovie = (moviename.getText()+ "(" + language.getText()+ ")");

        movie = _dataService.getAllMovie();

        movieselector1.getItems().remove(movieselector1.getValue());

        movieselector1.getItems().add(nowmovie);

        if(movieselector1.getValue().equals("New Movie"))

        movieselector1.getItems().add(nowmovie);

        

             movieselector1.getSelectionModel().select(nowmovie);

    }



    public void moviecancel() {

        if (movieselector1.getValue().equals("New Movie")) {

            moviename.setText("");

            lenghth.setText("");

            releasedate.setText("");

            image.setText("");

            ratename.setText("");

            language.setText("");

            genre.setText("");

        } else {

            for (Movie movie1 : movie) {

                if ((movie1.getName() + "(" + movie1.getLanguage() + ")").equals(movieselector1.getValue())) {

                    moviename.setText(movie1.getName());

                    lenghth.setText(String.valueOf(movie1.getLength()));

                    releasedate.setText(movie1.getReleaseDate());

                    image.setText(movie1.getImage());

                    genre.setText(movie1.getGenre());

                    ratename.setText(movie1.getRatename());

                    language.setText(movie1.getLanguage());

                }

            }

        }

    }

    public void back(){

        

    }

}