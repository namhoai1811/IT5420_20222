package com.group7.be.service;

import com.group7.be.dto.request.PostRequest;
import com.group7.be.dto.response.BaseResponse;
import com.group7.be.model.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPostService {
    BaseResponse<Post> save(PostRequest post);
    void delete(Long id);
    BaseResponse<Post> get(Long id);
    BaseResponse<Page<Post>> getAll(int page, int limit);

    BaseResponse<List<Post>> findByTitleLike(String title);
}
