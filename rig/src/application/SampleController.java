package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
	ImageView likeButton;
	@FXML
	ImageView dislikeButton;
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
	ChoiceBox<String> colorPicker;
	@FXML
	CheckBox dislike;
	@FXML
	CheckBox like;
	@FXML 
	Label likeDislikePrompt;
	@FXML
	CheckBox showLiked;
	@FXML
	ChoiceBox<String> theoryPicker;
	@Override
	//Intializes the colorPicker and theoryPicker combo box and their values
	//colorPicker default value is set to black
	//theoryPicker default value is set to complimentary
	public void initialize(URL arg0, ResourceBundle arg1) {
		colorPicker.getItems().addAll("Black", "Blue", "Green", "Orange", "Purple", "Red", "White", "Yellow");
		colorPicker.setValue("Black");
		
		theoryPicker.getItems().addAll("Complimentary", "Primary", "Anagolous");
		theoryPicker.setValue("Complimentary");
	}

	public String getSelectedColor() {
		return colorPicker.getValue().toLowerCase();
	}
	
	public String getTheory() {
		return theoryPicker.getValue().toLowerCase();
	}

	// Sets the weather in the UI
	public void setWeather() throws IOException {
		weatherUI.setText(new WeatherChecker().getTemp());
		weatherUI.setVisible(true);
		weatherIcon.setVisible(true);
	}

	// Checks which box was checked and picks and outfit with that label. If not
	// Casual is defaulted if none are selected
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
	//finds matching colors based on the color theory selected and finds matching colors
	public String finalizeColorScheme() {
		String mainColor = getSelectedColor();
		String chosenTheory = getTheory();
		ColorTheory match = new ColorTheory();
		if(chosenTheory == "Anagolous")
			return match.analogous(mainColor);
		else if(chosenTheory == "Primary")
			return match.primarySecondary(mainColor);
		else
			return match.findMatchingColor(mainColor);
	}
	//creates the final array containing the outfit color scheme
	public String[] finalOutfitScheme() {
		String[] outfit = new String[4];
		outfit[0] = getSelectedColor();
		for (int i = 1; i < outfit.length; i++)
			outfit[i] = finalizeColorScheme();
		return outfit;
	}
	//Adds liked clothes into likeOutfits array list
	private String[] chosenOutfit;
	private ArrayList<String[]> likedOutfits = new ArrayList<>();
	public void like() {
		likeDislikePrompt.setText("Outfit liked!");
		likedOutfits.add(chosenOutfit);
	}
	
	//Adds disliked combinations into the dislikedOutfits array list
	private ArrayList<String[]> dislikedOutfits = new ArrayList<>();
	public void dislike() {
		likeDislikePrompt.setText("Outfit disliked!");
		dislikedOutfits.add(chosenOutfit);
		System.out.print("Disliked: " + Arrays.toString(chosenOutfit));
	}
	
	// Displays set of clothes based on if the user select formal, casual, lounge
	// whether it is hot or cold, selected color theory, and if they whether they want to see if their liked outfits
	public void showOutfit() throws NumberFormatException, IOException {		
		String temp = new WeatherChecker().hotOrCold();
		
		String[] colorScheme = finalOutfitScheme();
		chosenOutfit = colorScheme;
		
		//restricts color schemes to only the ones the user has liked 
		if(showLiked.isSelected())
			colorScheme = likedOutfits.get((int) (Math.random() * likedOutfits.size()));
		
		//If chosen color scheme is disliked skip until found color scheme that is not disliked
		while(dislikedOutfits.contains(colorScheme)) {
			colorScheme = finalOutfitScheme();
		}
	
		String shirtChosen = "shirt_" + colorScheme[0] + "_" + checkEvent() + "_" + temp + "_1.jpg";
		String apparelChosen = "apparel_" + colorScheme[1] + "_1.jpg";
		String pantsChosen = "pants_" + colorScheme[2] + "_" + checkEvent() + "_" + temp + "_1.jpg";
		String shoeChosen = "shoe_" + colorScheme[3] + "_" + checkEvent() + "_1.jpg";
		
		//Sets all images to their respective imageViews
		Image apparelImage = new Image("file:..\\..\\clothesImages\\Apparel\\" + apparelChosen);
		Image shirtImage = new Image("file:..\\..\\clothesImages\\Shirts\\" + shirtChosen);
		Image pantsImage = new Image("file:..\\..\\clothesImages\\Pants\\" + pantsChosen);
		Image shoeImage = new Image("file:..\\..\\clothesImages\\Shoes\\" + shoeChosen);

		pantsView.setImage(pantsImage);
		shirtView.setImage(shirtImage);
		shoeView.setImage(shoeImage);
		apparelView.setImage(apparelImage);
		
		likeButton.setVisible(true);
		dislikeButton.setVisible(true);
		likeDislikePrompt.setText("");
		showLiked.setVisible(true);
		
		System.out.println(Arrays.toString(colorScheme));

	}
}