package com.example.inventory.controller;

import com.example.inventory.entity.Tool;
import com.example.inventory.service.ToolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor; // Lombok kullanacağız
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tools")
@RequiredArgsConstructor // Lombok, final alanlar için constructor oluşturur
public class ToolController {

    // final ile işaretledik, sadece constructor üzerinden set edilir
    private final ToolService toolService;


    @PostMapping("/save")// http://localhost:8080/api/tools/save  + JSON + POST
    public ResponseEntity<Tool> saveTool(@RequestBody @Valid Tool tool) {
        // Kullanıcıdan gelen JSON Tool objesine dönüşür
        // Service katmanına gönderilir
        Tool savedTool = toolService.saveTool(tool);
        // Service döndürür -> ResponseEntity ile kullanıcıya geri yollar
        return ResponseEntity.ok(savedTool);
    }


    // Tüm tool’ları getir
    @GetMapping("/getAll") // http://localhost:8080/api/tools/getAll
    public ResponseEntity<List<Tool>> getAllTools() {
        List<Tool> tools = toolService.getAllTools();
        return ResponseEntity.ok(tools);
    }

    // ID’ye göre tool getir
    @GetMapping("/getById/{id}") // http://localhost:8080/api/tools/getById/1
    public ResponseEntity<Tool> getToolById(@PathVariable Long id) {
        Tool tool = toolService.getToolById(id);
        return ResponseEntity.ok(tool);
    }


    @PutMapping("/update/{id}") // http://localhost:8080/api/tools/update/5
    public ResponseEntity<Tool> updateTool(
            @PathVariable Long id,          // URL’den id alır
            @RequestBody @Valid Tool tool) { // JSON body’den yeni değerleri alır

        // Servise yönlendiriyoruz
        Tool updatedTool = toolService.updateTool(id, tool);

        // Servisten dönen güncellenmiş Tool objesini ResponseEntity ile kullanıcıya döner
        return ResponseEntity.ok(updatedTool);
    }



    // Araç sil
    @DeleteMapping("/delete/{id}") // http://localhost:8080/api/tools/delete/1
    public ResponseEntity<String> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return ResponseEntity.ok("Tool successfully deleted");
    }

}
