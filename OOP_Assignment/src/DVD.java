public class DVD extends Item {

    private String director;
    private double length;
    private int ageRating;

    public DVD() {

        super();

        this.director = "Default";
        this.length = 0.00;
        this.ageRating = 0;
    }

    public DVD(String name, int borrowTime, double lateFee, boolean currentlyBorrowed, String director, double length, int ageRating) {

        super(name, borrowTime, lateFee, currentlyBorrowed);

        this.director = director;
        this.length = length;
        this.ageRating = ageRating;
    }

    public String getDirector() {

        return director;
    }

    public double getLength() {

        return length;
    }

    public int getAgeRating() {

        return ageRating;
    }

    public void setDirector(String director) {

        this.director = director;
    }

    // Ensuring length can't be set to a negative number in the setter
    public void setLength(double length) {
        if (length >= 0) {

            this.length = length;
        }
        else {

            this.length = 0;
        }
    }

    public void setAgeRating(int ageRating) {

        // Ensuring ageRating can't be set to a negative number in the setter
        if (ageRating >= 0) {

            this.ageRating = ageRating;
        }
        else {

            this.ageRating = 0;
        }
    }
}
