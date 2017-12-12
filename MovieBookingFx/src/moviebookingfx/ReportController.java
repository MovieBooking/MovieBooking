/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebookingfx;

import Class.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author terkg
 */
public class ReportController implements Initializable {

    @FXML
    private VBox vbox;
    
    @FXML
    private AnchorPane backpane;

    private TableView<Report> table = new TableView<Report>();
    private ObservableList<Report> data;
    private DataService _dataService = new DataService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Report> report = _dataService.getAllReport();
        System.out.println(report);
        data = FXCollections.observableArrayList(report);

        
        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(45);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("id"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("account"));

        TableColumn theaterCol = new TableColumn("Theater");
        theaterCol.setMinWidth(100);
        theaterCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("theater"));

        TableColumn promotionCol = new TableColumn("PROMOTION");
        promotionCol.setMinWidth(200);
        promotionCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("promotion"));
        
        TableColumn reportCOl = new TableColumn("DETAIL");
        reportCOl.setMinWidth(300);
        reportCOl.setCellValueFactory(
                new PropertyValueFactory<Report, String>("report"));
        
          
        TableColumn timeCol = new TableColumn("TIME");
        timeCol.setMinWidth(200);
        timeCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("time"));
        
        TableColumn costCol = new TableColumn("TOTAL");
        costCol.setMinWidth(100);
        costCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("cost"));

        table.setItems(data);
        table.getColumns().addAll(idCol,emailCol, theaterCol, promotionCol,reportCOl,timeCol,costCol);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( table);

    }
         @FXML
        public void back() throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        MenuController controller = fxmlLoader.<MenuController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);   
    } 
  
}
