public class Magazine extends Item {

    private int issue;

    public Magazine() {

        this.issue = 1;
    }

    public Magazine(int issue) {

        if (issue > 0) {

            this.issue = issue;
        }
        else {

            this.issue = 1;
        }
    }
}
