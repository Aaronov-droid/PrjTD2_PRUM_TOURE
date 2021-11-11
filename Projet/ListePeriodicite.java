public class ListePeriodicite implements Initializable {

    @FXML
    private TableView<ListePeriodicite> TablePeriodicite;
    @FXML
    private Button ButtonAjoutPeriodicite, ButtonSuppPeriodicite, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
        TableColumn<TablePeriodicite, String> colPeriodicite = new TableColumn<>("Periodicite");
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<TablePeriodicite, String>("Periodicite"));
        this.TablePeriodicite.getColumns().setAll(colPeriodicite);
    }

    public void setData() //manipulation des données dans la table
    {
        this.ListePeriodicite.getItem().addAll(DAOFactory.getDAOFactory().getProduitDAO().findAll());
        this.ListePeriodicite.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.ButtonSuppPeriodicite.setDisable(newValue == null);
            this.ButtonAjoutPeriodicite.setDisable(newValue != null);
            if(newValue!=null)setValues();
        }
    }

    public void delete()
    {
        Periodicite selectedItem = TablePeriodicite.getSelectionModel().getSelectedItem();
        mydao.getPeriodiciteDAO().delete(selectedItem);
        setData();
    }

}