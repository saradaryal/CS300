import java.util.Random;
/*
 * HOW TO GET SOMETHING RANDOMLY MOVING ACROSS THE ROOM(using random):
 * do we set points and random then have it get there? set it inside the boundaries of the room
 * Need a velocity constant? -- probably
 * what if the rand gen only randomly chose 0-3 which determines what gets added or 
 * subtracted? -- hmmmmmmmmmm on to something -- did not work as thought
 * revamped idea -- similar to the idea up front but this time have it go in that direction 
 * for a random amount of steps -- think about it as making a slope that goes for a 
 * random number of steps. 
 */
		// back to the drawing boards 
/*
 * 
 */
public class Cleaner implements DormGUI {
	private PApplet processing;
	private PImage image;
	private float[] position;
	private float[] prev;
	private static Random rand;
	private final int VELOCITY = 5;
	
	public Cleaner (PApplet processing) {
		
		this.processing = processing;
		this.image = processing.loadImage("images/" + "cleaner" + ".png");
		this.position = new float[2];
		this.position[0] = processing.width/2; //x
		this.position[1] = processing.height/2;//y
		prev = position;
		this.rand = new Random();
	}
	
	/**
	 * updates the cleaner
	 */
	public void update() {

		// prints the bedImage in the center when new bed is made
		//not the best way to do it 
		int counter = rand.nextInt(50) + 5; //5--min number of steps
		int steps = 0;
		int x = rand.nextInt(2);
		int y = rand.nextInt(2);
		
		if (x == 0 && y == 0) {
			while (steps < counter) {
				if (position[0] > 50 && position[1] > 50) {
					position[0] -= 1;
					
				}
				
				
				
			}
		}
		
//		this.position[0] = this.processing.mouseX;
//		this.position[1] = this.processing.mouseY;
//		this.position[0] = x;
//		this.position[1] = y;

		processing.image(image, position[0], position[1]);
		

	}

	@Override
	public void mouseDown(Furniture[] furniture) {
		// does nothing
		
	}

	@Override
	public void mouseUp() {
		// does nothing
		
	}

	@Override
	public boolean isMouseOver() {
		// only returns false!
		return false;
	}
	

	private static float[] nextPosition() {
		float[] nextPos = new float[2];
		float x = 0;
		float y = 0;
		int counter = 0;
		//gets x
		while (counter < 1) {
			x = rand.nextInt(651);
			if (x > 150) {
				counter++;
				nextPos[0] = x;
			}
			
			
		}
		//gets y
		while (counter < 2) {
			y = rand.nextInt(450);
			if (y > 50) {
				counter++;
				nextPos[0] = y;
			}
			
			
		}

		return nextPos;
	}
	
	private static boolean check(float[] nextPos) {
		
		
		
		
		return false;
	}
	
	
	
	
}
