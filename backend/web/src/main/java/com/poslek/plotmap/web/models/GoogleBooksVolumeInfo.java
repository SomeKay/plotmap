package com.poslek.plotmap.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBooksVolumeInfo {

    private String title;

    private String publishedDate;

    private List<String> authors;

    @Nullable
    private GoogleBooksImageLinks imageLinks;

    private List<GoogleBooksIndustryIdentifier> industryIdentifiers;

}
