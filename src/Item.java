abstract class Item {
    protected String id;
    protected String title;

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract void displayDetails();
}