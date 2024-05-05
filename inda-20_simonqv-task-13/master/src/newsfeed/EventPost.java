import java.time.LocalDate;

public class EventPost extends Post{
    private String title;
    private String location;
    private LocalDate date;

    /**
     *
     * @param author username of author
     * @param title what kind of event it is
     * @param location location of event
     * @param date current date
     */
    public EventPost(String author, String title, String location, LocalDate date) {
        super(author);
        this.title = title;
        this.location = location;
        this.date = date;
    }

    public void display() {
        System.out.println(username + " went to (a/an) " + title);
        System.out.println("Date: " + date);
        System.out.println("*********************");
        super.display();
    }

}
