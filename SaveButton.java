import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Saves the room data. 
 * @author Sarad Aryal
 *
 */

public class SaveButton extends Button  {
	 
	public SaveButton(float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = "Save Room";
	}
	/**
	 * Writes the furniture data to a file of .ddd
	 */
	public void mouseDown(Furniture[] furniture) { 
		if (isMouseOver()) { 
			File saveFile = new File("RoomData.ddd"); 
			PrintWriter fout = null; 
		
	
			try {
				fout = new PrintWriter(saveFile);
				
				//gets data from Furniture and puts in the RoomData
				for (int i = 0; i < furniture.length; i++) {
					if (furniture[i] != null) {
						float[] thePositions = furniture[i].getPosition();

						fout.println(furniture[i].getFurniture() + ":" + 
								thePositions[0] + "," + thePositions[1] + "," + 
								furniture[i].getRotations());

					}

				}

			} catch (FileNotFoundException e) {
				
				System.out.println("WARNING: Could not save room "
						+ "contents to file RoomData.ddd.");

			} finally {
				
				if (fout != null)
					fout.close();

			}
		
		}
		
		
		
		
	} 	
}
