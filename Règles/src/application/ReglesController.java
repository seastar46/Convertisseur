package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReglesController implements Initializable{

	@FXML
	private TableColumn<Regles, String> prenomColumn;

	@FXML
	private TextField txtPrenom;

	@FXML
	private TableColumn<Regles, String> cycleColumn;

	@FXML
	private Button btnClear;

	@FXML
	private TextField txtAge;

	@FXML
	private TableView<Regles> reglesTable;

	@FXML
	private Button btnEffacer;

	@FXML
	private TableColumn<Regles, Double> ageColumn;

	@FXML
	private Button btnModifier;

	@FXML
	private TableColumn<Regles, String> pmsColumn;

	@FXML
	private Button btnAjouter;

	@FXML
	private TextField txtPMS;

	@FXML
	private ComboBox<String> cboCycle;


	// liste pour les cycles - cette liste permettra de donner les valeurs du comboBox

	private ObservableList<String> list=(ObservableList<String>) FXCollections.observableArrayList("1 à 3 jours", "3 à 5 jours", "une semaine", "une semaine +");

	// Placer les femmes dans une observable list
	public ObservableList<Regles> reglesData=FXCollections.observableArrayList();

	// Créer une méthode pour accéder à la liste des femmes

	public ObservableList<Regles> getreglesdata()
	{
		return reglesData;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		cboCycle.setItems(list);
		//attribuer les valeurs aux colonnes du tableView
		prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		pmsColumn.setCellValueFactory(new PropertyValueFactory<>("pms"));
		cycleColumn.setCellValueFactory(new PropertyValueFactory<>("cycle"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		reglesTable.setItems(reglesData);

		showRegles(null);
		// Mettre à jour l'affichage d'une femme sélectionnée
			reglesTable.getSelectionModel().selectedItemProperty().addListener((
					observable, oldValue, newValue)-> showRegles(newValue));



			
	}

	// Ajouter une femme
	@FXML
	void ajouter()
	{
		Regles tmp=new Regles();
		tmp=new Regles();
		tmp.setPMS(txtPMS.getText());
		tmp.setPrenom(txtPrenom.getText());
		tmp.setAge(Double.parseDouble(txtAge.getText()));
		tmp.setCycle(cboCycle.getValue());
		reglesData.add(tmp);
		clearFields();

	}

	// Effacer le contenu des champs
	@FXML
	void clearFields()
	{
		cboCycle.setValue(null);
		txtPMS.setText("");
		txtPrenom.setText("");
		txtAge.setText("");
	}

	// Afficher les femmes
	@FXML
	void showRegles(Regles regles)
	{
		if(regles !=null)
		{
			cboCycle.setValue(regles.getCycle());
			txtPMS.setText(regles.getPMS());
			txtPrenom.setText(regles.getPrenom());
			txtAge.setText(Double.toString(regles.getAge()));
		}
		else
		{
			clearFields();

		}

	}
	
	
	
	
	
	
	
	
}

