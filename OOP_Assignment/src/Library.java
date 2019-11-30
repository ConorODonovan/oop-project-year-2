public class Library {

    private String name;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String phone;

    public Library() {

        name = "Default";
        addressLine1 = "N/A";
        addressLine2 = "N/A";
        addressLine3 = "N/A";
        phone = "N/A";
    }

    public Library(String name, String addressLine1, String addressLine2, String addressLine3, String phone) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.phone = phone;
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

    public void setPhone(String newPhone){

            phone = newPhone;
        }
}
