package com.casestudy.happy_paws.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PetServiceDTO {

    private long petServiceId;


    @NotBlank(message = "This field is required")
    @Size(max = 100, message = "Maximum 100 characters")
    private String name;
    private String description;

    @Min(value = 0,message = "Can't be under 0")

    private Double price;
    private String image;
    public PetServiceDTO() {
    }

    public long getPetServiceId() {
        return petServiceId;
    }

    public void setPetServiceId(long petServiceId) {
        this.petServiceId = petServiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
