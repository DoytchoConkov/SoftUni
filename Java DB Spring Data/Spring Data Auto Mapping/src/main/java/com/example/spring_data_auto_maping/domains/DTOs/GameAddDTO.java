package com.example.spring_data_auto_maping.domains.DTOs;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDTO {
    private String title;
    private String trailer;
    private String thumbnailURL;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameAddDTO() {
    }

    public GameAddDTO(String title, String trailer, String thumbnailURL, double size, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "([A-Z][a-z ]{2,99})", message = "Title is not valid!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Size(min = 11, max = 11, message = "Invalid trailer link!")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "^http:\\/\\/.+|https:\\/\\/.+", message = "Invalid image thumbnail!")
    public String getImageThumbnail() {
        return thumbnailURL;
    }

    public void setImageThumbnail(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Min(value = 0, message = "Size must be posetive!")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @DecimalMin(value = "0", message = "Price must be posetive!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Size(min = 20, message = "Description is not valid!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
