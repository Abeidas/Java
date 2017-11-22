import java.net.URL;




public class Test {
	public static void main(String args[]) {
		URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(url.getPath());
		int x = 1234567;
	        int i;
	        for( i = 0; x >= 1; i++) {
	            x = x/10;
	        }
	        System.out.println(i);
	    }
		

}
