package com.example.inventory.service;

import com.example.inventory.entity.Tool;
import com.example.inventory.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
