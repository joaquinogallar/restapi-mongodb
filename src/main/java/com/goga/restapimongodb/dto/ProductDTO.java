package com.goga.restapimongodb.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Product")
public class ProductDTO {

    @Id
    @NonNull
    private Long id;
    private String imagePath;
    private String title;
    private String description;

    public ProductDTO(@NonNull Long id, String imagePath, String title, String description) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.description = description;
    }
}