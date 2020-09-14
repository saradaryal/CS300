/**
 * Allows for all buttons that create furniture to run from one class. 
 * @author Thomas Grutsch and Robert Fitzpatrick
 *
 */
public class CreateFurnitureButton extends Button {
	
	public CreateFurnitureButton(String type, float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = "Create " + type;
	}
	/**
	 * adds furniture corresponding to the button pressed.
	 */
	@Override
	public void mouseDown(Furniture[] furniture) { 
		
		if (isMouseOver()) {
			for (int k = 0; k < furniture.length; k++) {
				if (furniture[k] == null) {
					furniture[k] = new Furniture
							(label.toLowerCase().substring(7).trim(), 
									processing);
					break; 
				}
			}
		} 
		
	}
	
}
