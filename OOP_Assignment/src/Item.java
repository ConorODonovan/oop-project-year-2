public class Item {

    private String name;
    private int borrowTime;
    private double lateFee;
    private boolean currentlyBorrowed;

    public Item() {

        name = "Default";
        borrowTime = 7;
        lateFee = 2.50;
        currentlyBorrowed = false;
    }

    public Item(String name, int borrowTime, double lateFee, boolean currentlyBorrowed) {

        this.name = name;

        if (borrowTime >= 0) {

            this.borrowTime = borrowTime;
        }
        else {

            this.borrowTime = 0;
        }

        if (lateFee >= 0.0) {

            this.lateFee = lateFee;
        }
        else {

            this.borrowTime = 0;
        }

        this.currentlyBorrowed = currentlyBorrowed;
    }
}
