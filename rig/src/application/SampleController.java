package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SampleController {

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
	CheckBox lounge;
	@FXML
	CheckBox complementary;
	@FXML
	CheckBox blue;
	@FXML
	CheckBox white;
	@FXML
	CheckBox black;

	// Sets the weather in the UI
	public void setWeather() throws IOException {
		weatherUI.setText(new weatherChecker().getTemp());
		weatherUI.setVisible(true);
		weatherIcon.setVisible(true);
	}

	// Checks if the weather is currently hot or cold
	public String hotOrCold() throws NumberFormatException, IOException {
		weatherChecker weather = new weatherChecker();
		if (Double.parseDouble(weather.getTemp()) < 70.0)
			return "cold";
		return "hot";
	}

	// Checks which box was checked and picks and outfit with that label. If not
	// casual is defaulted
	public String checkEvent() {
		String chosenEvent = "casual";
		if (formal.isSelected()) {
			chosenEvent = "formal";
		}
		if (casual.isSelected()) {
			chosenEvent = "casual";
		}
		if (lounge.isSelected()) {
			chosenEvent = "lounge";
		}
		return chosenEvent;
	}

	//
	public String selectColors() {
		String secondaryColor = "red";
		if (complementary.isSelected()) {
			if (black.isSelected())
				secondaryColor = "white";
			if (white.isSelected())
				secondaryColor = "black";
			if (black.isSelected())
				secondaryColor = "white";
		}
		return secondaryColor;
	}

	// Displays set of clothes based on if the user select formal, casual, lounge
	// and whether it is hot or cold
	// TODO Add in way to detect color and determine outfits based on that
	public void showOutfit() throws NumberFormatException, IOException {
		// white outfits
		Image pantsImageWhite = new Image(
				"file:..\\..\\clothesImages\\Pants\\pants_white_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shirtImageWhite = new Image(
				"file:..\\..\\clothesImages\\Shirts\\shirt_white_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shoeImageWhite = new Image("file:..\\..\\clothesImages\\Shoes\\shoe_white_" + checkEvent() + "_1.jpg");
		Image apparelImageWhite = new Image("file:..\\..\\clothesImages\\Apparel\\apparel_white_1.jpg");
		// blue outfits
		Image pantsImageBlue = new Image(
				"file:..\\..\\clothesImages\\Pants\\pants_blue_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shirtImageBlue = new Image(
				"file:..\\..\\clothesImages\\Shirts\\shirt_blue_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shoeImageBlue = new Image("file:..\\..\\clothesImages\\Shoes\\shoe_blue_" + checkEvent() + "_1.jpg");
		Image apparelImageBlue = new Image("file:..\\..\\clothesImages\\Apparel\\apparel_blue_1.jpg");
		// black outfits
		Image pantsImageBlack = new Image(
				"file:..\\..\\clothesImages\\Pants\\pants_black_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shirtImageBlack = new Image(
				"file:..\\..\\clothesImages\\Shirts\\shirt_black_" + checkEvent() + "_" + hotOrCold() + "_1.jpg");
		Image shoeImageBlack = new Image("file:..\\..\\clothesImages\\Shoes\\shoe_black_" + checkEvent() + "_1.jpg");
		Image apparelImageBlack = new Image("file:..\\..\\clothesImages\\Apparel\\apparel_black_1.jpg");

		// SETTING IMAGES
		// white outfits
		pantsView.setImage(pantsImageWhite);
		shirtView.setImage(shirtImageWhite);
		shoeView.setImage(shoeImageWhite);
		apparelView.setImage(apparelImageWhite);
		// blue outfits
		pantsView.setImage(pantsImageBlue);
		shirtView.setImage(shirtImageBlue);
		shoeView.setImage(shoeImageBlue);
		apparelView.setImage(apparelImageBlue);
		// black outfits
		pantsView.setImage(pantsImageBlack);
		shirtView.setImage(shirtImageBlack);
		shoeView.setImage(shoeImageBlack);
		apparelView.setImage(apparelImageBlack);

	}
}