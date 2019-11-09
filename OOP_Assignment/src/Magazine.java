public class Magazine extends Item {

    private int issue;

    public Magazine() {

        super();

        this.issue = 1;
    }

    public Magazine(String name, int borrowTime, double lateFee, boolean currentlyBorrowed, int issue) {

        super(name, borrowTime, lateFee, currentlyBorrowed);

        // Ensuring issue can't be set to less than 1 in the Constructor
        if (issue > 0) {

            this.issue = issue;
        }
        else {

            this.issue = 1;
        }
    }

    public int getIssue() {

        return issue;
    }

    public void setIssue(int issue) {

        if (issue > 0) {

            this.issue = issue;
        }
        else {

            this.issue = 1;
        }
    }
}
