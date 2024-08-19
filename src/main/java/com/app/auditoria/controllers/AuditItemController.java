package com.app.auditoria.controllers;

import com.app.auditoria.dtos.AuditItemRequestDto;
import com.app.auditoria.dtos.AuditItemUpdateDto;
import com.app.auditoria.models.AuditItem;
import com.app.auditoria.services.AuditItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auditoria")
@RequiredArgsConstructor
public class AuditItemController {

    private final AuditItemService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid AuditItemRequestDto requestDto) {
        var auditoriaModel = new AuditItem();
        BeanUtils.copyProperties(requestDto, auditoriaModel);
        service.save(auditoriaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully!");
    }
    @GetMapping("/get")
    public ResponseEntity<List<AuditItem>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @GetMapping("/find")
    public ResponseEntity<Object> find(@RequestParam(name = "id") int id) {
        Optional<AuditItem> auditItemOptional = service.findById(id);
        return auditItemOptional.
                <ResponseEntity<Object>>map(auditItem -> ResponseEntity.status(HttpStatus.OK)
                .body(auditItem))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Auditoria not found"));
    }
    @GetMapping("/find-romaneio")
    public ResponseEntity<Object> findByRomaneio(@RequestParam(name = "romaneio") String romaneio) {
        Optional<AuditItem> auditItemOptional = service.findByRomaneio(romaneio);
        return auditItemOptional.
                <ResponseEntity<Object>>map(auditItem -> ResponseEntity.status(HttpStatus.OK)
                .body(auditItem))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Auditoria not found"));
    }

    @PutMapping("/edit")
    public ResponseEntity<String> update(@RequestBody @Valid AuditItemUpdateDto updateDto) {
        Optional<AuditItem> auditItemOptional = service.findById(updateDto.id());
        if (auditItemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Auditoria not found");
        }

        var auditModel = new AuditItem();
        BeanUtils.copyProperties(updateDto, auditModel);
        auditModel.setId(auditItemOptional.get().getId());
        service.save(auditModel);
        return ResponseEntity.status(HttpStatus.OK).body("Updated auditoria successfully ");
    }
}
