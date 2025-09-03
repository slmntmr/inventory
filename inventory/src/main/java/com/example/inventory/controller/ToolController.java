package com.example.inventory.controller;

import com.example.inventory.entity.Tool;
import com.example.inventory.service.ToolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor; // Lombok kullanacağız
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tools")
@RequiredArgsConstructor // Lombok, final alanlar için constructor oluşturur
public class ToolController {

    // final ile işaretledik, sadece constructor üzerinden set edilir
    private final ToolService toolService;

    // POST /api/tools/save
    @PostMapping("/save")// http://localhost:8080/api/tools/save  + JSON + POST
    public ResponseEntity<Tool> saveTool(@RequestBody @Valid Tool tool) {
        // Kullanıcıdan gelen JSON Tool objesine dönüşür
        // Service katmanına gönderilir
        Tool savedTool = toolService.saveTool(tool);
        // Service döndürür -> ResponseEntity ile kullanıcıya geri yollar
        return ResponseEntity.ok(savedTool);
    }
}
