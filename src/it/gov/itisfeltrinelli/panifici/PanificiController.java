/**
 * Sample Skeleton for 'Panifici.fxml' Controller Class
 */

package it.gov.itisfeltrinelli.panifici;

import java.net.URL;
import java.util.ResourceBundle;

import it.gov.itisfeltrinelli.panifici.model.DAO_Panifici;
import it.gov.itisfeltrinelli.panifici.model.ModelPanifici;
import it.gov.itisfeltrinelli.panifici.model.Panificio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PanificiController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="cbProvincie"
	private ComboBox<String> cbProvincie; // Value injected by FXMLLoader

	@FXML // fx:id="cbCitt�"
	private ComboBox<String> cbCitt�; // Value injected by FXMLLoader

	@FXML // fx:id="btnCerca"
	private Button btnCerca; // Value injected by FXMLLoader

	@FXML // fx:id="tabella"
	private TableView<Panificio> tabella; // Value injected by FXMLLoader

	@FXML // fx:id="colRegione"
	private TableColumn<Panificio, String> colRegione; // Value injected by FXMLLoader

	@FXML // fx:id="colProvincia"
	private TableColumn<Panificio, String> colProvincia; // Value injected by FXMLLoader

	@FXML // fx:id="colCitta"
	private TableColumn<Panificio, String> colCitta; // Value injected by FXMLLoader

	@FXML // fx:id="colPanificio"
	private TableColumn<Panificio, String> colPanificio; // Value injected by FXMLLoader

	private ObservableList<String> combobox;

	@FXML
	void onCerca(ActionEvent event) {
		if(cbProvincie.getSelectionModel().getSelectedItem() != null) {
			if(cbProvincie.getSelectionModel().getSelectedItem().equals("tutte")) {
				if(cbCitt�.getSelectionModel().getSelectedItem() != null) {
					if(cbCitt�.getSelectionModel().getSelectedItem().equals("tutte")) {
						tabella.setItems(FXCollections.observableList(model.getALLPanifici()));
					}else {
						tabella.setItems(FXCollections.observableList(model.getPanificiPerCitt�(cbCitt�.getSelectionModel().getSelectedItem())));
					}
				}
			}else {
				if(cbCitt�.getSelectionModel().getSelectedItem() != null) {
					if(cbCitt�.getSelectionModel().getSelectedItem().equals("tutte")) {
						tabella.setItems(FXCollections.observableList(model.getPanificiPerProvincia(cbProvincie.getSelectionModel().getSelectedItem())));
					}else {
						tabella.setItems(FXCollections.observableList(model.getPanificiPerProvinciaECitt�(cbProvincie.getSelectionModel().getSelectedItem(), cbCitt�.getSelectionModel().getSelectedItem())));
					}
				}
			}
		}
	}

	private ModelPanifici model;

	public void setDatabase(DAO_Panifici database) {
		model.setDatabase(database);
		cbProvincie.setItems(FXCollections.observableList(model.getProvincie()));
		cbCitt�.setItems(FXCollections.observableList(model.getCitta()));
		tabella.setItems(FXCollections.observableList(model.getALLPanifici()));
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert cbProvincie != null : "fx:id=\"cbProvincie\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert cbCitt� != null : "fx:id=\"cbCitt�\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert colRegione != null : "fx:id=\"colRegione\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert colProvincia != null : "fx:id=\"colProvincia\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert colCitta != null : "fx:id=\"colCitta\" was not injected: check your FXML file 'Panifici.fxml'.";
		assert colPanificio != null : "fx:id=\"colPanificio\" was not injected: check your FXML file 'Panifici.fxml'.";
		
		model = new ModelPanifici();

		colRegione.setCellValueFactory(new PropertyValueFactory<Panificio, String>("regione"));
		colProvincia.setCellValueFactory(new PropertyValueFactory<Panificio, String>("provincia"));
		colCitta.setCellValueFactory(new PropertyValueFactory<Panificio, String>("citta"));
		colPanificio.setCellValueFactory(new PropertyValueFactory<Panificio, String>("panetteria"));
		cbProvincie.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				cbCitt�.getSelectionModel().select(0);
				if (newValue.equals("tutte")) {
					combobox = FXCollections.observableList(model.getCitta());
					cbCitt�.setItems(combobox);
				} else {
					combobox = FXCollections.observableList(model.getCitta(newValue));
					cbCitt�.setItems(combobox);
				}
			}
		});

		cbCitt�.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue!=null)
					if (!newValue.equals("tutte")) {
						String value = model.getProvincia(newValue).get(0);
						cbProvincie.getSelectionModel().select(value);
					}
			}
		});
	}
}