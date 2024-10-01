package spitterapp.model;
import java.time.LocalDateTime;


public class Spittle {
    private int id;
    private String text;
    private int authorId;
    private LocalDateTime sentDate;


    public Spittle(int id, String text, int authorId, LocalDateTime sentDate) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.sentDate = sentDate;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "Spittle [id=" + id + '\''+
                ", text=" + text + '\''+
                ", authorId=" + authorId + '\''+
                ", date=" + sentDate + '\''+
                '}';
    }

    public int getId() {
        return id;
    }
}
