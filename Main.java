import java.util.ArrayList;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Cheese Eater)
// Files:           (Main, Furniture, DormGUI, CreateFurnitureBottun, Button
//					ClearButton, SaveButton, LoadButton)
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
 * This runs the dorm designer program. 
 * @author Thomas Grutsch and Robert Fitzpatrick
 *
 */

public class Main {
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture[] furniture;
	private ArrayList<DormGUI> guiObjects;    
	private final static int MAX_LOAD_FURNITURE = 100;   
	/**
	 * Constructor that intiates everything and adds it to guiObjects. 
	 * @param processing
	 */
	public Main(PApplet processing) {
		
		this.processing = processing;
		this.backgroundImage = processing.loadImage("images/background.png");
		guiObjects = new ArrayList<DormGUI>();
		this.furniture = new Furniture[6]; //(0:x, 1:y)
		//sets to null 
		for (int i = 0; i < furniture.length; i++) {	
			furniture[i] = null;	
		}
		guiObjects.add(new CleanerButton(50, 575, processing));
		guiObjects.add(new CreateFurnitureButton("Bed", 50, 24, processing));
		guiObjects.add(new CreateFurnitureButton("Sofa", 150, 24, processing));
		guiObjects.add(new CreateFurnitureButton("Dresser", 250, 24, processing));
		guiObjects.add(new CreateFurnitureButton("Sink", 450, 24, processing));
		guiObjects.add(new CreateFurnitureButton("Desk", 350, 24, processing));
		guiObjects.add(new ClearButton(550, 24, processing));
		guiObjects.add(new SaveButton(650, 24, processing));
		guiObjects.add(new LoadButton(750, 24, processing));
		
		guiObjects.add(new Cleaner(processing));
				
	}
		
	
	/**
	 * Main runs the program Dorm Designer 2000.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		Utility.startApplication(); 
		
	}
	
	
	/**
	 * Updates the room continuously.
	 * 
	 * @param data
	 */
	public void update() {
		processing.background(100,150,250); //changes background
		//prints the background image
		processing.image(backgroundImage, processing.width/2, 
				processing.height/2);

		for (int i = 0; i < guiObjects.size(); i++) {
		
			guiObjects.get(i).update();
			
		}
		
		
		
	}
	
	/**
	 * When user clicks, checks if bed is there. If there is a bed, the user can drag the bed.
	 * @param data
	 */
	public void mouseDown() {
		//makes furniture array for parameters
		furniture = extractFurnitureFromGUIObjects();
		
		//checks which furniture we are pressing
		for (int i = 0; i < guiObjects.size(); i++) {
		//how to check if it is a cleaner obj???????
			
			
			guiObjects.get(i).mouseDown(furniture);
			
			
			
		
		}

		replaceFurnitureInGUIObjects(furniture);
	}
	
	/**
	 * Makes it so the user stops dragging the bed.
	 * @param data
	 */
	public void mouseUp() {
		
		for (int i = 0; i < guiObjects.size(); i++) {
			
			guiObjects.get(i).mouseUp();
		
		}

	}
	/**
	 * If 'b' is pressed then new bed is made.
	 * 
	 * @param data
	 */
	
	public void keyPressed() {
		char pressed = processing.key;
		//allows for rotations/deletions
		furniture = extractFurnitureFromGUIObjects();
		//deletes furniture
		if (Character.toLowerCase(pressed) == 'd') {
			for (int i = 0; i < furniture.length; i++) {

				if (furniture[i] != null && furniture[i].isMouseOver()) {
					furniture[i] = null;
					break;
				}

			}
		}
		
		//rotates furniture
		if (Character.toLowerCase(pressed) == 'r') {

			for (int i = 0; i < furniture.length; i++) {

				if (furniture[i] != null && furniture[i].isMouseOver()) {
					furniture[i].rotate();
					break;
				}

			}
		}
		
		replaceFurnitureInGUIObjects(furniture);

	}
	
	/**
	 * This method creates a new Furniture[] for the old mouseDown() methods
	 * to make use of.  It does so by copying all Furniture references from
	 * this.guiObjects into a temporary array of size MAX_LOAD_FURNITURE.
	 * @return that array of Furniture references.
	 */
	private Furniture[] extractFurnitureFromGUIObjects() {
	    Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
	    int nextFreeIndex = 0;
	    for(int i=0;i<guiObjects.size() && nextFreeIndex < furniture.length;i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            furniture[nextFreeIndex++] = (Furniture)guiObjects.get(i);        
	    return furniture;        
	}    
	/**
	 * This method first removes all Furniture references from this.guiObjects,
	 * and then adds back in all of the non-null references from it's parameter.
	 * @param furniture contains the only furniture that will be left in 
	 *   this.guiObjects after this method is invoked (null references ignored).
	 */
	private void replaceFurnitureInGUIObjects(Furniture[] furniture) {
	    for(int i=0;i<guiObjects.size();i++)
	        if(guiObjects.get(i) instanceof Furniture)
	            guiObjects.remove(i--);
	    for(int i=0;i<furniture.length;i++)
	        if(furniture[i] != null)
	            guiObjects.add(furniture[i]);
	}
	
}
