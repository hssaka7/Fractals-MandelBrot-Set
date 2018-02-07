/**
 * Aakash Basnet
 * This class creates the canvas for drawing
 * Mandelbort Set.
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawingCanvas extends Canvas
{
  public GraphicsContext gtx;


  /**
   * Constructor for Drawing Canvas class.
   * @param width
   * @param height
   */
  public DrawingCanvas(double width, double height)
  {
    this.setHeight(height);
    this.setWidth(width);
    gtx = this.getGraphicsContext2D();
  }

  /**
   * Calculates the color value with respect to iteration value.
   * The formulas that are used to calculate the color are taken
   * from these websites:
   *
   * https://krazydad.com/tutorials/makecolors.php
   * https://linas.org/art-gallery/escape/smooth.html
   *
   * @param iter     iteration value from which the set diverges
   * @param mag      magnitude of the complex value after which
   *                 the set starts to diverge
   * @return color for particular co-ordinate.
   */
  private Color getColor(int iter,double mag)
  {
    double indx = iter + 1 - (Math.log(Math.log(mag)))/Math.log(4);

    double red = (Math.sin(.3*indx)*127.5+127.5)/255;
    double green = (Math.sin(.3*indx+2)*127.5+127.5)/255;
    double blue = (Math.sin(.3*indx+4)*127.5+127.5)/255;

    return Color.color(red,green,blue);
  }


  /**
   * Draws the given complex co-ordinate in the given canvas.
   * @param x    x-component in our canvas.
   * @param y    y-component in our canvas
   * @param iter the iteration value from which the set diverges.
   * @param mag  magnitude of the complex number after which the set
   *             starts to diverge.
   */
  public void draw(double x, double y, int iter,double mag)
  {
    if(iter == 0) gtx . setStroke(Color.BLACK);

    else
    {
      gtx.setStroke(getColor(iter,mag));
    }

    gtx.strokeRect(x,y,1,1);

  }

  /**
   * Draws the axis on the canvas
   */
  public void drawAxis()
  {
    gtx.setStroke(Color.GREEN);
    gtx.strokeLine(this.getWidth()/2,0,this.getWidth()/2,this.getHeight());
    gtx.strokeLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);
  }
}
