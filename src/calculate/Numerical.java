package calculate;

public class Numerical {
	Numerical(){
		double h = 0.000001;
	}
	public static double difficiate(double x) {
		
		return (f(x+h) - f(x))/h;
	}
	
	public static double difficiate(double x, double y) {
		
	}
}
