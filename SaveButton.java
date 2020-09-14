import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Cheese Eater)
// Files:           (Main)
// Course:          (CS300, spring 2018)
//
// Author:          (Thomas Grutsch and Robert Fitzpatrick)
// Email:           (tgrutsch@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (Robbie Fitzpatrick)
// Partner Email:   (rfitzpatric2@wisc.edu)
// Lecturer's Name: (Gary Dahl)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (None)
// Online Sources:  (None)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Saves the room data. 
 * @author Thomas Grutsch and Robert Fitzpatrick
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
