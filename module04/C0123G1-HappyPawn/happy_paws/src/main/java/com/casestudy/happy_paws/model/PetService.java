package com.casestudy.happy_paws.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE pet_service SET is_delete = true WHERE pet_service_id=?")
@Where(clause = "is_delete=false")
public class PetService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petServiceId;
    @NotNull
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String image;
    private boolean isDelete = false;
    @Column(name = "createTime", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime;
    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime;

    public PetService() {
    }

    public PetService(Long petServiceId, String name, String description, Double price, String image, boolean isDelete, LocalDateTime createTime, LocalDateTime updateTime) {
        this.petServiceId = petServiceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PetService(String name, String description, Double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Long getPetServiceId() {
        return petServiceId;
    }

    public void setPetServiceId(Long petServiceId) {
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}