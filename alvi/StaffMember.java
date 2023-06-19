// StaffMember class
class StaffMember extends Participant {
    private String groupName;

    public StaffMember(String name, int age, String groupName) {
        super(name, age);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String getRole() {
        return "Hajj Employee";
    }
}
