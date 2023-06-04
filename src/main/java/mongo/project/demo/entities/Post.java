package mongo.project.demo.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import mongo.project.demo.dto.AuthorDto;

import java.util.Objects;

@Document
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String description;

    private AuthorDto Author;

    public Post() {
    }

    public AuthorDto getAuthor() {
        return this.Author;
    }

    public void setAuthor(AuthorDto Author) {
        this.Author = Author;
    }

    public Post(String id, Date date, String title, String description, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.Author = author;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post id(String id) {
        setId(id);
        return this;
    }

    public Post date(Date date) {
        setDate(date);
        return this;
    }

    public Post title(String title) {
        setTitle(title);
        return this;
    }

    public void setDescription(String descritption) {
        this.description = descritption;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", date='" + getDate() + "'" +
                ", title='" + getTitle() + "'" +
                ", body='" + getDescription() + "'" +
                "}";
    }

}
