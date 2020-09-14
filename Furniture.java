
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
 * This class is used for all furniture implementation. 
 * @author Thomas Grutsch and Robert Fitzpatrick
 *
 */

public class Furniture implements DormGUI {
	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	private String typeOfFurniture;
	/**
	 * This is used when making a new furniture from a button
	 * @param typeOfFurniture
	 * @param processing
	 */
	public Furniture( String typeOfFurniture, PApplet processing) { 
		
		this.typeOfFurniture = typeOfFurniture;
		this.processing = processing;
		this.image = processing.loadImage("images/" + typeOfFurniture + ".png");
		this.position = new float[2];
		this.position[0] = processing.width/2; //x
		this.position[1] = processing.height/2;//y
		this.isDragging = false;
		this.rotations = 0;
		
	}
	/**
	 * This is used when loading furniture
	 * @param typeOfFurniture
	 * @param processing
	 * @param numRotations
	 * @param position
	 */
	public Furniture( String typeOfFurniture, PApplet processing, 
			int numRotations, float[] position) {
		
		this.typeOfFurniture = typeOfFurniture;
		this.processing = processing;
		this.image = processing.loadImage("images/" + this.typeOfFurniture + ".png");
		this.position = new float[2];
		this.position[0] = position[0]; //x
		this.position[1] = position[1];//y
		this.isDragging = false;
		this.rotations = numRotations;
		
		
	}
	
	/**
	 * updates the furniture
	 */
	public void update() {

		// prints the bedImage in the center when new bed is made
		
		if (!this.isDragging) {
			this.processing.image(image, position[0], position[1], 
					rotations*PApplet.PI/2);
			
		}	
		

		// allows for furniture to be dragged
		if (this.isDragging) {
			this.position[0] = this.processing.mouseX;
			this.position[1] = this.processing.mouseY;

			processing.image(image, position[0], position[1], 
					rotations*PApplet.PI/2);
		}

	}
	
	/**
	 * sets isdragging to true.
	 */
	public void mouseDown(Furniture[] furniture) {

		if (isMouseOver()) {
			this.isDragging = true;
		}
			
	}

	/**
	 * sets isDragging to false
	 */
	public void mouseUp() {
		
		//when mouse is not pushed
		this.isDragging = false;
		
	}

	/**
	 * Checks if mouse is over.
	 */
	public boolean isMouseOver() {
		boolean over = false;
		
		//checks for the rotation
		if (this.rotations % 2 == 0) {
			if (this.processing.mouseX >= (this.position[0] - this.image.width / 2)
					&& this.processing.mouseX <= (this.position[0] + this.image.width / 2)
					&& this.processing.mouseY >= (this.position[1] - this.image.height / 2)
					&& this.processing.mouseY <= (this.position[1] + this.image.height / 2)) {

				over = true;

			}
		} else { //switched heights and widths
			if (this.processing.mouseX >= (this.position[0] - this.image.height / 2) 
					&& this.processing.mouseX <= (this.position[0] + this.image.height / 2)
					&& this.processing.mouseY >= (this.position[1] - this.image.width / 2)
					&& this.processing.mouseY <= (this.position[1] + this.image.width / 2)) {

				over = true;
			}
		}
		return over;
	}
	
	/**
	 * adds one to rotations to rotate the furniture.
	 */
	public void rotate() {
		rotations++;
	}
	
	/**
	 * getter methods for save button.
	 * @return
	 */
	public int getRotations() {
		
		return rotations;
		
	}
	
	public String getFurniture() {
		
		return typeOfFurniture;
		
	}

	public float[] getPosition() {
	
		return position;
	
	}

}
