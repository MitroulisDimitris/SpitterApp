package spitterapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "SpittleEnt")
public class SpittleEnt {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "messageId")
   private int messageId;

   @Column(name = "content",nullable = false,length = 255)
    private String content;

    @Column(name = "datePosted",nullable = false,length = 59)
    private String datePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
    private SpitterEnt autorId;

    public SpittleEnt(String content, String datePosted, SpitterEnt autorId) {
        this.content = content;
        this.datePosted = datePosted;
        this.autorId = autorId;
    }

    public SpittleEnt() {

    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public SpitterEnt getAutorId() {
        return autorId;
    }

    public void setAutorId(SpitterEnt autorId) {
        this.autorId = autorId;
    }
}
