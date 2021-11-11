public class ListeAbonnement implements Initializable {

    @FXML
    private TableView<Abonnement> TableAbonnement;
    @FXML
    private Button ButtonAjoutAbonnement, ButtonSuppAbonnement, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
        TableColumn<Abonnement, String> colClient = new TableColumn<>("Client");
        TableColumn<Abonnement, String> colRevue = new TableColumn<>("Revue");
        TableColumn<Abonnement, String> colDebut = new TableColumn<>("Date de début");
        TableColumn<Abonnement, String> colFin = new TableColumn<>("Date de fin");
        colClient.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Client"));
        colRevue.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Revue"));
        colDebut.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Debut"));
        colFin.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("Fin"));
        this.TableAbonnement.getColumns().setAll(colClient, colRevue, colDebut, colFin);
    }

    public void setData() //manipulation des données dans la table
    {
        this.ListeAbonnement.getItem().addAll(DAOFactory.getDAOFactory().getAbonnementDAO().findAll());
        this.ListeAbonnement.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.ButtonSuppAbonnement.setDisable(newValue == null);
            this.ButtonAjoutAbonnement.setDisable(newValue != null);
            if(newValue!=null)setValues();
        }
    }

    public void delete()
    {
        Abonnement selectedItem = TableAbonnement.getSelectionModel().getSelectedItem();
        mydao.getAbonnementDAO().delete(selectedItem);
        setData();
    }

}
