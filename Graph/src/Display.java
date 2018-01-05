

public class Display{
	private static Display displayObject;

	private static enum inputOutputTypes {
		file, stdIO
	};

	public Display() {
		displayObject = null;
	}

	public static Display getDisplayObject(inputOutputTypes aDisplayType) {
		if (displayObject == null) {
			displayObject = new Display();
		}
		return displayObject;
	}

}
