package com.vieira.springmongo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record CommentDto(
        String text,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
        Date date,

        AuthorDto author)  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}


