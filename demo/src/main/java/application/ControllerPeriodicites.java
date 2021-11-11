package application;

import fabrique.DAOFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metier.Client;
import metier.Periodicite;

import java.io.IOException;

public class ControllerPeriodicites {

    @FXML
    private TableView<Periodicite> TablePeriodicite;

    @FXML
    private Button btn_supp, btn_ajout, btn_suppr;

    private static DAOFactory dao = ControllerAccueil.daoF;


    public void initialize(){
        TableColumn<Periodicite, String> colLibelle = new TableColumn<>("Libellé");
        colLibelle.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("libelle"));
        this.TablePeriodicite.getColumns().setAll(colLibelle);

        this.TablePeriodicite.getItems().addAll(dao.getPeriodiciteDAO().findAll());
        this.TablePeriodicite.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            this.btn_supp.setDisable(newValue == null);
            this.btn_ajout.setDisable(newValue != null);
        });
    }

    @FXML
    protected void click_btn_gestion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterModifierRevue.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void click_btn_retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void click_btn_suppr(ActionEvent event) throws Exception {
        Periodicite selectedItem = TablePeriodicite.getSelectionModel().getSelectedItem();
        dao.getPeriodiciteDAO().delete(selectedItem);
    }

}
