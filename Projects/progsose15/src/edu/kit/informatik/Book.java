package edu.kit.informatik;

/**
 * 
 * @author Ahmad Beidas
 * @version 1.0
 */
public class Book {
    private String creator;
    private String title;
    private String year;

    /**
     * 
     * @param creator
     *            that is the name of the person, who wrote the book, each book has only one creator.
     * @param title
     *            the name of the book, each book has only one creator.
     * @param year
     *            the in which the book was created, can only be between year zero and 2015.
     * @throws SearchInquiryException
     *             two exceptions will be handled, the creator name should be alphanumeric along with the minus and
     *             underscore mark, as well as the year should be between 0 and 2015
     */
    public Book(String title, String creator, String year) throws SearchInquiryException {
        if (year.equals("unknown")) {
            this.year = "unknown";
        } else {
            try {
                Integer.parseInt(year);
            } catch (NumberFormatException e) {
                Terminal.printLine("Year isn't a number!");
            }
            if ((Integer.parseInt(year) < 0 || Integer.parseInt(year) > 2015)) {
                throw new SearchInquiryException("Invalid date of Book creation!");
            }
        }
        if (!creator.matches("[a-zA-Z0-9_-]+")) {
            throw new SearchInquiryException("Creator name doesn't match the pattern _-[^a-zA-Z0-9]!");
        }
        this.creator = creator;
        this.title = title;
        this.year = year;
    }

    /**
     * @return return gives back the creator of the book.
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @return gives back the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return gives back the date of the book.
     */
    public String getYear() {
        return year;
    }

    /**
     * @param creator
     *            changes the creator of the book from unknown to a new creator.
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @param title
     *            changes the title of the book from unknown to a new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param year
     *            changes the date of the book from unknown to a new date.
     */
    public void setYear(String year) {
        this.year = year;
    }
}
