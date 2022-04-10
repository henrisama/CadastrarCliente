package src.utils;

public class Client{
    private String Name;
    private String CPF;
    private String Phone;
    private String Email;
    private Address address;

    public Client(){

    }

    public Client(String Name, String CPF, String Phone, String Email) {
        this.Name = Name;
        this.CPF = CPF;
        this.Phone = Phone;
        this.Email = Email;
    }

    public Client(String Name, String CPF, String Phone, String Email, Address address) {
        this.Name = Name;
        this.CPF = CPF;
        this.Phone = Phone;
        this.Email = Email;
        this.address = address;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(String Street, int Number, String City, char[] UF) {
        this.address = new Address(Street, Number, City, UF);
    }

    @Override
    public String toString() {
        return "{" +
            " Name='" + getName() + "'" +
            ", CPF='" + getCPF() + "'" +
            ", Phone='" + getPhone() + "'" +
            ", Email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

}
