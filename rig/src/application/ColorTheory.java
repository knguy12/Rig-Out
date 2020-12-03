package application;

public class ColorTheory {
	
	//Lists all colors available and their matching complimentary color
	private String[] color = { "black", "blue", "green", "orange", "purple", "red", "white", "yellow" };
	private String[] compBlue = { "red", "yellow", "white", "black", "purple" };
	private String[] compGreen = { "orange", "white", "black" };
	private String[] compOrange = { "green", "blue", "white", "black" };
	private String[] compPurple = { "orange", "white", "green", "black", "blue" };
	private String[] compRed = { "blue", "white", "black" };
	private String[] compYellow = { "green", "blue", "white", "black" };

	//Lists all colors and their respective primary and secondary color
	private String[] primary = { "red", "yellow", "blue" };
	private String[] secondary = { "green", "orange", "purple" };
	private String[] monochrome = { "black", "white" };
	
	//Lists all matching analogous colors
	private String[] analogousR = { "red", "yellow", "orange" };
	private String[] analogousB = { "blue", "purple", "green" };

	public String findMatchingColor(String chosenColor) {
		if (chosenColor.equals("blue"))
			return compBlue[(int) (Math.random() * compBlue.length)];
		else if (chosenColor.equals("green"))
			return compGreen[(int) (Math.random() * compGreen.length)];
		else if (chosenColor.equals("orange"))
			return compOrange[(int) (Math.random() * compOrange.length)];
		else if (chosenColor.equals("purple"))
			return compPurple[(int) (Math.random() * compPurple.length)];
		else if (chosenColor.equals("red"))
			return compRed[(int) (Math.random() * compRed.length)];
		else if (chosenColor.equals("yellow"))
			return compYellow[(int) (Math.random() * compYellow.length)];
		else if (chosenColor.equals("black") || chosenColor.equals("white"))
			return color[(int) (Math.random() * color.length)];
		return "Could not Find Color";
	}

	public String primarySecondary(String chosenColor) {
		if (chosenColor.equals("red") || chosenColor.equals("blue") || chosenColor.equals("yellow")) {
			return primary[(int) (Math.random() * primary.length)];
		} else if (chosenColor.equals("green") || chosenColor.equals("purple") || chosenColor.equals("orange")) {
			return secondary[(int) (Math.random() * secondary.length)];
		} else if (chosenColor.equals("black") || chosenColor.equals("white"))
			return monochrome[(int) (Math.random() * monochrome.length)];
		return "Could not Find Color";
	}

	public String analogous(String chosenColor) {
		if(chosenColor.equals("red") || chosenColor.equals("orange") || chosenColor.equals("yellow"))
			return analogousR[(int)(Math.random() * analogousR.length)];
		else if(chosenColor.equals("blue") || chosenColor.equals("purple") || chosenColor.equals("green"))
				return analogousB[(int)Math.random() * analogousB.length];
		else if(chosenColor.equals("black") || chosenColor.equals("white"))
			return monochrome[(int) (Math.random() * monochrome.length)];
		return "Could not Find Color";
	}

	public static void main(String[] args) {
		ColorTheory color = new ColorTheory();
	}
}
