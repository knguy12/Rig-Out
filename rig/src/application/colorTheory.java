package application;

public class colorTheory {
	public static String selectedColor;

	// match complementary colors
		public static Boolean matchesComplementary(String complementaryColor) {
			if (selectedColor == complementaryColor)
				return true;
			return false;
		}

		// match primary colors
		public static Boolean matchesPrimary(String primaryColor) {
			if (selectedColor == primaryColor)
				return true;
			return false;
		}

		// match secondary colors
		public static Boolean matchesSecondary(String secondaryColor) {
			if (selectedColor == secondaryColor) {
				return true;
			}
			return false;
		}

		// match analogous colors
		public static Boolean matchesAnalogous(String analogousColor) {
			if (selectedColor == analogousColor) {
				return true;
			}
			return false;
		}

		// match intermediate colors
		public static Boolean matchesIntermediate(String intermediateColor) {
			if (selectedColor == intermediateColor) {
				return true;
			}
			return false;
		}
}
