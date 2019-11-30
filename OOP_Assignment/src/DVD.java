public class DVD extends Item {

    private String director;
    private int length;

    public DVD() {

        super(); // Calls constructor from parent (Item)

        this.director = "Default";
        this.length = 0;
    }

    public DVD(String name, int borrowTime, double lateFee, boolean currentlyBorrowed, String director, int length) {

        super(name, borrowTime, lateFee, currentlyBorrowed); // Calls constructor from parent (Item)

        this.director = director;
        this.length = length;
    }

    public String getDirector() {

        return director;
    }

    public int getLength() {

        return length;
    }

    public void setDirector(String director) {

        this.director = director;
    }

    // Ensuring length can't be set to a negative number in the setter
    public void setLength(int length) {
        if (length >= 0) {

            this.length = length;
        }
        else {

            this.length = 0;
        }
    }
}
