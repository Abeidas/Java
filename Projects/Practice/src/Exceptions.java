
public class Exceptions {       
	public static void main(String args[]) {
		String[] ahmad = new String[10];
        try {
        	System.out.println(ahmad[11]);        
        }catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println("thrown:" + e);
        }
        System.out.println("Everything is ok");
	}
}