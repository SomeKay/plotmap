package com.poslek.plotmap.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Book {
    private String isbn10;
    private String isbn13;
    private String title;
    private String imageLink;
    private String publishedDate;
    private List<String> authors;
}
