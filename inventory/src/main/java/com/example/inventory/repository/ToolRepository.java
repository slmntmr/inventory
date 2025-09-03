package com.example.inventory.repository;

import com.example.inventory.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository katmanı, veritabanı ile Tool entity'si arasındaki işlemleri yönetir
@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    // JpaRepository sayesinde temel CRUD işlemleri (save, findAll, findById, delete) otomatik gelir
}
