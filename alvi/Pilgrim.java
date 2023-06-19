// Pilgrim class
class Pilgrim extends Participant {
    public Pilgrim(String name, int age) {
        super(name, age);
    }

    @Override
    public String getRole() {
        return "Pilgrim";
    }

    public void performTawaf() {
        System.out.println("Performing Tawaf");
    }

    public void performSaee() {
        System.out.println("Performing Saee");
    }
}