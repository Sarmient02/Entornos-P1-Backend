package com.entornos.p1.backuistudy.service.impl;

import com.entornos.p1.backuistudy.dto.PostDTO;
import com.entornos.p1.backuistudy.model.Post;
import com.entornos.p1.backuistudy.repository.IPostRepository;
import com.entornos.p1.backuistudy.repository.ISubjectRepository;
import com.entornos.p1.backuistudy.repository.IUserRepository;
import com.entornos.p1.backuistudy.service.interfaces.IPostService;
import com.entornos.p1.backuistudy.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private IPostRepository postRepository;

    private IUserRepository userRepository;

    private ISubjectRepository subjectRepository;



    @Override
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> getByPostTitle(String title) {
        return this.postRepository.findByTitleLike(title);
    }


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

    @Override
    public Boolean newPost(Post newPost) {
        var user = this.userRepository.findById(newPost.getUserId());
        var subject = this.subjectRepository.findById(newPost.getSubjectId());
        if (user.isEmpty() || subject.isEmpty()) {
            return false;
        }
        newPost.setCreatedAt(new Date());

        this.postRepository.save(newPost);
        return true;
    }

    @Override
    public Boolean editPost(Post post) {
        var postToEdit = this.postRepository.findById(post.getId());
        if (postToEdit.isEmpty() || !Objects.equals(postToEdit.get().getUserId(), post.getUserId())) {
            return false;
        }
        this.postRepository.save(post);
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

    @Autowired
    public void setSubjectRepository(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
}
