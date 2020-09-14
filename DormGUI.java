/**
 * This interface is used to cut down on redundant code in the class main. 
 * 
 * 
 * @author Thomas Grutsch
 *
 */
public interface DormGUI {

	public void update();
	public void mouseDown(Furniture[] furniture);
	public void mouseUp();
	public boolean isMouseOver();
	
}
