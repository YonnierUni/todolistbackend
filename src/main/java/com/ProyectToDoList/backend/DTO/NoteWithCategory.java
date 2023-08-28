package com.ProyectToDoList.backend.DTO;

import java.util.Date;
import java.util.List;

public class NoteWithCategory {
    private Long id;
    private String title;
    private String content;
    private Date createDate;
    private Date modifyDate;
    private boolean isArchived;
    private List<CategoryBasicDataDTO> categories;
    private UserDTO user;


    public NoteWithCategory(Long id, String title, String content, Date createDate, Date modifyDate, boolean isArchived, List<CategoryBasicDataDTO> categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.isArchived = isArchived;
        this.categories = categories;
    }

    public NoteWithCategory(Long id, String title, String content, boolean isArchived, List<CategoryBasicDataDTO> categories, UserDTO user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isArchived = isArchived;
        this.categories = categories;
        this.user = user;
    }

    public NoteWithCategory(Long id, String title, String content, Date createDate, Date modifyDate, boolean isArchived, List<CategoryBasicDataDTO> categories, UserDTO user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.isArchived = isArchived;
        this.categories = categories;
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public List<CategoryBasicDataDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBasicDataDTO> categories) {
        this.categories = categories;
    }
}
