public class Library {

    private String name;
    private String address;
    private String phone;
    private int memberCount;

    public Library() {

        name = "Conor & Conleth's Library";
        address = "123 Main Street\nJavatown\nJavaland";
        phone = "086-5551122";
        memberCount = 0;
    }

    public Library(String name, String address, String phone, int memberCount) {
        this.name = name;
        this.address = address;
        this.phone = phone;

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

    public String getAddress() {

        return address;
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

    public void setAddress(String newAddress) {

        address = newAddress;
    }

    public void setPhone(String newPhone) {

        phone = newPhone;
    }

    public void setMemberCount(int newMemberCount) {

        if (newMemberCount >= 0) {

            memberCount = newMemberCount;
        }
        else {

            memberCount = 0;
        }
    }
}
