public class ListeClient implements Initializable {

    @FXML
    private TableView<Client> TableClient;
    @FXML
    private Button btn_supp_client, btn_ajout_client, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
    TableColumn<Client, String> colNuméro = new TableColumn<>("Numero");
    TableColumn<Client, String> colNom = new TableColumn<>("Nom");
    TableColumn<Client, String> colPrenom = new TableColumn<>("Prenom");
    TableColumn<Client, String> colAdresse = new TableColumn<>("Adresse Complète");
    colNuméro.setCellValueFactory(new PropertyValueFactory<Client, String>("Numero"));
    colNom.setCellValueFactory(new PropertyValueFactory<Client, String>("Nom"));
    colPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("Prenom"));
    colAdresse.setCellValueFactory(new PropertyValueFactory<Client, String>("Adresse"));
    this.TableClient.getColumns().setAll(colNuméro, colNom, colPrenom, colAdresse);
    }

    public void setData() //manipulation des données dans la table
    {
        this.TableClient.getItem().addAll(dao.getClientDAO().findAll());
        this.TableClient.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.btn_supp_client.setDisable(newValue == null);
            this.btn_ajout_client.setDisable(newValue != null);
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
