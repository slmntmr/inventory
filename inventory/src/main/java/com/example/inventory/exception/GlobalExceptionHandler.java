package com.example.inventory.exception; // Bu sınıf exception paketinde yer alacak

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice -> Bu anotasyon sayesinde, tüm Controller sınıflarında oluşan hataları yakalar
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler -> Belirli tipteki hataları yakalamak için kullanılır
    // Burada IllegalArgumentException tipindeki hataları yakalayacağız
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        // ex.getMessage() -> hata fırlatıldığında yazdığımız mesaj (örn: "Miktar negatif olamaz")
        // ResponseEntity.badRequest() -> HTTP 400 (Bad Request) döndürür
        // .body(ex.getMessage()) -> cevabın gövdesine sadece mesajı koyar
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // İstersen farklı tipte hatalar için başka metotlar da ekleyebiliriz.
    // Örn: RuntimeException, NullPointerException, CustomException...
}
