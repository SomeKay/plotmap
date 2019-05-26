package com.poslek.plotmap.web.services;

import com.poslek.plotmap.web.models.Book;
import com.poslek.plotmap.web.models.GoogleBooksItem;
import com.poslek.plotmap.web.models.GoogleBooksResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleBooksService implements BooksService {

    @Value("${GOOGLE_API_KEY}")
    private String apiKey;

    private static final String ISBN_10 = "ISBN_10";
    private static final String ISBN_13 = "ISBN_13";
    private static final String API_URL = "https://www.googleapis.com/books/v1";

    @Override
    public List<Book> search(String query) {
        List<Book> books = new LinkedList<>();

        RestTemplate restTemplate = new RestTemplate();
        GoogleBooksResponse response = restTemplate
                .getForObject(
                        API_URL + "/volumes?q=" + query + "&key=" + apiKey,
                        GoogleBooksResponse.class);


        books = response.getItems().stream()
                .map(this::mapItemToBook)
                .collect(Collectors.toList());

        return books;
    }

    private Book mapItemToBook(GoogleBooksItem item) {
        Book book = Book.builder()
                .title(item.getVolumeInfo().getTitle())
                .authors(item.getVolumeInfo().getAuthors())
                .publishedDate(item.getVolumeInfo().getPublishedDate())
                .build();

        if (item.getVolumeInfo().getImageLinks() != null) {
            book.setImageLink(
                    item.getVolumeInfo().getImageLinks().getThumbnail());
        }

        item.getVolumeInfo().getIndustryIdentifiers()
                .forEach(industryIdentifier -> {
                    if (industryIdentifier.getType().equals(ISBN_10)) {
                        book.setIsbn10(industryIdentifier.getIdentifier());
                    }
                    if (industryIdentifier.getType().equals(ISBN_13)) {
                        book.setIsbn13(industryIdentifier.getIdentifier());
                    }
                });

        return book;
    }
}
