package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>
 * The {@code MazeSolver} class manipulates an 
 * input maze and tries to find a path to get
 * out of the maze, if one exists. It contains 
 * methods to generate a 2D array of {@code Coordinate}
 * objects representing the input maze, method
 * to find the path out of the maze and certain
 * methods that be used to retrieve the 
 * objects of the {@code MazeSolver} class.
 * 
 * @author Arnav Singhania
 *
 */
public class MazeSolver {

	@SuppressWarnings("unused")
	private File inputFile;
	private Coordinate[][] map;
	private Coordinate start;
	private String[] dimensions;

	/**
	 * Uses an input file to generate 
	 * a 2D array of {@code Coordinate}
	 * objects representing the input maze.
	 * 
	 * @param inputFile A file object representing the maze.
	 */
	public MazeSolver(File inputFile) {
		
		this.inputFile = inputFile;
		Scanner sc = null;
		
		try {
			sc = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		dimensions = sc.nextLine().split(" ");
		map = new Coordinate[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
		String[] startCoordinate = sc.nextLine().split(" "); // start position
		start = new Coordinate(Integer.parseInt(startCoordinate[0]), Integer.parseInt(startCoordinate[1]), 'S');
		int rowCount = 0;
		
		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split("");
			for (int a = 0; a < line.length; a++ ) {
				String s = line[a];
				if (s.equals("1")) {
					map[rowCount][a] = new Coordinate(rowCount, a, 'F'); //free
				} else if (s.equals("0")) {
					map[rowCount][a] = new Coordinate(rowCount, a, 'W'); //wall
				} else if (s.equals("S")) {
					map[rowCount][a] = new Coordinate(rowCount, a, 'S'); //start
					start = map[rowCount][a];
				} else {
					map[rowCount][a] = new Coordinate(rowCount, a, 'E'); //end
				}
			}
			rowCount++;
		}
	}

	/**
	 * Finds the path out of the maze, if it exists,
	 * and then returns true or false depicting
	 * whether a solution was found or not.
	 * 
	 * @return A boolean value indicating whether a solution
	 * 		   to the input maze was found or not.
	 */
	public boolean solve() {

		LinkedStack<Coordinate> stack = new LinkedStack<>();
		
		stack.push(start);

		while (!stack.isEmpty()) {
			
			int currentPlayerRow = stack.top().getRow();
			int currentPlayerCol = stack.top().getCol();
			
			if (map[currentPlayerRow+1][currentPlayerCol].getCoordinateValue() == 'F' || map[currentPlayerRow+1][currentPlayerCol].getCoordinateValue() == 'E') { //move down if free
				
				stack.push(map[currentPlayerRow+1][currentPlayerCol]);
				if (stack.top().getCoordinateValue() == 'E') {return true;}
				stack.top().setCoordinateValue('Q'); //'Q' indicates the current position of the player and is used to depict the path out of the maze.
				continue;
				
			} else if (map[currentPlayerRow-1][currentPlayerCol].getCoordinateValue() == 'F' || map[currentPlayerRow-1][currentPlayerCol].getCoordinateValue() == 'E') { //move up if free
				
				stack.push(map[currentPlayerRow-1][currentPlayerCol]);
				if (stack.top().getCoordinateValue() == 'E') {return true;}
				stack.top().setCoordinateValue('Q');
				continue;
				
			} else if (map[currentPlayerRow][currentPlayerCol+1].getCoordinateValue() == 'F' || map[currentPlayerRow][currentPlayerCol+1].getCoordinateValue() == 'E') { //move right if free
				
				stack.push(map[currentPlayerRow][currentPlayerCol+1]);
				if (stack.top().getCoordinateValue() == 'E') {return true;}
				stack.top().setCoordinateValue('Q');
				continue;
				
			} else if (map[currentPlayerRow][currentPlayerCol-1].getCoordinateValue() == 'F' || map[currentPlayerRow][currentPlayerCol-1].getCoordinateValue() == 'E') { //move left if free
				
				stack.push(map[currentPlayerRow][currentPlayerCol-1]);
				if (stack.top().getCoordinateValue() == 'E') {return true;}
				stack.top().setCoordinateValue('Q');
				continue;
				
			} else {
				
				stack.top().setCoordinateValue('C'); //'C' indicates a position representing a dead end
				stack.pop();
				
			}

		}
		
		return false;

	}
	
	/**
	 * Finds and returns a 2D array of 
	 * {@code Coordinate} objects representing 
	 * the input maze.
	 * 
	 * @return A 2D array of {@code Coordinate} objects.
	 */
	public Coordinate[][] getMap() {
		return map;
	}
	
}