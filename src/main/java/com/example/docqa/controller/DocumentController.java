package com.example.docqa.controller;

import com.example.docqa.entity.Document;
import com.example.docqa.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam String author,
            @RequestParam String type) throws IOException {
        CompletableFuture<Void> future = documentService.uploadDocument(file, author, type);
        return ResponseEntity.ok("Document uploaded successfully.");
    }

    @GetMapping("/search")
    public List<Document> searchDocuments(@RequestParam String keyword) {
        return documentService.searchByKeyword(keyword);
    }

    @GetMapping
    public List<Document> filterDocuments(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String type) {
        return documentService.filterByMetadata(author, type);
    }
}
