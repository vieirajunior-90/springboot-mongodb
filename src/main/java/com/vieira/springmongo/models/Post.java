package com.vieira.springmongo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private Date date;
    private String title;
    private String body;

    private User author;

    @Builder
    public Post(Date date, String title, String body, User author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
