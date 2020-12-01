package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
	@FXML
	CheckBox dislike;
	@FXML
	CheckBox like;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colorPicker.getItems().addAll("Black", "Blue", "Green", "Orange", "Purple", "Red", "White", "Yellow");
		colorPicker.setValue("Black");
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

	public String finalizeColorScheme() {
		String mainColor = colorPicker.getValue().toLowerCase();
		colorTheory match = new colorTheory();
		return match.findMatchingColor(mainColor);
	}

	public String[] finalOutfitScheme() {
		String[] outfit = new String[4];
		outfit[0] = colorPicker.getValue().toLowerCase();
		for (int i = 1; i < outfit.length; i++)
			outfit[i] = finalizeColorScheme();
		return outfit;
	}

	// returns the results of the liked outfits
	// this will choose a random outfit based on the liked outfits of the user
	// when were creating the outfits, we're not only using finalOutfitScheme we can
	// also use likedOutfitScheme
	public String[] likedOutfitScheme(ArrayList<String> favoritesList) {
		{
			Random r = new Random();
			int spot = r.nextInt((favoritesList.size() - 0) + 1) + 0;
			String line = favoritesList.get(spot);
			String[] outfit = line.split(" ");
			Pattern pattern = Pattern.compile(" ");
			return outfit = pattern.split(line);
		}
	}

	// this method removes disliked outfits from an Array List of all outfits
	// adds liked outfits to a favored Array List of outfits
	// we need to add checkboxes for liking and disliking the outfits
	// for the dislike outfits, it doesn't guarantee it doesn't show up in the
	// randomizer anymore
	public void likeDislike() {
		ArrayList<String> outfitList = new ArrayList<String>();
		ArrayList<String> favoredList = new ArrayList<String>();
		outfitList.add(finalOutfitScheme().toString());
		if (dislike.isSelected()) {
			outfitList.remove(finalOutfitScheme().toString());
		} else if (like.isSelected()) {
			favoredList.add(finalOutfitScheme().toString());
		}

	}

	// Displays set of clothes based on if the user select formal, casual, lounge
	// and whether it is hot or cold
	// TODO Add in way to detect color and determine outfits based on that
	public void showOutfit() throws NumberFormatException, IOException {
		weatherChecker weather = new weatherChecker();
		String temp = weather.hotOrCold();
		String[] colorScheme = finalOutfitScheme();
		System.out.print(Arrays.toString(colorScheme));
		String shirtChosen = "shirt_" + colorScheme[0] + "_" + checkEvent() + "_" + temp + "_1.jpg";
		String apparelChosen = "apparel_" + colorScheme[1] + "_1.jpg";
		String pantsChosen = "pants_" + colorScheme[2] + "_" + checkEvent() + "_" + temp + "_1.jpg";
		String shoeChosen = "shoe_" + colorScheme[3] + "_" + checkEvent() + "_1.jpg";

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