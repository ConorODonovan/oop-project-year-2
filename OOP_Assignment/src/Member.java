public class Member {

    private String name;
    private char gender;
    private boolean isAdult;

    public Member() {

        name = "John Smith";
        gender = 'M';
        isAdult = true;
    }

    public Member(String name, char gender, boolean isAdult) {

        this.name = name;

        // Ensuring gender can't be set to anything other than M or F in the Constructor
        if (gender == 'M' || gender == 'F') {

            this.gender = gender;
        }
        else {

            this.gender = 'F';
        }

        this.isAdult = isAdult;
    }

    public String getName() {

        return name;
    }

    public char getGender() {

        return gender;
    }

    public boolean getIsAdult() {

        return isAdult;
    }

    public void setName(String newName) {

        name = newName;
    }

    public void setGender(char newGender) {

        // Ensuring gender can't be set to anything other than M or F in the setter
        if (newGender == 'M' || newGender == 'F') {

            gender = newGender;
        }
        else {

            gender = 'F';
        }
    }

    public void setIsAdult(boolean newIsAdult) {

        isAdult = newIsAdult;
    }
}
