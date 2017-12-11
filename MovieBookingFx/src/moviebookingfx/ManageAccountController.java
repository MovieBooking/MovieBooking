/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sivakorn
 */
public class ManageAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField dateofbirth;

    @FXML
    private TextField phonenumber;

    @FXML
    private ComboBox memberselector;

    @FXML
    private Button comfirmadd;

    @FXML
    private Button back;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField searchfield;

    @FXML
    private Button confirm;

    @FXML
    private Button search;

    DataService _dataService = new DataService();
    List<Account> account = new ArrayList<Account>();
    List<Pane> temppane = new ArrayList<Pane>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        memberselector.getItems().addAll("Normal Member", "Gold Member", "Patinum Member", "Diamon Member");

        update();
    }

    public void update() {
        int index = 0;
        memberselector.getSelectionModel().selectFirst();
        dateofbirth.setText("");
        email.setText("");
        firstname.setText("");
        lastname.setText("");
        phonenumber.setText("");
        GridPane gridpane = new GridPane();
        gridpane.setStyle("-fx-border-color:black;");
        gridpane.setMinSize(762, 588);
        //gridpane.setHgap(100);
        gridpane.getColumnConstraints().add(new ColumnConstraints(50));
        scrollpane.setContent(gridpane);
        account = _dataService.getAllAccount();

        temppane.add(createPane("E-MAIL", "PHONE NUMBER", "FIRSTNAME", "LASTNAME", "DATEOFBIRTH", "POINT", "MEMBER"));
        gridpane.add(temppane.get(temppane.size() - 1), 0, index++);
        for (Account account1 : account) {
            temppane.add(createPane(account1.getEmail(), account1.getPhonenumber(), account1.getFirstname(), account1.getLastname(), account1.getDateOfBirth(), String.valueOf(account1.getPoint()), account1.getMember()));
            gridpane.add(temppane.get(temppane.size() - 1), 0, index++);
        }

    }

    public Pane createPane(String email, String phonenumber, String firstname, String lastname, String dateOfBirth, String point, String member) {
        Pane pane = new Pane();
        pane.setMinSize(588,12);
        Label email_text = new Label(email);
        email_text.setStyle("-fx-border-color:black");
        email_text.setMinWidth(188);
        email_text.setMaxWidth(188);
        Label phone_text = new Label(phonenumber);
        phone_text.setStyle("-fx-border-color:black");
        phone_text.setMinWidth(100);
        phone_text.setMaxWidth(100);
        phone_text.setLayoutX(188);
        Label fname_text = new Label(firstname);
        fname_text.setStyle("-fx-border-color:black");
        fname_text.setMinWidth(100);
        fname_text.setMaxWidth(100);
        fname_text.setLayoutX(288);
        Label lname_text = new Label(lastname);
        lname_text.setStyle("-fx-border-color:black");
        lname_text.setMinWidth(100);
        lname_text.setMaxWidth(100);
        lname_text.setLayoutX(388);
        Label birth_text = new Label(dateOfBirth);
        birth_text.setStyle("-fx-border-color:black");
        birth_text.setMinWidth(100);
        birth_text.setMaxWidth(100);
        birth_text.setLayoutX(488);
        Label point_text = new Label(point);
        point_text.setStyle("-fx-border-color:black");
        point_text.setMinWidth(50);
        point_text.setMaxWidth(50);
        point_text.setLayoutX(588);
        Label member_text = new Label(member);
        member_text.setStyle("-fx-border-color:black");
        member_text.setMinWidth(150);
        member_text.setMaxWidth(150);
        member_text.setLayoutX(638);
        pane.getChildren().addAll(email_text, phone_text, fname_text, lname_text, birth_text, point_text, member_text);
        return pane;
    }

    public void addMember() {
        Account account = new Account(dateofbirth.getText(), email.getText(), firstname.getText(), lastname.getText(), phonenumber.getText());
        if(memberselector.getValue().equals("Normal Member"))
            account.setToNormalMember();
        else if(memberselector.getValue().equals("Gold Member"))
            account.setToGoldMember();
        else if(memberselector.getValue().equals("Patinum Member"))
            account.setToPatinumMember();
        else
            account.setToDiamonMember();
        _dataService.creatAccount(account);
        update();
    }
}
