/**
 * Clears furniture from the room when pressed. 
 * @author Thomas Grutsch and Robert Fitzpatrick
 *
 */
public class ClearButton extends Button {

	public ClearButton(float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = "Clear Room";
	}
	/**
	 * Clears furniture from room.
	 */
	@Override
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {
			for (int i = 0; i < furniture.length; i++) {
				furniture[i] = null;
			}
		}
	}
	
}
