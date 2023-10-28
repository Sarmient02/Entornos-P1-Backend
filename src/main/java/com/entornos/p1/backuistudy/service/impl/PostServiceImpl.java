package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.dto.PostDTO;
import com.entornos.p1.backuistudy.model.Post;
import com.entornos.p1.backuistudy.repository.IPostRepository;
import com.entornos.p1.backuistudy.repository.IUserRepository;
import com.entornos.p1.backuistudy.service.interfaces.IPostService;
import com.entornos.p1.backuistudy.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private IPostRepository postRepository;

    private IUserRepository userRepository;


    @Override
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getByPostTitle(String title) {
        return this.postRepository.findByTitleLike(title);
    }

    /*@Override
    public Boolean newPost(PostDTO newPost) {
        Post toSave =
        return this.postRepository.save()
    }*/

    @Override
    public Boolean deletePost(Long id, Long userId) {
        var user = this.userRepository.findById(userId);
        var post = this.postRepository.findById(id);
        if (user.isEmpty() || (post.isPresent() && !Objects.equals(post.get().getUser().getId(), user.get().getId()))) {
            return false;
        }

        this.postRepository.deleteById(id);
        return true;
    }

    @Autowired
    public void setPostRepository(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
