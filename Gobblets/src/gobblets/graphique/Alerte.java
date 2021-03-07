package gobblets.graphique;

import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerte {

	public static void warning(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(IHM.avertissement(Avertissement.AVERTISSEMENT));
		alert.setHeaderText(IHM.avertissement(Avertissement.AVERTISSEMENT));
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public static void inform(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
