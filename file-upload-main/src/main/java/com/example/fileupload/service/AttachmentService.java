package com.example.fileupload.service;

import com.example.fileupload.model.Attachment;

import java.util.List;
import java.util.UUID;

public interface AttachmentService {

    Attachment save(Attachment attachment);

    byte[] getContent(UUID id);

    Attachment update(byte[] content, UUID id);

    void delete(UUID id);

    List<Attachment> getAll();

    Attachment getMetadata(UUID id);
}
