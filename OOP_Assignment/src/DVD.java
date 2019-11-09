public class DVD extends Item {

    private String director;
    private double length;
    private int ageRating;

    public DVD() {

        this.director = "Default";
        this.length = 0.00;
        this.ageRating = 0;
    }

    public DVD(String director, double length, int ageRating) {

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

    public void setLength(double length) {
        if (length >= 0) {

            this.length = length;
        }
        else {

            this.length = 0;
        }
    }

    public void setAgeRating(int ageRating) {

        if (ageRating >= 0) {

            this.ageRating = ageRating;
        }
        else {

            this.ageRating = 0;
        }
    }
}
