package spitterapp.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.time.LocalDateTime;


public class Spittle {
    private int id;
    private String text;
    private int authorId;
    private int receiverId;
    private LocalDateTime sentDate;
    private HashMap<LocalDateTime,String> changeHist;


    public Spittle(int id, String text, int authorId, int receiverId, LocalDateTime sentDate) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.receiverId = receiverId;
        this.sentDate = sentDate;
        this.changeHist = new HashMap<>();

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

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public HashMap<LocalDateTime, String> getChangeHist() {
        return changeHist;
    }

    public void setChangeHist(HashMap<LocalDateTime, String> changeHist) {
        this.changeHist = changeHist;
    }

    public void addChangeList(String change, LocalDateTime time){
        this.changeHist.put(time,change);
    }

    @Override
    public String toString() {
        return "Spittle [id=" + id + '\''+
                ", text=" + text + '\''+
                ", authorId=" + authorId + '\''+
                ", receiverId=" + receiverId + '\''+
                ", date=" + sentDate + '\''+
                ", changes=" + changeHist.size() + '\''+
                '}';
    }

    public int getId() {
        return id;
    }
}
