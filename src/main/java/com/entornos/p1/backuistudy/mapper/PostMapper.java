package com.entornos.p1.backuistudy.mapper;

import com.entornos.p1.backuistudy.dto.PostDTO;
import com.entornos.p1.backuistudy.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "subject.name", target = "subjectName")
    @Mapping(source = "accessUrl", target = "accessUrl")
    @Mapping(source = "createdAt", target = "createdAt")
    PostDTO toPostDTO(Post post);

    Post toPost(PostDTO postDTO);
}
