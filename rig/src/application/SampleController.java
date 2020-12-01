package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController implements Initializable {

	@FXML
	Label weatherUI;
	@FXML
	ImageView pantsView;
	@FXML
	ImageView shirtView;
	@FXML
	ImageView shoeView;
	@FXML
	ImageView apparelView;
	@FXML
	ImageView weatherIcon;
	@FXML
	CheckBox formal;
	@FXML
	CheckBox casual;
	@FXML
	CheckBox complementary;
	@FXML
	CheckBox blue;
	@FXML
	CheckBox white;
	@FXML
	CheckBox black;
	@FXML
	CheckBox green;
	@FXML
	ChoiceBox<String> colorPicker;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colorPicker.getItems().addAll("Black", "Blue", "Green", "Orange", "Purple", "Red", "White", "Yellow");
	}
	public String getSelectedColor() {
		return colorPicker.getValue();
	}
	
	// Sets the weather in the UI
	public void setWeather() throws IOException {
		weatherUI.setText(new weatherChecker().getTemp());
		weatherUI.setVisible(true);
		weatherIcon.setVisible(true);
	}

	// Checks which box was checked and picks and outfit with that label. If not
	// casual is defaulted
	public String checkEvent() {
		String chosenEvent = "casual";
		if (formal.isSelected()) {
			return "formal";
		}
		if (casual.isSelected()) {
			return "casual";
		}
		return chosenEvent;
	}
	
	public String finalizeColorScheme(){
		String mainColor = colorPicker.getValue().toLowerCase();
		colorTheory match = new colorTheory();
		return match.findMatchingColor(mainColor);
	}
	public String[] finalOutfitScheme() {
		String[] outfit = new String[4];
		outfit[0] = colorPicker.getValue().toLowerCase();
		for(int i = 1; i < outfit.length; i++)
			outfit[i] = finalizeColorScheme();
		return outfit;
	}
	// Displays set of clothes based on if the user select formal, casual, lounge
	// and whether it is hot or cold
	// TODO Add in way to detect color and determine outfits based on that
	public void showOutfit() throws NumberFormatException, IOException {
		weatherChecker weather = new weatherChecker();
		String temp = weather.hotOrCold();
		String[] colorScheme = finalOutfitScheme();
		System.out.print(Arrays.toString(colorScheme));
		String shirtChosen = "shirt_" + colorScheme[0] + "_" + checkEvent() + "_" + temp +"_1.jpg";
		String apparelChosen = "apparel_" + colorScheme[1] + "_1.jpg";
		String pantsChosen = "pants_" + colorScheme[2] + "_" + checkEvent() +"_" + temp + "_1.jpg";
		String shoeChosen = "shoe_" + colorScheme[3] + "_" + checkEvent() +"_1.jpg";
		
		Image apparelImage = new Image("file:..\\..\\clothesImages\\Apparel\\" + apparelChosen);
		Image shirtImage = new Image("file:..\\..\\clothesImages\\Shirts\\" + shirtChosen);
		Image pantsImage = new Image("file:..\\..\\clothesImages\\Pants\\" + pantsChosen);
		Image shoeImage = new Image("file:..\\..\\clothesImages\\Shoes\\" + shoeChosen);
	
		pantsView.setImage(pantsImage);
		shirtView.setImage(shirtImage);
		shoeView.setImage(shoeImage);
		apparelView.setImage(apparelImage);
	
	}
}