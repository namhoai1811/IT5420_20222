package com.group7.be.controller;

import com.group7.be.dto.request.PostRequest;
import com.group7.be.dto.response.BaseResponse;
import com.group7.be.model.Post;
import com.group7.be.service.IPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping
    public ResponseEntity<BaseResponse<Post>> create(@RequestBody PostRequest post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.save(post));
    }
    @PutMapping
    public ResponseEntity<BaseResponse<Post>> update(@RequestBody PostRequest post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.save(post));
    }
    @GetMapping
    public ResponseEntity<BaseResponse<Page<Post>>> getAll(@RequestParam(name="page") int page,
                                                    @RequestParam(name = "limit") int limit) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAll(page, limit));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Post>> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.get(id));
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<Post>>> findByTitleLike(@RequestParam(name = "q") String query) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findByTitleLike(query));

    }
}
