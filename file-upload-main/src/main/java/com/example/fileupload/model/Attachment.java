package com.example.fileupload.model;

import java.util.UUID;

/*
*  The Attachment class represents a way to represent & manipulate attachments,
*  two constructors, one that takes all fields as arguments, another one that
*  takes only the non-content fields. If  a content array is passed to the
*  constructor, it checks if its length matches the specified size and throws an
*  IllegalArgumentException if not.
*
*  This class also provides a "from" method that takes an existing Attachment
*  object and new content array, creates a new Attachment object with the same
*  non-content fields as the existing object and sets the content to the new
*  content array.
* */

/**
 * Perhaps UUID can be replaced long IDs. UUIDs are 128 bit values,
 * whereas long IDs are 64 bit, are generally faster to generate and
 * index compared to UUIDs.
 *
 */
public class Attachment {
    private UUID id;
    private String name;
    private long size;
    private String type;
    private long crc;
    private byte[] content;

    public Attachment() {}

    public Attachment(UUID id, String name, long size, String type, long crc, byte[] content) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.type = type;
        this.crc = crc;
        if (content != null && content.length != size) {
            throw new IllegalArgumentException("Length of the content array does not match the size");
        }
        this.content = content;
    }

    public Attachment(UUID id, String name, long size, String type, long crc) {
        super();
        this.id = id;
        this.name = name;
        this.size = size;
        this.type = type;
        this.crc = crc;
    }

    public static Attachment from(Attachment attachment, byte[] content) {
        Attachment newAttachment = new Attachment();
        newAttachment.setId(attachment.getId());
        newAttachment.setName(attachment.getName());
        newAttachment.setSize(attachment.getSize());
        newAttachment.setType(attachment.getType());
        newAttachment.setCrc(attachment.getCrc());
        newAttachment.setContent(content);
        return newAttachment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCrc() {
        return crc;
    }

    public void setCrc(long crc) {
        this.crc = crc;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
