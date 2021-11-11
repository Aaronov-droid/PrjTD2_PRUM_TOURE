public class ListeAbonnement implements Initializable {

    @FXML
    private TableView<ListeAbonnement> TableAbonnement;
    @FXML
    private Button ButtonAjoutAbonnement, ButtonSuppAbonnement, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
        TableColumn<TableAbonnement, String> colClient = new TableColumn<>("Client");
        TableColumn<TableAbonnement, String> colRevue = new TableColumn<>("Revue");
        TableColumn<TableAbonnement, String> colDebut = new TableColumn<>("Date de début");
        TableColumn<TableAbonnement, String> colFin = new TableColumn<>("Date de fin");
        colClient.setCellValueFactory(new PropertyValueFactory<TableAbonnement, String>("Client"));
        colRevue.setCellValueFactory(new PropertyValueFactory<TableAbonnement, String>("Revue"));
        colDebut.setCellValueFactory(new PropertyValueFactory<TableAbonnement, String>("Debut"));
        colFin.setCellValueFactory(new PropertyValueFactory<TableAbonnement, String>("Fin"));
        this.TableAbonnement.getColumns().setAll(colClient, colRevue, colDebut, colFin);
    }

    public void setData() //manipulation des données dans la table
    {
        this.ListeAbonnement.getItem().addAll(DAOFactory.getDAOFactory().getProduitDAO().findAll());
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