package com.entornos.p1.backuistudy.controller;

import com.entornos.p1.backuistudy.dto.PostDTO;
import com.entornos.p1.backuistudy.service.interfaces.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private IPostService postService;

    @GetMapping("/all")
    public Object getAll() {
        var postList = this.postService.getAll();

        return (postList == null || postList.isEmpty()) ? ResponseEntity.ok(postList) : ResponseEntity.noContent();
    }

    @GetMapping("/getByTitle")
    public Object getByTitle(@RequestParam(value = "title") String title) {
        var postList = this.postService.getByPostTitle(title);

        return (postList==null || postList.isEmpty()) ? ResponseEntity.ok(postList) : ResponseEntity.noContent();
    }

    /*@PostMapping()
    public ResponseEntity<Boolean> newPost(@RequestBody PostDTO newPost) {
        var response = this.postService.newPost(newPost);

        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }*/

    @DeleteMapping()
    public ResponseEntity<Boolean> deletePost(@RequestParam Long id, @RequestParam Long userId) {
        var response = this.postService.deletePost(id, userId);

        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }


    @Autowired
    public void setPostService(@Qualifier("postServiceImpl") IPostService postService) {
        this.postService = postService;
    }

}
