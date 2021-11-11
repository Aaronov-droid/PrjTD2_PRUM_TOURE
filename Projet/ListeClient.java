public class ListeClient implements Initializable {

    @FXML
    private TableView<ListeClient> TableClient;
    @FXML
    private Button ButtonAjoutClient, ButtonSuppClient, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
    TableColumn<TableClient, String> colNuméro = new TableColumn<>("Numero");
    TableColumn<TableClient, String> colNom = new TableColumn<>("Nom");
    TableColumn<TableClient, String> colPrenom = new TableColumn<>("Prenom");
    TableColumn<TableClient, String> colAdresse = new TableColumn<>("Adresse Complète");
    colNuméro.setCellValueFactory(new PropertyValueFactory<TableClient, String>("Numero"));
    colNom.setCellValueFactory(new PropertyValueFactory<TableClient, String>("Nom"));
    colPrenom.setCellValueFactory(new PropertyValueFactory<TableClient, String>("Prenom"));
    colAdresse.setCellValueFactory(new PropertyValueFactory<TableClient, String>("Adresse"));
    this.TableClient.getColumns().setAll(colNuméro, colNom, colPrenom, colAdresse);
    }

    public void setData() //manipulation des données dans la table
    {
        this.ListeClient.getItem().addAll(DAOFactory.getDAOFactory().getProduitDAO().findAll());
        this.ListeClient.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.ButtonSuppClient.setDisable(newValue == null);
            this.ButtonAjoutClient.setDisable(newValue != null);
            if(newValue!=null)setValues();
        }
    }

    public void delete()
    {
        Client selectedItem = TableClient.getSelectionModel().getSelectedItem();
        mydao.getClientDAO().delete(selectedItem);
        setData();
    }

}