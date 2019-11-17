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
        if (gender == 'M' || gender == 'F') {

            this.gender = gender;
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
        if (newGender == 'M' || newGender == 'F') {

            gender = newGender;
        }
        else {

            gender = 'F';
        }
    }

    public void setAge(int newAge) {

        age = newAge;
    }
}
