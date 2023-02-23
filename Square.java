/**
 * Square.java
 * @version 1
 * @author Carolina Duarte
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 */

public class Square extends ClosedShape {
    private int side;//The side of the square

    /**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * @param side Resets the side.
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @return The width of the square
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillOval( x, y, side, side );
        }
        else {
            g.strokeOval( x, y, side, side );
        }
    }


}