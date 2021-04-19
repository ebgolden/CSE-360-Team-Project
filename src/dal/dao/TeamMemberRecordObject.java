package dal.dao;

public class TeamMemberRecordObject extends PersonRecord {
    public TeamMemberRecordObject() {
        super();
    }

    public TeamMemberRecordObject(int id, String lastName, String firstName) {
        super(id, lastName, firstName);
    }
}