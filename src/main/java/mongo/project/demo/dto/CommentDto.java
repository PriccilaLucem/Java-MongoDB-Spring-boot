package mongo.project.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CommentDto implements Serializable {

    private String text;
    private Date date;
    private AuthorDto author;

    public CommentDto() {
    }

    public CommentDto(String text, Date date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDto getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public CommentDto text(String text) {
        setText(text);
        return this;
    }

    public CommentDto date(Date date) {
        setDate(date);
        return this;
    }

    public CommentDto author(AuthorDto author) {
        setAuthor(author);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentDto)) {
            return false;
        }
        CommentDto commentDto = (CommentDto) o;
        return Objects.equals(text, commentDto.text) && Objects.equals(date, commentDto.date)
                && Objects.equals(author, commentDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, date, author);
    }

    @Override
    public String toString() {
        return "{" +
                " text='" + getText() + "'" +
                ", date='" + getDate() + "'" +
                ", author='" + getAuthor() + "'" +
                "}";
    }

}
