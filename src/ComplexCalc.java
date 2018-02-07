/**
 * Aakash Basnet
 * This class have two double variable: real and imaginary.
 * It contains method to square the complex number , find the
 * magnitude of the complex number from the origin and has
 * some getter and setter methods.
 */
public class ComplexCalc
{
  double real;
  double imaginary;

  /**
   * This method is a constructor for ComplexCalc class
   * @param real_part
   * @param imagine_part
   */
  public ComplexCalc(double real_part, double imagine_part)
  {
    this.real = real_part;
    this.imaginary = imagine_part;
  }

  /**
   * Calculates the square of the complex number.
   * @return array consisting real and imaginary part
   * of squared value.
   */
  public double[] square()
  {
    double [] complex_num = new double[2];
    // (a + ib)(a + ib)
    // a^2 + 2*a*ib - b^2
    // a^2 - b^2 + 2*a*b i
    // real part = a^2 - b^2
    // imaginary part = 2*a*b
    complex_num[0] = real*real - imaginary*imaginary;
    complex_num[1] = 2 * real * imaginary;
    return  complex_num;
  }

  /**
   * Calculates the magnitude of complex number from origin.
   * @return magnitude.
   */
  public double magnitude(){

    return Math.sqrt(real*real + imaginary*imaginary);
  }

  /**
   * get method for real part.
   * @return  real part of complex number
   */
  public double getReal()
  {
    return real;
  }

  /**
   * get method fot imaginary part
   * @return  imaginary part for complex number.
   */
  public  double getImaginary()
  {
    return imaginary;
  }

  /**
   * set method for real part
   * @param value   realValue of complex number
   */
  public void setReal(double value)
  {
    this.real = value;
  }

  /**
   * set method for imaginary method.
   * @param value   imaginaryValue for complex number.
   */
  public void setImaginary(double value)
  {
    this.imaginary = value;
  }

}
