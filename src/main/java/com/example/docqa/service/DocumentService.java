package com.example.docqa.service;

import com.example.docqa.entity.Document;
import com.example.docqa.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Async
    public CompletableFuture<Void> uploadDocument(MultipartFile file, String author, String type) throws IOException {
        String content = new String(file.getBytes());
        Document doc = new Document();
        doc.setTitle(file.getOriginalFilename());
        doc.setAuthor(author);
        doc.setType(type);
        doc.setUploadDate(LocalDate.now());
        doc.setContent(content);
        documentRepository.save(doc);
        return CompletableFuture.completedFuture(null);
    }

    public List<Document> searchByKeyword(String keyword) {
        return documentRepository.findByContentContainingIgnoreCase(keyword);
    }

    public List<Document> filterByMetadata(String author, String type) {
        if (author != null && type != null) {
            return documentRepository.findByAuthorIgnoreCase(author)
                    .stream()
                    .filter(d -> d.getType().equalsIgnoreCase(type)).toList();
        } else if (author != null) {
            return documentRepository.findByAuthorIgnoreCase(author);
        } else if (type != null) {
            return documentRepository.findByType(type);
        }
        return documentRepository.findAll();
    }
}
