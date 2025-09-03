package com.example.inventory.entity;

import jakarta.persistence.*;  // JPA anotasyonları için
import lombok.*;               // Lombok anotasyonları için

// Lombok sayesinde getter, setter, toString, equals ve hashCode metodları otomatik oluşturulur
@Data

// Parametresiz constructor ekler
@NoArgsConstructor

// Tüm alanları parametre alan constructor ekler
@AllArgsConstructor

// Bu sınıf bir veritabanı tablosu olarak tanımlanır
@Entity
public class Tool {

    // Bu alan tablonun birincil anahtarıdır
    @Id
    // ID otomatik olarak arttırılır
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Araç ismi
    private String name;

    // Araç miktarı
    private int quantity;

    // Araç açıklaması
    private String description;
}
