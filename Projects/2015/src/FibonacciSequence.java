import java.lang.Math;
public class FibonacciSequence {
public static void main(String args[]) {
		if( args[0] == null) {
			System.out.println("No number was entered!");
		}
		int n = Integer.parseInt(args[0]);
		print(n);
		}
public static void print(int n) {
	int[] sequence = new int[index(n)];
	sequence[0] = 1;
	System.out.println(sequence[0]);
	sequence[1] = 1;
	System.out.println(sequence[1]);
	for(int i = 2; i < index(n); i++) {
		sequence[i] = sequence[i-1] + sequence[i-2];
		System.out.println(sequence[i]);
	}
	System.out.println(index(n));

}
public static int index(int n) {
	double x = n*Math.sqrt(5.0) + 0.5;
	double y = (1+Math.sqrt(5))/2;
	return (int) Math.floor(Math.log(x)/Math.log(y));
	
}
}
