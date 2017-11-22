
public class Test {
public static void main(String args[]) {

	char[] ahmad = {'a', 'h', 'm', 'a', 'd' };
	char[] amjad = { 'a', 'm', 'j', 'a', 'd'};
	char[] sa3eed = { 's', 'a','3', 'e', 'e', 'd'};
	int verdächtig = 5;
	int counter = 0;
	String close = "{";
	char[][] Menge = {amjad, ahmad, sa3eed};
	for( int i = 0; i < Menge.length; i++) {
		for( int j = i + 1 ; j < Menge[j].length - 1; j++) {
			for( int k = 1;  k < Menge[k].length - 1; j++) {
				
				if ( Menge[j][j] == Menge [k][k]) {
					counter++;
				}
				else {
					counter = 0;
				}
				if (verdächtig == counter) {
					close += Menge[j] + "," + Menge[k] + "}";
					
				}
			}
			
		}
	}
}

}

