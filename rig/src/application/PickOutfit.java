package application;

public class PickOutfit {
	
	//TODO try to migrate these methods to do this class
	//keep getting null pointer exceptions will try again later
	private SampleController controller;
	public String finalizeColorScheme() {
		String mainColor = controller.getSelectedColor();
		String chosenTheory = controller.getTheory();
		ColorTheory match = new ColorTheory();
		if(chosenTheory == "Anagolous")
			return match.analogous(mainColor);
		else if(chosenTheory == "Primary")
			return match.primarySecondary(mainColor);
		else
			return match.findMatchingColor(mainColor);
	}
	public String[] finalOutfitScheme() {
		String[] outfit = new String[4];
		outfit[0] = controller.getSelectedColor();
		for (int i = 1; i < outfit.length; i++)
			outfit[i] = finalizeColorScheme();
		return outfit;
	}
}
