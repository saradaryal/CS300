
public class CleanerButton extends Button {

	public CleanerButton(float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = "Create Cleaner";
	}
	
	/**
	 * makes a cleaner bot.
	 */
	@Override
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {

			for (int k = 0; k < furniture.length; k++) {
				if (furniture[k] == null) {
					furniture[k] = new Furniture(label.toLowerCase().substring(7).trim(), 
							processing);
					break;
				}
			}

		}
	}

}
