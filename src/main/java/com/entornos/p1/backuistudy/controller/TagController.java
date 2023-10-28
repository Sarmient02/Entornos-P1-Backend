package com.entornos.p1.backuistudy.controller;

import com.entornos.p1.backuistudy.model.Tag;
import com.entornos.p1.backuistudy.service.interfaces.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController {

    private ITagService tagService;

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> getAll() {
        var response =  this.tagService.getAll();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteTag(@RequestParam Long tagId) {
        var response = this.tagService.deleteTag(tagId);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Autowired
    public void setTagService(@Qualifier("tagServiceImpl") ITagService tagService) {
        this.tagService = tagService;
    }
}
