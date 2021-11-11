public class ListePeriodicite implements Initializable {

    @FXML
    private TableView<Periodicite> TablePeriodicite;
    @FXML
    private Button btn_supp_periodicite, btn_ajout_periodicite, ButtonAcceuil;

    public void setColumns() //Création des colonnes
    {
        TableColumn<Periodicite, String> colPeriodicite = new TableColumn<>("Periodicite");
        colPeriodicite.setCellValueFactory(new PropertyValueFactory<Periodicite, String>("Periodicite"));
        this.TablePeriodicite.getColumns().setAll(colPeriodicite);
    }

    public void setData() //manipulation des données dans la table
    {
        this.TablePeriodicite.getItem().addAll(dao.getPeriodiciteDAO().findAll());
        this.TablePeriodicite.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue) ->
        {
            this.btn_supp_periodicite.setDisable(newValue == null);
            this.btn_ajout_periodicite.setDisable(newValue != null);
            //if(newValue!=null)setValues();
        }
    }

    public void delete()
    {
        Periodicite selectedItem = TablePeriodicite.getSelectionModel().getSelectedItem();
        mydao.getPeriodiciteDAO().delete(selectedItem);
        setData();
    }

}
