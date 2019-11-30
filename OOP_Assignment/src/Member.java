public class Member {

    private String forename;
    private String surname;
    private char gender;
    private int age;

    public Member() {

        forename = "John";
        surname = "Smith";
        gender = 'M';
        age = 30;
    }

    public Member(String forename, String surname, char gender, int age) {

        this.forename = forename;
        this.surname = surname;

        // Ensuring gender can't be set to anything other than M or F in the Constructor
        // Also allows for entering lowercase m and f
        if (gender == 'M' || gender == 'm') {

            this.gender = 'M';
        }
        else if (gender == 'F' || gender == 'f') {

            this.gender = 'F';
        }
        else {

            this.gender = 'F';
        }

        this.age = age;
    }

    public String getForename() {

        return forename;
    }

    public String getSurname() {

        return surname;
    }

    public char getGender() {

        return gender;
    }

    public int getAge() {

        return age;
    }

    public void setForename(String newForename) {

        forename = newForename;
    }

    public void setSurname(String newSurname) {

        surname = newSurname;
    }

    public void setGender(char newGender) {

        // Ensuring gender can't be set to anything other than M or F in the setter
        // and allowing for entry of lower-case m and f
        // Defaults to F if invalid character entered
        if (newGender == 'M' || newGender == 'm') {

            gender = 'M';
        }
        else if (newGender == 'F' || newGender == 'f') {

            gender = 'F';
        }
        else {

            gender = 'F';
        }
    }

    public void setAge(int newAge) {

        age = newAge;
    }
}
