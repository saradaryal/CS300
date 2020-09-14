/**
 * This class allows button base classes to only have one method, mouseDown. This 
 * is for simplification purposes. 
 * @author Thomas Grutsch and Robert Fitzpatrick
 *
 */
public class Button implements DormGUI {

	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	protected PApplet processing;
	private float[] position;
	protected String label;
	/**
	 * Constructor for all buttons
	 * @param x
	 * @param y
	 * @param processing
	 */
	public Button(float x, float y, PApplet processing) {

		this.position = new float[] { x, y };
		this.processing = processing;
		this.label = "Button";
	}
	/**
	 * Updates all buttons
	 */
	public void update() {
		if (isMouseOver()) {
			this.processing.fill(100);
		} else {
			this.processing.fill(200);
		}

		this.processing.rect(48 + this.position[0], 16 + this.position[1], this.position[0] - 46,
				this.position[1] - 16);

		this.processing.fill(0);
		this.processing.text(this.label, this.position[0], this.position[1]);

	}
	/**
	 * default mouseDown
	 */
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {
			System.out.println("A button was pressed.");
		}

	}
	//does nothing. is here 
	public void mouseUp() {
	}
	/**
	 * Checks if mouse is over button
	 */
	public boolean isMouseOver() {
		if (this.processing.mouseX >= (this.position[0] - WIDTH / 2)
				&& this.processing.mouseX <= (this.position[0] + WIDTH / 2)
				&& this.processing.mouseY >= (this.position[1] - HEIGHT / 2)
				&& this.processing.mouseY <= (this.position[1] + HEIGHT / 2)) {

			return true;
		}

		return false;
	}

}
