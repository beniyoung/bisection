//import the DecimalFormat class
import java.text.DecimalFormat;

//BisectionFunction Interface
interface BisectionFunction
{
    //abstract method f
    public double f(double x);
}

//BisectionFunctionDemo.java class implements the interface
public class BisectionFunctionDemo implements BisectionFunction
{
    // create a DecimalFormat class object as static
    static DecimalFormat deciform = new DecimalFormat("0.00000");

    //default constructor
    public BisectionFunctionDemo()
    {}

    //implementation of method f of BisectionFunction
    //interface method f takes a double value and returns
    //a double value
    public double f(double x)
    {
	//the equation used is x^3-x-2
	return (3*x-2);
    }

    //main method
    public static void main(String args[])
    {
	System.out.println("Bisection method: ");

	//create an object
	BisectionFunctionDemo bfd = new BisectionFunctionDemo();

	double low = -15;
	double high = 15;

	System.out.println("Number \t Low \t\t " + " High \t\t Middle \t" + "Function value");

	//call the method calculateRoot by passing function interface object, low and high values
	double value = calculateRoot(bfd, low, high);

	//print the returned value
	System.out.println("\nThe root of the polynomial value is: " + deciform.format(value));
    }

    //static method calculateRoot that computes
    //and returns the root value
    public static double calculateRoot(BisectionFunctionDemo fBiSect, double low, double high)
    {
	//declare the iterative variable
	int numOfIters = 1;

	//initialize the maxIterations value
	int maxIterations = 50;

	//declare other variables
	double tolerance = 0.00001;
	double fun1, fun2, funMid;
	double middle = 0;

	//loop to find the root value using binary search method
	do
	    {
		//get the values of the functions f
		fun1 = fBiSect.f(low);
		fun2 = fBiSect.f(high);

		if(fun1*fun2 > 0)
		    {
			System.out.println("Sorry! No bisection exits.");
			System.out.println("Therefore, no root exists in between " + low + " and " + high + " values");
			break;
		    }

		//get the middle element
		middle = (low + high) / 2;

		//get the value of function using middle
		funMid = fBiSect.f(middle);

		//print the values
		System.out.println(numOfIters + "\t " + deciform.format(low) + "\t  " +
				   deciform.format(high) + "\t " +
				   deciform.format(middle) + "\t " +
				   deciform.format(funMid));

		//check whether the product value of fun1
		//and funMid is negative
		if(funMid*fun1 < 0)
		    //if negative assign middle value to high
		    high = middle;
		else
		    //if positive assign middle value to low
		    low = middle;

		//increment the iteration values
		numOfIters++;
	    } while (Math.abs(low - high) / 2 >= tolerance && Math.abs(funMid) > tolerance && numOfIters <= maxIterations);

	//return the value
	return middle;

    }
}
