public class ListeRevue implements Initializable {

    @FXML
    private TableView<ListeRevue> TableRevue;
    @FXML
    private Button ButtonAjoutRevue, ButtonSuppRevue, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
        TableColumn<TableRevue, String> colTitre = new TableColumn<>("Titre");
        TableColumn<TableRevue, String> colReference = new TableColumn<>("Référence");
        TableColumn<TableRevue, String> colDescription = new TableColumn<>("Description");
        TableColumn<TableRevue, String> colPeriodicite = new TableColumn<>("Periodicite");
        TableColumn<TableRevue, Int> colPrix = new TableColumn<"Prix">;
        colTitre.setCellValueFactory(new PropertyValueFactory<TableRevue, String>("Titre"));
        colReference.setCellValueFactory(new PropertyValueFactory<TableRevue, String>("Référence"));
        colDescription.setCellValueFactory(new PropertyValueFactory<TableRevue, String>("Description"));
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<TableRevue, String>("Periodicite"));
        colPrix.setCellValueFactory(new PropertyValueFactory<TableRevue, Int>("Prix"));
        this.TableRevue.getColumns().setAll(colTitre, colReference, colDescription, colPeriodicite,colPrix);
    }

    public void setData() //manipulation des données dans la table
    {
        this.ListeRevue.getItem().addAll(DAOFactory.getDAOFactory().getProduitDAO().findAll());
        this.ListeRevue.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.ButtonSuppRevue.setDisable(newValue == null);
            this.ButtonAjoutRevue.setDisable(newValue != null);
            if(newValue!=null)setValues();
        }
    }

    public void delete()
    {
        Revue selectedItem = TableRevue.getSelectionModel().getSelectedItem();
        mydao.getRevueDAO().delete(selectedItem);
        setData();
    }

}