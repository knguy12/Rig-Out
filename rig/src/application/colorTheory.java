package application;

import java.io.IOException;

public class colorTheory {
	
	private String[] color = {"black", "blue", "green", "orange", "purple", "red", "white", "yellow"};
	private String[] compBlue = {"red", "yellow", "white", "black", "purple"};
	private String[] compGreen = {"orange", "white", "black"};
	private String[] compOrange = {"green", "blue", "white", "black"};
	private String[] compPurple = {"orange", "white", "green", "black", "blue"};
	private String[] compRed = {"blue", "white", "black"};
	private String[] compYellow = {"green", "blue", "white", "black"};
	
	public String findMatchingColor(String chosenColor) {
		if(chosenColor.equals("blue"))
			return compBlue[(int)(Math.random() * compBlue.length)];
		else if(chosenColor.equals("green"))
			return compGreen[(int)(Math.random() * compGreen.length)];
		else if(chosenColor.equals("orange"))
			return compOrange[(int)(Math.random() * compOrange.length)];
		else if(chosenColor.equals("purple"))
			return compPurple[(int)(Math.random() * compPurple.length)];
		else if(chosenColor.equals("red"))
			return compRed[(int)(Math.random() * compRed.length)];
		else if(chosenColor.equals("yellow"))
			return compYellow[(int)(Math.random() * compYellow.length)];
		else if(chosenColor.equals("black") || chosenColor.equals("white"))
			return color[(int)(Math.random() * color.length)];
		return "Could not Find Color";
	}
	public static void main(String[] args) {
		colorTheory color = new colorTheory();
		System.out.print(color.findMatchingColor("black"));
	}
}
