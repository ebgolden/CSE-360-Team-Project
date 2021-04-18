package dal.dao;

public abstract class PersonRecord {
    private int id;
    private String lastName, firstName;

    public PersonRecord() {
        id = 0;
        lastName = "";
        firstName = "";
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}
