package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{

	@FXML
    private TextField txt2L;

    @FXML
    private TextField txt1L;

    @FXML
    private TextField txt1T;

    @FXML
    private TextField txt2T;

    @FXML
    private ComboBox<String> cbo1M;

    @FXML
    private ComboBox<String> cbo2M;

    @FXML
    private ComboBox<String> cbo1T;

    @FXML
    private ComboBox<String> cbo2T;

    @FXML
    private ComboBox<String> cbo1L;

    @FXML
    private ComboBox<String> cbo2L;

    @FXML
    private TextField txt2M;

    @FXML
    private TextField txt1M;
    
    //Toutes les identités des ComboBox et les TextField

    
    @FXML
    private ObservableList<String> listLong = FXCollections.observableArrayList("Mètre(s)","Pied(s)","Centimètre(s)","Kilomètre(s)","Millimètre(s)","Pouce(s)");
    //Ceci sont les unités que j'ai choisi pour le convertisseur de longueure
    private double[] longueur = {1,3.28084,100,0.001,1000,39.3701};
    //Ceci sont les valeurs des unités tous comparés à 1 mètre. Donc 1 mètre est 3,28084 pieds, puis 1 mètre est équivalent à 100 centimètres etc...

    
    @FXML
    private ObservableList<String> listTime = FXCollections.observableArrayList("Secondes","Minutes","Milliseconde","Heure","Jour","Microseconde");
    //Ceci sont les unités que j'ai choisi pour le convertisseur du temps
    private double[] time = {1,0.0166666667,1000,0.000277778,0.000011574,1000000};
    //Ceci sont les valeurs des unités tous comparés à 1 seconde. Donc une seconde est 0,0166666667 minute, puis une seconde est équivalent à 1000 millisecondes etc...
    
    @FXML
    private ObservableList<String> listMonnaie = FXCollections.observableArrayList("CAD","USD","AUD","EUR","GBP","MEX");
    //Ceci sont les unités que j'ai choisi pour le convertisseur d'argent ou monnaie
    private double[] monnaie = {1,0.78,1.06,0.71,0.60,16.40};
    //Ceci sont les valeurs des unités tous comparés à 1 CAD (dollars canadian). Donc 1$ est 0,78 dollar américain , puis 1$ est équivalent à 1,06 dollar australien etc...
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	cbo1L.setItems(listLong); 
    	cbo2L.setItems(listLong);
   		cbo1L.getSelectionModel().selectFirst();
   		cbo2L.getSelectionModel().selectFirst();
   		//Ceci va montrer la liste des unités pour selectionner ce que l'usager veut convertir (cbo1L et cbo2L sont les indentités des ComboBox pour la longueure)
   		
   		cbo1T.setItems(listTime);
    	cbo2T.setItems(listTime);
   		cbo1T.getSelectionModel().selectFirst();
   		cbo2T.getSelectionModel().selectFirst();
   		//Ceci va montrer la liste des unités pour selectionner ce que l'usager veut convertir (cbo1T et cbo2T sont les indentités des ComboBox pour le temps)

   		
   		cbo1M.setItems(listMonnaie);
    	cbo2M.setItems(listMonnaie);
   		cbo1M.getSelectionModel().selectFirst();
   		cbo2M.getSelectionModel().selectFirst();
   		//Ceci va montrer la liste des unités pour selectionner ce que l'usager veut convertir (cbo1M et cbo2M sont les indentités des ComboBox pour la monnaie)

    }
    private double setTaux(ComboBox a, double tbl[])
    {
    	return tbl[a.getSelectionModel().getSelectedIndex()];
    }
    @FXML
    private void convert1L()
    {
    	convertir(cbo1L,cbo2L,txt1L,txt2L,longueur);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    }
    @FXML
    private void convert2L()
    {
    	convertir(cbo2L,cbo1L,txt2L,txt1L,longueur);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    	
    }
    @FXML
    private void convert1T()
    {
    	convertir(cbo1T,cbo2T,txt1T,txt2T,time);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    }
    @FXML
    private void convert2T()
    {
    	convertir(cbo2T,cbo1T,txt2T,txt1T,time);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    	
    }
    @FXML
    private void convert1M()
    {
    	convertir(cbo1M,cbo2M,txt1M,txt2M,monnaie);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    }
    @FXML
    private void convert2M()
    {
    	convertir(cbo2M,cbo1M,txt2M,txt1M,monnaie);
    	//Ceci va convertir les valeurs des unités tous les deux choisi par l'usager
    	
    }
    private void convertir(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
    {
    	double from = setTaux(a,tbl);
    	double to = setTaux(b,tbl);
    	double depart = 0.0;
    	depart=c.getText().isEmpty()?0.0:Double.parseDouble(c.getText());
    	double dest=(to/from)*depart;
    	d.setText(String.valueOf(dest));
    	//Ceci va mettre en route le calcule pour que le convertisseur marche et converti la valeur mise par l'usager
    }
    @FXML
    private void verifNum(KeyEvent e) 
    {
    TextField txt=(TextField)e.getSource();
    txt.textProperty().addListener((observable,oldValue,newValue)->
    {
    if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
	{
    	txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
	}

    });
    }
}
