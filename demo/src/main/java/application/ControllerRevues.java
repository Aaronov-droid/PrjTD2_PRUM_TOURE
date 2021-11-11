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
import metier.Abonnement;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;

public class ControllerRevues {

    @FXML
    private TableView<Revue> TableRevue;

    @FXML
    private Button btn_supp, btn_ajout, btn_suppr;

    private static DAOFactory dao = ControllerAccueil.daoF;

    public void initialize(){
        DAOFactory dao = ControllerAccueil.daoF;

        TableColumn<Revue, String> colTitre = new TableColumn<>("Titre");
        TableColumn<Revue, String> colReference = new TableColumn<>("Référence");
        TableColumn<Revue, String> colDescription = new TableColumn<>("Description");
        TableColumn<Revue, String> colPeriodicite = new TableColumn<>("Periodicite");
        TableColumn<Revue, String> colPrix = new TableColumn<>("Prix");
        colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("Titre"));
        colReference.setCellValueFactory(new PropertyValueFactory<Revue, String>("Référence"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Revue, String>("Description"));
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<Revue, String>("Periodicite"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Revue, String>("Prix"));
        this.TableRevue.getColumns().setAll(colTitre, colReference, colDescription, colPeriodicite,colPrix);

        this.TableRevue.getItems().addAll(dao.getRevueDAO().findAll());
        this.TableRevue.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.btn_supp.setDisable(newValue == null);
            this.btn_ajout.setDisable(newValue == null);
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
        Revue selectedItem = TableRevue.getSelectionModel().getSelectedItem();
        dao.getRevueDAO().delete(selectedItem);
    }
}
