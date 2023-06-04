package mongo.project.demo.dto;

import java.io.Serializable;

import mongo.project.demo.entities.User;

public class AuthorDto implements Serializable {
    private String id;
    private String name;

    public AuthorDto() {

    }

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
