
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Carolina Duarte
 */

import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadShapeFile {
    private static Object ClosedShape;

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Method to read a circle's attributes, creates a instance of that shape and prints it out.
     * @param line containing the entries to create a new shape object
     * @return a closed shape object created
     * */
    public static String readCircle (String line){
        ClosedShape newCircle;
        String[] shapeValues = line.split(" ");
        int px = Integer.parseInt(shapeValues[1]);
        int py = Integer.parseInt(shapeValues[2]);
        int vx = Integer.parseInt(shapeValues[3]);
        int vy = Integer.parseInt(shapeValues[4]);
        boolean isFilled = Boolean.parseBoolean(shapeValues[5]);
        int diameter = Integer.parseInt(shapeValues[6]);
        Color newColour = new Color(Float.parseFloat(shapeValues[7])/255,Float.parseFloat(shapeValues[8])/255,Float.parseFloat(shapeValues[9])/255,0);
        int insertionTime = Integer.parseInt(shapeValues[10]);
        newCircle = new Circle(insertionTime,px,py,vx,vy,diameter,newColour,isFilled);
        return newCircle.toString();
    }

    /**
     * Method to read an oval's attributes, creates a instance of that shape and prints it out.
     * @param line containing the entries to create a new shape object
     * @return a closed shape object created
     * */
    public static String readOval (String line){
        ClosedShape newOval;
        String[] shapeValues = line.split(" ");
        int px = Integer.parseInt(shapeValues[1]);
        int py = Integer.parseInt(shapeValues[2]);
        int vx = Integer.parseInt(shapeValues[3]);
        int vy = Integer.parseInt(shapeValues[4]);
        boolean isFilled = Boolean.parseBoolean(shapeValues[5]);
        int width = Integer.parseInt(shapeValues[6]);
        int height = Integer.parseInt(shapeValues[7]);
        Color newColour = new Color(Float.parseFloat(shapeValues[8]),Float.parseFloat(shapeValues[9]),Float.parseFloat(shapeValues[10]),0);
        int insertionTime = Integer.parseInt(shapeValues[11]);
        newOval = new Oval(insertionTime,px,py,vx,vy,width,height,newColour,isFilled);
        return newOval.toString();
    }

    /**
     * Method to read a rectangle's attributes, creates a instance of that shape and prints it out.
     * @param line containing the entries to create a new shape object
     * @return a closed shape object created
     * */
    public static String readRect (String line){
        ClosedShape newRect;
        String[] shapeValues = line.split(" ");
        int px = Integer.parseInt(shapeValues[1]);
        int py = Integer.parseInt(shapeValues[2]);
        int vx = Integer.parseInt(shapeValues[3]);
        int vy = Integer.parseInt(shapeValues[4]);
        boolean isFilled = Boolean.parseBoolean(shapeValues[5]);
        int width = Integer.parseInt(shapeValues[6]);
        int height = Integer.parseInt(shapeValues[7]);
        Color newColour = new Color(Float.parseFloat(shapeValues[8]),Float.parseFloat(shapeValues[9]),Float.parseFloat(shapeValues[10]),0);
        int insertionTime = Integer.parseInt(shapeValues[11]);
        newRect = new Rect(insertionTime,px,py,vx,vy,width,height,newColour,isFilled);
        return newRect.toString();
    }

    /**
     * Method to read a square's attributes, creates a instance of that shape and prints it out.
     * @param line containing the entries to create a new shape object
     * @return a closed shape object created
     * */
    public static String readSquare (String line){
        ClosedShape newSquare;
        String[] shapeValues = line.split(" ");
        int px = Integer.parseInt(shapeValues[1]);
        int py = Integer.parseInt(shapeValues[2]);
        int vx = Integer.parseInt(shapeValues[3]);
        int vy = Integer.parseInt(shapeValues[4]);
        boolean isFilled = Boolean.parseBoolean(shapeValues[5]);
        int side = Integer.parseInt(shapeValues[6]);
        Color newColour = new Color(Float.parseFloat(shapeValues[7]),Float.parseFloat(shapeValues[8]),Float.parseFloat(shapeValues[9]),0);
        int insertionTime = Integer.parseInt(shapeValues[10]);
        newSquare = new Square(insertionTime,px,py,vx,vy,side,newColour,isFilled);
        return newSquare.toString();
    }

    /**
     * Method to refer the input information to the right read methods according to the shape.
     * @param in the scanner of the file
     * @return a closed shape object created
     * */
    public static ClosedShape readNewShape(Scanner in){
        String name = in.next();
        while (in.hasNextLine()){
            switch (name) {
                case "circle":
                    readCircle(in.nextLine());
                    break;
                case "oval":
                    readOval(in.nextLine());
                    break;
                case "rect":
                    readRect(in.nextLine());
                    break;
                case "square":
                    readSquare(in.nextLine());
                    break;
            }
        }
        return (ClosedShape) ClosedShape;
    }

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readLineByLine(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
        while (in.hasNextLine()) {
            shapeQueue.enqueue(readNewShape(in));
        }
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) {
        File inputFile = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + inputFile);
            System.exit(0);
        }
        return ReadShapeFile.readLineByLine(in);
    }
}
