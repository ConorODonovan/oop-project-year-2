public class Library {

    private String name;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String phone;
    private int memberCount;

    public Library() {

        name = "C & C's Books";
        addressLine1 = "123 Java Lane";
        addressLine2 = "Javatown";
        addressLine3 = "Javaland";
        phone = "555-1492";
        memberCount = 0;
    }

    public Library(String name, String addressLine1, String addressLine2, String addressLine3, String phone, int memberCount) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.phone = phone;

        // Ensuring memberCount can't be set to a negative number in the Constructor
        if (memberCount >= 0) {

            this.memberCount = memberCount;
        }
        else {

            this.memberCount = 0;
        }
    }

    public String getName() {

        return name;
    }

    public String getAddressLine1() {

        return addressLine1;
    }

    public String getAddressLine2() {

        return addressLine2;
    }

    public String getAddressLine3() {

        return addressLine3;
    }

    public String getPhone() {

        return phone;
    }

    public int getMemberCount() {

        return memberCount;
    }

    public void setName(String newName) {

        name = newName;
    }

    public void setAddressLine1(String newAddressLine1) {

        addressLine1 = newAddressLine1;
    }

    public void setAddressLine2(String newAddressLine2) {

        addressLine1 = newAddressLine2;
    }

    public void setAddressLine3(String newAddressLine3) {

        addressLine1 = newAddressLine3;
    }

    public void setPhone(String newPhone) {

        phone = newPhone;
    }

    // Ensuring memberCount can't be set to a negative number in the setter
    public void setMemberCount(int newMemberCount) {

        if (newMemberCount >= 0) {

            memberCount = newMemberCount;
        }
        else {

            memberCount = 0;
        }
    }
}
