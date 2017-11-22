package lucas;
/**
 * 
 * @author Ahmad
 * @version 1.0
 */
public class Lucas {
    /**
     * 
     * @param n the biggest number in the Lucas sequence
     * @param p the value p to be used in sequence
     * @param q the value q to be used in sequence
     * @return return the recursive Integer method in the sequence
     */
    public int funktion(int n, int p, int q) {
        int print = 0;
        if (n == 0) {
        return 0;
            } else if (n == 1) {
            return 1;
            } else {
                print = p * funktion(n - 1, p, q) - q * funktion(n - 2, p, q);
                System.out.println(print);
                }
        return print;
        }
}
