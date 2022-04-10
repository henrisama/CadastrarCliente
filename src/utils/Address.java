package src.utils;

public class Address{
    private String Street;
    private int Number;
    private String District;
    private String City;
    private char[] State = new char[2];


    public Address() {
    }

    public Address(String Street, int Number, String City, char[] State) {
        this.Street = Street;
        this.Number = Number;
        this.City = City;
        this.State = State;
    }

    public String getStreet() {
        return this.Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getDistrict() {
        return this.District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public int getNumber() {
        return this.Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public char[] getState() {
        return this.State;
    }

    public void setState(char[] State) {
        this.State = State;
    }

    @Override
    public String toString() {
        return "{" +
            " Street='" + getStreet() + "'" +
            ", Number='" + getNumber() + "'" +
            ", City='" + getCity() + "'" +
            ", State='" + getState().toString() + "'" +
            "}";
    }
    
}
