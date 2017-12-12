/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author terkg
 */
public class TheaterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private SplitPane Splitpane;
    
    @FXML
    private AnchorPane theaterpane;
    
    @FXML
    private Button back;
    
    @FXML
    private DialogPane dialog;
    
    @FXML
    private TextField phonenumber;
    
    @FXML
    private TextField promotion;
    
    @FXML
    private Label totalcost;
    
    @FXML
    private Label discount;
    
    @FXML
    private Button buybutton;
    
    @FXML
    private ScrollPane scrollpane;
    
    @FXML
    private AnchorPane ticketpane;
    
    @FXML
    private Label cost;
    
    int theater_id;
    int theater_index;
    int ticket_id;
    private DataService _dataService = new DataService();
    private Theater theater;
    private List<Pane> ticket = new ArrayList<Pane>();
    private List<Seats> ticket_seat = new ArrayList<Seats>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public Pane createPane(String name, String position, int cost, String time, String seat) {
        cost += theater.getScreen().getPrice();
        Pane pane = new Pane();
        pane.minHeight(150);
        pane.minWidth(229);
        pane.setStyle("-fx-border-color:red;");
        pane.setPadding(new Insets(8));
        Label name_label = new Label(name);
        name_label.setLayoutX(13);
        name_label.setLayoutY(13);
        Label position_label = new Label("Seat : " + position);
        position_label.setLayoutY(26);
        position_label.setLayoutX(50);
        position_label.setStyle("-fx-font-size:25px;");
        Label time_label = new Label("Time:" + time);
        time_label.setLayoutX(150);
        time_label.setLayoutY(13);
        Label cost_label = new Label("Cost:" + cost);
        cost_label.setLayoutX(150);
        cost_label.setLayoutY(58);
        Label seat_label = new Label(seat);
        seat_label.setLayoutX(13);
        seat_label.setLayoutY(58);
        pane.getChildren().addAll(seat_label, name_label, position_label, time_label, cost_label);
        pane.setId(position);
        return pane;
    }
    
    @FXML
    public void confirm(ActionEvent event) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("PAYMENT");
        dialog.setHeaderText("Input your Accout and Promotion.");
        
        ButtonType submitButtonType = new ButtonType("Submit", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, ButtonType.CANCEL);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField account = new TextField();
        account.setPromptText("E-mail");
        TextField promotion_code = new TextField();
        promotion_code.setPromptText("Promotion Code");
        
        grid.add(new Label("E-mail :"), 0, 0);
        grid.add(account, 1, 0);
        grid.add(new Label("Promotion :"), 0, 1);
        grid.add(promotion_code, 1, 1);
        
        Node submitButton = dialog.getDialogPane().lookupButton(submitButtonType);
       
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> account.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == submitButtonType) {
                return new Pair<>(account.getText(), promotion_code.getText());
            }
            return null;
        });
        
        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(AccountPromotion -> {
            boolean check = false;
            List<Account> temp = _dataService.getAllAccount();
            List<Promotion> temp1 = _dataService.getAllPromotion();
            for (Account account1 : temp) {
                if (check==false||AccountPromotion.getKey().equals(account1.getEmail())) {
                    for (Promotion promotion1 : temp1) {
                        if (AccountPromotion.getValue().equals(promotion1.getCode())) {
                            try {
                                nextDialog(AccountPromotion.getKey(), AccountPromotion.getValue());
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                        else if(AccountPromotion.getValue().equals("")){
                            try {
                                nextDialog(AccountPromotion.getKey(), "");
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                    }   
                }
                else if(check==false||AccountPromotion.getKey().equals(""))
                   for (Promotion promotion1 : temp1) {
                        if (AccountPromotion.getValue().equals(promotion1.getCode())) {
                            try {
                                nextDialog("", AccountPromotion.getValue());
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                        else if(AccountPromotion.getValue().equals("")){
                            try {
                                nextDialog("", "");
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                    }  
                if (check == true) {
                    break;
                }
            }
            if (check != true) {
                confirmagain();
            }
            
        });
    }
    
    public void confirmagain() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("PAYMENT");
        dialog.setHeaderText("Wrong Account Or Promotion");
        
        ButtonType submitButtonType = new ButtonType("Submit", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, ButtonType.CANCEL);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        TextField account = new TextField();
        account.setPromptText("E-mail");
        TextField promotion_code = new TextField();
        promotion_code.setPromptText("Promotion Code");
        
        grid.add(new Label("E-mail :"), 0, 0);
        grid.add(account, 1, 0);
        grid.add(new Label("Promotion :"), 0, 1);
        grid.add(promotion_code, 1, 1);
        
        Node submitButton = dialog.getDialogPane().lookupButton(submitButtonType);
       
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> account.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == submitButtonType) {
                return new Pair<>(account.getText(), promotion_code.getText());
            }
            return null;
        });
        
        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(AccountPromotion -> {
            boolean check = false;
            List<Account> temp = _dataService.getAllAccount();
            List<Promotion> temp1 = _dataService.getAllPromotion();
            for (Account account1 : temp) {
                if (check==false||AccountPromotion.getKey().equals(account1.getEmail())) {
                    for (Promotion promotion1 : temp1) {
                        if (AccountPromotion.getValue().equals(promotion1.getCode())) {
                            try {
                                nextDialog(AccountPromotion.getKey(), AccountPromotion.getValue());
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                        else if(AccountPromotion.getValue().equals("")){
                            try {
                                nextDialog(AccountPromotion.getKey(), "");
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                    }   
                }
                else if(check==false||AccountPromotion.getKey().equals(""))
                   for (Promotion promotion1 : temp1) {
                        if (AccountPromotion.getValue().equals(promotion1.getCode())) {
                            try {
                                nextDialog("", AccountPromotion.getValue());
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                        else if(AccountPromotion.getValue().equals("")){
                            try {
                                nextDialog("", "");
                            } catch (IOException ex) {
                                Logger.getLogger(TheaterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            check = true;
                            break;
                        }
                    }  
                 if (check == true) {
                    break;
                }

            }
            if (check != true) {
                confirmagain();
            }
        });
    }
    
    public void nextDialog(String email, String code) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm your payment.");
        Account account;
        Promotion promotion;
        if(!email.equals(""))
            account = _dataService.getAccount(email);
        else
            account = new Account("-","-", "-", "-", "-");
        if(!code.equals(""))
             promotion = _dataService.getPromotion(code);
        else
            promotion = new Promotion("-", "-","-", 0);
        
        int sumofcost = Integer.parseInt(cost.getText());
        int accountdis = sumofcost * account.getDiscount() / 100;
        float promotiondis = sumofcost * promotion.getDiscount() / 100;
        float totalcost = sumofcost - (accountdis + promotiondis);
        String discount = (String.format("COST : %s.00 BATH\n %sDiscount : %d.00 BATH\nPromotion %s Discount : %.2f BATH\nTOTAL : %.2f BATH", cost.getText(), account.getMember(), accountdis, promotion.getName(), promotiondis, totalcost));
        alert.setContentText(discount);
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            for (Pane pane : ticket) {
                for (List<Seats> seat : theater.getSeats()) {
                    for (Seats seats : seat) {
                        if (pane.getId().equals(seats.getPosition())) {
                            ticket_seat.add(seats);
                        }
                    }
                }
            }
            Report report = new Report(theater, ticket_seat, account, cost.getText(), promotion);
            _dataService.createReport(report);
            finish();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Splitpane.getItems().setAll(root);
           
        } else {
            setTheaterID(theater_id, theater_index);
        }
    }
    
    public void finish() {
        
        _dataService.transactionBegin();
        for (Pane pane : ticket) {
            for (List<Seats> seat : theater.getSeats()) {
                for (Seats seats : seat) {
                    if (pane.getId().equals(seats.getPosition())) {
                        seats.setIsBook(true);
                    }
                }
            }
        }
        _dataService.transactionCommit();
    }
    
    @FXML
    public void back(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Splitpane.getItems().setAll(root);
        
    }
    
    @FXML
    public void setTheaterID(int theater_id, int theater_index) {
        this.theater_id = theater_id;
        this.theater_index = theater_index;

        ticket_id = 0;
        
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:blue;");
        gridpane.setMinSize(229, 630);
        gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(228));
        scrollpane.setContent(gridpane);
        
        List<Button> temp = new ArrayList<Button>();
        this.theater = _dataService.getTheater(theater_id).get(theater_index);
        
        Label label = new Label(String.format("THEATER: %d\nMOVIE : %s\nTIME: %s\n", theater_id, theater.getMovie().getName(), theater.getTime()));
        label.setLayoutX(200);
        label.setLayoutY(20);
        theaterpane.getChildren().add(label);
        
        float positionx = 10;
        float positiony = 672;
        String styleH = "-fx-background-color:blue;-fx-text-fill:white;-fx-border-color:black";
        String styleD = "-fx-background-color:pink;-fx-text-fill:black;-fx-border-color:black";
        String styleN = "-fx-background-color:red;-fx-text-fill:white;-fx-border-color:black";
        String stylep = "-fx-background-color:#6fff43;-fx-text-fill:white;-fx-border-color:black";
        for (List<Seats> seat : theater.getSeats()) {
            for (Seats seats : seat) {
                temp.add(new Button(seats.getPosition()));
                if (seats.getIsBook() == true) {
                    temp.get(temp.size() - 1).setStyle("-fx-background-color:gray;-fx-text-fill:black;-fx-border-color:black");
                } else {
                    
                    if (seats.getName().equals("Normal Seat")) {
                        temp.get(temp.size() - 1).setStyle(styleN);
                    } else if (seats.getName().equals("Deluxe Seat")) {
                        temp.get(temp.size() - 1).setStyle(styleD);
                    } else {
                        temp.get(temp.size() - 1).setStyle(styleH);
                    }
                    temp.get(temp.size() - 1).setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            for (Button button : temp) {
                                if (button.getText().equals(seats.getPosition())) {
                                    if (button.getStyle().equals(stylep)) {
                                        if (seats.getName().equals("Normal Seat")) {
                                            button.setStyle(styleN);
                                        } else if (seats.getName().equals("Deluxe Seat")) {
                                            button.setStyle(styleD);
                                        } else {
                                            button.setStyle(styleH);
                                        }
                                        
                                        for (int i = 0; i < ticket.size(); i++) {
                                            if (ticket.get(i).getId().equals(seats.getPosition())) {
                                                ticket_id--;
                                                cost.setText("" + (Integer.parseInt(cost.getText()) - seats.getPrice() - theater.getScreen().getPrice()));
                                                gridpane.getChildren().remove(ticket.get(i));
                                                ticket.remove(i);
                                            }
                                        }
                                    } else {
                                        button.setStyle(stylep);
                                        cost.setText("" + (Integer.parseInt(cost.getText()) + seats.getPrice() + theater.getScreen().getPrice()));
                                        ticket.add(createPane(theater.getMovie().getName(), seats.getPosition(), seats.getPrice(), theater.getTime(), seats.getName()));
                                        gridpane.add(ticket.get(ticket.size() - 1), 0, ticket_id);
                                        ticket_id++;
                                    }
                                }
                                
                            }
                        }
                    }
                    );
                }
                temp.get(temp.size() - 1).setLayoutX(positionx);
                temp.get(temp.size() - 1).setLayoutY(positiony);
                temp.get(temp.size() - 1).setLayoutX(positionx);
                temp.get(temp.size() - 1).setLayoutY(positiony);
                if (seats.getName().equals("Deluxe Seat")) {
                    temp.get(temp.size() - 1).setMinSize(100, 30);
                    positionx += 150;
                } else {
                    temp.get(temp.size() - 1).setMinSize(51, 30);
                    positionx += 45;
                }
                
                theaterpane.getChildren().add(temp.get(temp.size() - 1));
                
            }
            
            if (seat.get(0).getName().equals("Deluxe Seat")) {
                positiony = 596;
            } else {
                positiony -= 30;
            }
            positionx = 10;
        }
    }

    void Menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
