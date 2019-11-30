public class Book extends Item {

    private String author;
    private int numberOfPages;
    private String genre;

    public Book() {

        super(); // Calls constructor from parent (Item)

        author = "Default";
        numberOfPages = 0;
        genre = "Default";
    }

    public Book(String name, int borrowTime, double lateFee, boolean currentlyBorrowed, String author, int numberOfPages, String genre) {

        super(name, borrowTime, lateFee, currentlyBorrowed);  // Calls constructor from parent (Item)

        this.author = author;

        // Ensuring numberOfPages can't be set to anything other than M or F in the Constructor
        if (numberOfPages >= 0) {

            this.numberOfPages = numberOfPages;
        }
        else {

            this.numberOfPages = 0;
        }

        this.genre = genre;
    }

    public String getAuthor() {

        return author;
    }

    public int getNumberOfPages() {

        return numberOfPages;
    }

    public String getGenre() {

        return genre;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {

        // Ensuring numberOfPages can't be set to a negative number in the setter
        if (numberOfPages >= 0) {

            this.numberOfPages = numberOfPages;
        }
        else {

            this.numberOfPages = 0;
        }
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }
}
