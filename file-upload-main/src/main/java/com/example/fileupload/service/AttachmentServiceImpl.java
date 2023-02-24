package com.example.fileupload.service;

import com.example.fileupload.model.Attachment;
import com.example.fileupload.repository.AttachmentDao;
import com.example.fileupload.utils.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentDao attachmentDao;
    private final Logger LOG = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    public AttachmentServiceImpl(AttachmentDao attachmentDao) {
        this.attachmentDao = Assert.assertNotNull(attachmentDao, "Dao cannot be null");
    }

    /*
     * @Transactional - Spring creates a transaction around this method, if an exception is thrown, the
     * transaction will be rolled back, could also be at a Class level making every public method
     * transactional.
     */
    @Override
    @Transactional
    public Attachment save(Attachment attachment) {
        UUID id = UUID.randomUUID();
        LOG.debug("Service saving attachment with id {}:\n {}", id, attachment);
        return attachmentDao.save(attachment, id);
    }

    @Override
    @Transactional(readOnly = true)
    public byte[] getContent(UUID id) {
        LOG.debug("Service saving new attachment binary");
        return attachmentDao.getContent(id);
    }

    @Override
    @Transactional
    public Attachment update(byte[] content, UUID id) {
        Attachment oldAttachment = attachmentDao.getMetadata(id);
        LOG.debug("Service updating new attachment");
        return attachmentDao.update(id, content, oldAttachment);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        LOG.debug("Service deleting attachment with ID {}", id);
        attachmentDao.delete(id);
    }

    @Override
    @Transactional
    public List<Attachment> getAll() {
        LOG.debug("Service requesting all attachments");
        return attachmentDao.getAll();
    }

    @Override
    @Transactional
    public Attachment getMetadata(UUID id) {
        LOG.debug("Service requesting attachment metadata with ID {}", id);
        return attachmentDao.getMetadata(id);
    }
}
