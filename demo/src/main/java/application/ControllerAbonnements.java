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

import java.io.IOException;

public class ControllerAbonnements {

    @FXML
    private TableView<Abonnement> TableAbonnement;

    @FXML
    private Button btn_supp, btn_ajout, btn_suppr;

    private static DAOFactory dao = ControllerAccueil.daoF;

    public void initialize(){
        TableColumn<Abonnement, String> colClient = new TableColumn<>("Client");
        TableColumn<Abonnement, String> colRevue = new TableColumn<>("Revue");
        TableColumn<Abonnement, String> colDebut = new TableColumn<>("Date de début");
        TableColumn<Abonnement, String> colFin = new TableColumn<>("Date de fin");
        colClient.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Client"));
        colRevue.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Revue"));
        colDebut.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Debut"));
        colFin.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Fin"));
        this.TableAbonnement.getColumns().setAll(colClient, colRevue, colDebut, colFin);

        this.TableAbonnement.getItems().addAll(dao.getAbonnementDAO().findAll());
        this.TableAbonnement.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            this.btn_supp.setDisable(newValue == null);
            this.btn_ajout.setDisable(newValue != null);
        });
    }

    @FXML
    protected void click_btn_gestion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterModifierAbonnement.fxml"));
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
        Abonnement selectedItem = TableAbonnement.getSelectionModel().getSelectedItem();
        dao.getAbonnementDAO().delete(selectedItem);
    }

}
