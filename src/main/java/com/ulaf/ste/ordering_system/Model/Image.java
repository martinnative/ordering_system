package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(length = 1000)
    @Lob
    byte[] bytes;
    String type;

    public Image(String name, byte[] bytes, String type) {
        this.name = name;
        this.bytes = bytes;
        this.type = type;
    }

    public Image() {

    }
}
