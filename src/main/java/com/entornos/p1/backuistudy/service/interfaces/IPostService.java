package com.entornos.p1.backuistudy.service.interfaces;

import com.entornos.p1.backuistudy.dto.PostDTO;
import com.entornos.p1.backuistudy.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPostService {

    List<Post> getAll();

    List<Post> getByPostTitle(String title);

    //Boolean newPost(PostDTO newPost);

    Boolean deletePost(Long id, Long userId);

    Boolean newPost(Post newPost);

    Boolean editPost(Post post);
}
