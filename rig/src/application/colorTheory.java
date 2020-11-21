package application;

public class colorTheory {
	public static color selectedColor;

	// test
	// match complementary colors
	@SuppressWarnings("unlikely-arg-type")
	public static Boolean matchesComplementary() {
		if (selectedColor.equals("Red") && selectedColor.equals("Green"))
			return true;
		if (selectedColor.equals("Blue") && selectedColor.equals("Orange"))
			return true;
		if (selectedColor.equals("Yellow") && selectedColor.equals("Purple"))
			return true;
		return false;
	}

	// match primary colors
	@SuppressWarnings("unlikely-arg-type")
	public static Boolean matchesPrimary() {
		if (selectedColor.equals("Red") && selectedColor.equals("Blue") && selectedColor.equals("Yellow")) {
			return true;
		}
		return false;
	}

	// match secondary colors
	@SuppressWarnings("unlikely-arg-type")
	public static Boolean matchesSecondary() {
		if (selectedColor.equals("Orange") && selectedColor.equals("Purple") && selectedColor.equals("Orange")) {
			return true;
		}
		return false;
	}

	// Not sure if we should keep these two or not, might over complicate things
	// given they're in between colors
	// match analogous colors
	@SuppressWarnings("unlikely-arg-type")
	public static Boolean matchesAnalogous() {
		if (selectedColor.equals("Red") || selectedColor.equals("Red-Violet") || selectedColor.equals("Violet")
				|| selectedColor.equals("Blue-Violet")) {
			return true;
		}
		return false;
	}

	// match intermediate colors
	public static Boolean matchesIntermediate(color intermediateColor) {
		if (selectedColor == intermediateColor) {
			return true;
		}
		return false;
	}
}
