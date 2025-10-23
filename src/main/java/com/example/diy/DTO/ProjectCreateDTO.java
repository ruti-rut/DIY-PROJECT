package com.example.diy.DTO;

import com.example.diy.model.Challenge;
import com.example.diy.model.Step;
import com.example.diy.model.Tag;

import java.util.List;

public class ProjectCreateDTO {
    private CategoryDTO category;
    private Challenge challenge;
    private List<Step> steps;
    private List<Tag> tags;
    private String materials;
    private String title;
    private String ages;
    private String timePrep;
    private String picture;
    private String description;
    private boolean isDraft;

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getTimePrep() {
        return timePrep;
    }

    public void setTimePrep(String timePrep) {
        this.timePrep = timePrep;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }
}
