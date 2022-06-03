package com.vieira.springmongo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vieira.springmongo.dtos.AuthorDto;
import com.vieira.springmongo.dtos.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    @Setter(AccessLevel.NONE)
    private List<CommentDto> comments = new ArrayList<>();

    @Builder
    public Post(Date date, String title, String body, AuthorDto author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
