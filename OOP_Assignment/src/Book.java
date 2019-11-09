public class Book extends Item {

    private String author;
    private int numberOfPages;
    private String genre;

    public Book() {

        author = "Default";
        numberOfPages = 0;
        genre = "Default";
    }

    public Book(String author, int numberOfPages, String genre) {

        this.author = author;

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
