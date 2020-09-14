import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * Runs the load button
 * 
 * 
 * @author Sarad Aryal
 *
 */

public class LoadButton extends Button {
	 
	public LoadButton(float x, float y, PApplet processing) {
		super(x, y, processing);
		this.label = "Load Room";
	}
	/**
	 * Loads furniture and overrides from the Button class.
	 */
	@Override
	public void mouseDown(Furniture[] furniture) {
		if (isMouseOver()) {
			//deletes current room configuration
			for (int i = 0; i < furniture.length; i++) {
				furniture[i] = null;
			}
			File saveFile = new File("RoomData.ddd");
			FileInputStream fileByteStream = null;
			Scanner readFile = null;
			//used to stop reading the file when there is 6 furniture
			int numOfFurnBuilt = 0;
			
			try {
				//allows for correct throwing of FileNotFound
				if (saveFile.exists()) {
					fileByteStream = new FileInputStream("RoomData.ddd");
				} else {
					throw new FileNotFoundException();
				}
				readFile = new Scanner(fileByteStream);
				
				//reads in the line
				while (readFile.hasNextLine()) {
					String data = readFile.nextLine().trim();

					if (data.length() > 0 && correctlyFormatted(data)) {

						String[] typeOfFurn = data.split(":");
						String[] xYRotations = typeOfFurn[1].split(",");
						//parses data into correct format
						float[] position = { Float.parseFloat(xYRotations[0].trim()), 
								Float.parseFloat(xYRotations[1].trim()) };
						int rotations = Integer.parseInt(xYRotations[2].trim());
						
						if (numOfFurnBuilt < furniture.length) {
							for (int i = 0; i < furniture.length; i++) {
								if (furniture[i] == null && 
										//checks if image exists
										doesImageExist(typeOfFurn[0].trim())) {
									furniture[i] = new Furniture(typeOfFurn[0].trim(), 
											processing, rotations, position);
									numOfFurnBuilt++;
									break;
								}
							}
						} else {
							System.out.println("WARNING: Unable to "
									+ "load more furniture.");
							break;
						}
					}
				}

			} catch (FileNotFoundException e) {

				System.out.println("WARNING: Could not load room "
						+ "contents from file RoomData.ddd.");

			} finally {
				
				if (fileByteStream != null)
					//catches the possible IOException
					try {
						fileByteStream.close();
					} catch (IOException e) {
						//do nothing just catch
					}
				if (readFile != null)
					readFile.close();

			}

		}

	}	
	
	
	/**
	 * Checks if image is there, if not prints the WARNING message.
	 * 
	 * @return
	 */
	public boolean doesImageExist(String furnName) {
		
		File file = new File("images" + File.separatorChar + furnName + ".png");
		if (file.exists()) {
			return true;
		} else {
			System.out.println("WARNING: Could not find an image for a "
					+ "furniture object of type: "
					+ furnName);
			return false;
		}
		
	}
	/**
	 * checks if the line is correctly formatted, if not 
	 * prints the WARNING message.
	 * @param line
	 * @return
	 */
	public boolean correctlyFormatted(String line) {
		boolean format = true;
		//will be used to see if : is in correct area
		int indexOfLastChar = 0;
		int indexOfFirstDigit = 0;
		//checks for correct # of commas
		int numOfCommas = 0;
		
		for(int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ',') {
				numOfCommas++;
			}
			
			//checks for a nonletter then for a letter in a index one 
			//before to see where last letter is
			if (i != 0) {
				if (!Character.isLetter(line.charAt(i)) && 
						Character.isLetter(line.charAt(i - 1))) {
					indexOfLastChar = i - 1;
				}
			}
			
			int onlyOnce = 0; //so it gets the 1st number
			if (onlyOnce < 1 && Character.isDigit(line.charAt(i))) {
				indexOfFirstDigit = i;
				onlyOnce++;
			}
			
			
		}
		
		//this for loop needs to go first then you can check commas.
		//checks for :
		for (int i = indexOfLastChar + 1; i < indexOfFirstDigit; i++) {
			if (line.charAt(i) == ':') {
				format = true;
				break;
			} else {
				format = false;
			}
		}
		
		if (numOfCommas != 2) {
			format = false;
		}
		
		//prints the error message
		if (!format) {
			System.out.println("WARNING: Found incorrectly "
					+ "formatted line in file: " + line);
		}
		
		return format;
	}

}


