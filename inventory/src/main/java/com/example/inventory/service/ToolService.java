package com.example.inventory.service;

import com.example.inventory.entity.Tool;
import com.example.inventory.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToolService {

    private final ToolRepository toolRepository;

    public Tool saveTool(Tool tool) {
        // İş kuralları burada olabilir
        // Örn: quantity negatif olamaz
        if (tool.getQuantity() < 0) {
            throw new IllegalArgumentException("Miktar negatif olamaz");
        }
        // Repository ile DB’ye kaydediyoruz
        return toolRepository.save(tool);
    }


    // Tümünü getir
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    // ID’ye göre getir
    public Tool getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + id));
    }
    public Tool updateTool(Long id, Tool tool) {
        // Önce DB’den mevcut kaydı al
        Tool existingTool = toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Araç bulunamadı"));

        // İş kuralları: quantity negatif olamaz
        if (tool.getQuantity() < 0) {
            throw new IllegalArgumentException("Miktar negatif olamaz");
        }

        // Güncellenen alanları mevcut objeye set et
        existingTool.setName(tool.getName());
        existingTool.setQuantity(tool.getQuantity());
        existingTool.setDescription(tool.getDescription());

        // Repository ile DB’de kaydet
        return toolRepository.save(existingTool); // save hem insert hem update yapar
    }




}
