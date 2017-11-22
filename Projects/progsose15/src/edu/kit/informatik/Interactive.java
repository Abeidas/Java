package edu.kit.informatik;

/**
 * 
 * @author Ahmad Beidas
 * @version 1.0
 */
public class Interactive {
    public static void main(String[] args) throws SearchInquiryException {
        Search compound = new Search();
        Book book = new Book("java", "ahmad", "2015");
        double tolerance = Double.parseDouble(args[0]);
        String search = "";
        while (true) {
            search = Terminal.readLine();
            if (search.substring(0, 4).equals("quit")) {
                return;
            }
            else if (search.substring(0, 6).equals("search")) {
                String phrAse = search.substring(search.indexOf(" "), search.length()).replace(" ", "");
                valid(phrAse);
                phraseProofer(phrAse);
                Terminal.printLine(phrAse + "," + compound.tolerance(tolerance, phrAse, book));
            } else {
                throw new SearchInquiryException("Invalid Command!");
            }

        }
    }

    public static boolean valid(String p) throws SearchInquiryException {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        while (p.substring(6, p.length()).contains(")") || p.contains("=") 
                || p.contains(",") || p.contains("And(") || p.contains("OR(")) {
            if (p.contains("OR(")) {
                ++a;
                p = p.replaceFirst("OR\\(", "");
            }
            if (p.contains("AND(")) {
                ++a;
                p = p.replaceFirst("AND\\(", "");
            }
            if (p.contains(")")) {
                ++b;
                p = p.replaceFirst("\\)", "");
            }
            if (p.contains("=")) {
                ++c;
                p = p.replaceFirst("=", "");
            }
            if (p.contains(",")) {
                ++d;
                p = p.replaceFirst("\\,", "");
            }
        }
        if (a == b && b == c - 1 && c - 1 == d) {
            return true;
        } else if(!p.contains("\\(")) {
            return true;
        }
        else {
            throw new SearchInquiryException("Error In Input!");
        }
    }

    public static void phraseProofer(String p) throws SearchInquiryException {
        if (!p.substring(6, p.length() - 1).matches("[)=(,a-zA-Z0-9_-]+")) {
            throw new SearchInquiryException("Phrase contains inacceptable characters!");
        } 
    }
}
