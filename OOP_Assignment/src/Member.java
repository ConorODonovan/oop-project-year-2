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
        this.gender = gender;
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

        if (newGender == 'M' || newGender == 'F') {

            gender = newGender;
        }
        else {

            gender = 'M';
        }
    }

    public void setIsAdult(boolean newIsAdult) {

        isAdult = newIsAdult;
    }
}
