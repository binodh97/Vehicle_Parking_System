package model;

public  class Driver {
    private String name;
    private String NIC;
    private String liceneNo;
    private String address;
    private Integer contact;

    public Driver() {
    }

    public Driver(String name, String NIC, String liceneNo, String address, Integer contact) {
        this.setName(name);
        this.setNIC(NIC);
        this.setLiceneNo(liceneNo);
        this.setAddress(address);
        this.setContact(contact);
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLiceneNo() {
        return liceneNo;
    }

    public void setLiceneNo(String liceneNo) {
        this.liceneNo = liceneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

}
