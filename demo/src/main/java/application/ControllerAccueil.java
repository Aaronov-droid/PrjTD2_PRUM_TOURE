package application;

import dao.Persistance;
import fabrique.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAccueil {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static DAOFactory daoF;

    @FXML
    private Button btn_revues, btn_periodicites, btn_clients, btn_abonnements;

    @FXML
    private MenuItem choix_listeMemoire, choix_MySQL;

    @FXML
    private MenuButton menu_btn_persistance;

    @FXML
    protected void click_btn_revues(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("GestionRevues.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void click_btn_periodicites(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GestionPeriodicite.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void click_btn_clients(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GestionClient.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void click_btn_abonnements(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GestionAbonnement.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void click_btn_quittter(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void click_choix_MySQL() {
        daoF = DAOFactory.getDAOFactory(Persistance.MySQL);
        btn_abonnements.setDisable(false);
        btn_revues.setDisable(false);
        btn_periodicites.setDisable(false);
        btn_clients.setDisable(false);
    }

    @FXML
    protected void click_choix_listeMemoire() {
        daoF = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        btn_abonnements.setDisable(false);
        btn_revues.setDisable(false);
        btn_periodicites.setDisable(false);
        btn_clients.setDisable(false);

    }

}