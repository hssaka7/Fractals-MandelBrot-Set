/**
 * Aakash Basnet
 * This method contains the executable main method.
 * This class calibrates the co-ordinate system and
 * determines whether the co-ordinate converges or
 * diverges. This method also creates javaFx application for
 * showing the Mandelbort Set Fractal.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FractalsMain extends Application
{
  private double realMax = 0.7;
  private double realMin = -1.5;
  private double imaginaryMax = 1;
  private double imaginaryMin = -1;
  private double x_diff;
  private double y_diff;
  private DrawingCanvas canvas;

  public static final int WINDOW_WIDTH = 800;
  public static final int WINDOW_HEIGHT = 800;
  public static final double CUT_OFF = 4;
  public static final int ITERATION = 170;

  /**
   * This is start method which creates the scene and the primary
   * stage and shows it.
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("Mandelbort Set Fractal");

    VBox pageContainer = new VBox(0);
    canvas = new DrawingCanvas(WINDOW_WIDTH,WINDOW_HEIGHT);
    getCoordinates();
   // canvas.drawAxis();
    pageContainer.getChildren().addAll(canvas);

    StackPane root = new StackPane();
    root.getChildren().addAll(pageContainer);


    Scene scene = new Scene(root, WINDOW_WIDTH,WINDOW_HEIGHT );
    primaryStage.setScene(scene);
    primaryStage.setOnCloseRequest(e-> Platform.exit());

    primaryStage.show();
  }

  /**
   * This method iterates the given co-ordinates and determines whether
   * it converges or diverges by comparing with the cutoff value.
   * Then this method draws the cordinate in the canvas by calling draw
   * method from the DrawingMethod class.
   * @param x       original real part
   * @param y       original imaginary part
   * @param i       x_component in canvas
   * @param j       y_component in canvas
   */
  public void calculateMandelbortSet(double x, double y,int i,int j)
  {
    ComplexCalc constant = new ComplexCalc(x,y);
    ComplexCalc z_init = new ComplexCalc(0,0);
    ComplexCalc z_next = new ComplexCalc(0,0);
    double[] z_init_squared;
    double magnitude_escape = 0;
    int colorValue = 0;
    for(int start = 0; start < ITERATION; start++ )
    {
      //z_next = z_init^2 + c;
      z_init_squared = z_init.square();
      z_next.setReal(z_init_squared[0] + constant.getReal());
      z_next.setImaginary(z_init_squared[1] + constant.getImaginary());

      if(z_next.magnitude() > CUT_OFF){
        colorValue = start;
        magnitude_escape = z_next.magnitude();
        break;
      }
      else
      {
        z_init.setReal(z_next.getReal());
        z_init.setImaginary(z_next.getImaginary());
      }
    }
    canvas.draw(i,j,colorValue,magnitude_escape);
  }

  /**
   * This method calibrates the canvas making 1 pixel = 1 step
   * For each co-ordinate, this method calls calculateMandelbortSet
   * method.
   */
  public void getCoordinates()
  {
    x_diff = (realMax-realMin)/canvas.getWidth();
    y_diff = (imaginaryMax-imaginaryMin)/canvas.getHeight();
    int i = 0;
    int j = 0;
    for (double x = realMin; x <= realMax; x += x_diff)
    {
      for(double y = imaginaryMin; y <= imaginaryMax; y += y_diff)
      {
         calculateMandelbortSet(x,y,i,j);
         j++;
      }
      i++;
      j = 0;
    }
  }

  /**
   * This is an excutable main method.
   * @param args   command line argument. (There is no
   *               command line argument for this project.)
   */
  public static void main(String[] args)
  {
    launch(args);
  }
}