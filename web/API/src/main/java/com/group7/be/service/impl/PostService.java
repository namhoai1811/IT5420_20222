package com.group7.be.service.impl;

import com.group7.be.advice.custom.ResourceNotFoundException;
import com.group7.be.dto.request.PostRequest;
import com.group7.be.dto.response.BaseResponse;
import com.group7.be.model.Post;
import com.group7.be.repository.IPostRepository;
import com.group7.be.service.IPostService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public BaseResponse<Post>save(PostRequest postRequest) {
        Post post = mapper.map(postRequest, Post.class);
        return BaseResponse.<Post> builder()
                .data(postRepository.save(post))
                .message("save success")
                .code(HttpStatus.OK.value())
                .build();
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public BaseResponse<Post> get(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("don't find post with id"));
        return BaseResponse.<Post> builder()
                .data(post)
                .message("get data success")
                .code(HttpStatus.OK.value())
                .build();
    }

    @Override
    public BaseResponse<Page<Post>> getAll(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Post> pages = postRepository.findAll(pageable);
        return BaseResponse.<Page<Post>> builder()
                .data(pages)
                .message("get data success")
                .code(HttpStatus.OK.value())
                .build();
    }

    @Override
    public BaseResponse<List<Post>> findByTitleLike(String title) {
//        logger.info(title);
//        List<Post> posts = postRepository.findByTitleLike(title);
//        return BaseResponse.<List<Post>> builder().data(posts).message("find data success").code(HttpStatus.OK.value()).build();
        return null;
    }

}
