abstract class Item {

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

        // // Ensuring borrowTime is at least 1 in the Constructor
        if (borrowTime > 0) {

            this.borrowTime = borrowTime;
        }
        else {

            this.borrowTime = 0;
        }

        // Ensuring lateFee can't be set to a negative number in the Constructor
        if (lateFee >= 0.0) {

            this.lateFee = lateFee;
        }
        else {

            this.borrowTime = 0;
        }

        this.currentlyBorrowed = currentlyBorrowed;
    }

    public String getName() {

        return name;
    }

    public int getBorrowTime() {

        return borrowTime;
    }

    public double getLateFee() {

        return lateFee;
    }

    public boolean getCurrentlyBorrowed() {

        return currentlyBorrowed;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setBorrowTime(int borrowTime) {

        // Ensuring borrowTime is at least 1 in the setter
        if (borrowTime > 0) {

            this.borrowTime = borrowTime;
        }
        else {

            this.borrowTime = 1;
        }
    }

    public void setLateFee(double lateFee) {

        // Ensuring lateFee can't be set to a negative number in the setter
        if (lateFee >= 0) {

            this.lateFee = lateFee;
        }
        else {

            this.lateFee = 0;
        }
    }

     public void setCurrentlyBorrowed(boolean currentlyBorrowed) {

        this.currentlyBorrowed = currentlyBorrowed;
     }
}
