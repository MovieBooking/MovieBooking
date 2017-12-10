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

    private List<Pane> cinema = new ArrayList<Pane>();
    private DataService _dataService;
    private List<List<Theater>> theater = new ArrayList<List<Theater>>();
    private List<Pane> ticket = new ArrayList<Pane>();
    private List<Movie> movie = new ArrayList<Movie>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        update(0);

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
                settingplan(theater.get(0).getTheater_id() - 1);
            }
        });
        btn.setLayoutX(475);
        btn.setLayoutY(160);
        pane.getChildren().addAll(movie_label, theater_label, imageView, btn);
        pane.setId("" + theater.get(0).getTheater_id());
        return pane;
    }

    public void settingplan(int theater_id) {
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
        createtimepane(theater_id);
        //timepane.getChildren().add(manage)
    }

    public void createtimepane(int theater_id) {
        GridPane timegrid = new GridPane();
        timegrid.setMinSize(450, 250);
        timegrid.setHgap(100);
        timegrid.getColumnConstraints().add(new ColumnConstraints(450));
        List<TextField> inputtime = new ArrayList<TextField>();
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
            TextField text = new TextField(theater1.getTime());
            text.setLayoutX(60);
            text.setLayoutY(10);

            inputtime.add(text);
            pane.getChildren().addAll(label, text);
            timegrid.add(pane, 0, inputtime.size() - 1);

        }
        newtimebtn.setLayoutX(400);
        newtimebtn.setLayoutY(400);
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
                TextField text = new TextField("");
                text.setLayoutX(60);
                text.setLayoutY(10);
                inputtime.add(text);
                pane.getChildren().addAll(label, text);
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
        removebtn.setLayoutX(320);
        removebtn.setLayoutY(400);

        Button cancelbtn = new Button("CANCEL");

        cancelbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingplan(theater_id);
            }
        });
        cancelbtn.setLayoutX(444);
        cancelbtn.setLayoutY(750);

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
                        Theater newtheater = new Theater(stemp, mtemp, _dataService.getScreen(theater_id + 1), inputtime.get(i).getText(), theater_id + 1, "SHOWING");
                        
                    }
                }
                _dataService.transactionCommit();
                update(theater_id);
            }
        });
        confirm.setLayoutX(515);
        confirm.setLayoutY(750);
        manage.getChildren().addAll(newtimebtn, removebtn, cancelbtn, confirm);
        timepane.setContent(timegrid);

    }

    public Movie getmovie(String temp) {
        for (Movie movie1 : movie) {
            if ((movie1.getName() + "(" + movie1.getLanguage() + ")").equals(temp)) {
                return movie1;
            }
        }
        return movie.get(0);
    }

    public void update(int initial) {
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
        settingplan(initial);
        //_dataService.closeConnection();
    }
}
