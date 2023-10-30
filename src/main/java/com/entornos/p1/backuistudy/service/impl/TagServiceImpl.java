package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.model.Tag;
import com.entornos.p1.backuistudy.repository.ITagRepository;
import com.entornos.p1.backuistudy.service.interfaces.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements ITagService {

    private ITagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return this.tagRepository.findAll();
    }

    @Override
    public Boolean deleteTag(Long tagId) {
        this.tagRepository.deleteById(tagId);
        return true;
    }

    @Override
    public Boolean newTag(Tag newTag) {
        var exists = this.tagRepository.findTopByName(newTag.getName());
        if (exists != null) {
            return false;
        }
        this.tagRepository.save(newTag);
        return true;
    }

    @Override
    public Boolean editTag(Tag editTag) {
        var exists = this.tagRepository.findById(editTag.getId());
        if (exists.isEmpty()) {
            return false;
        }
        this.tagRepository.save(editTag);
        return true;
    }

    @Autowired
    public void setTagRepository(ITagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
}
