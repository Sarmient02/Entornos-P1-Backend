package com.entornos.p1.backuistudy.service.interfaces;

import com.entornos.p1.backuistudy.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITagService {

    List<Tag> getAll();

    Boolean deleteTag(Long id);


}
