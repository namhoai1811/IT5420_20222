package com.group7.be.dto.response;

import com.group7.be.model.Post;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostResponse {
    private int page;
    private int totalPage;
    private List<Post> posts;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
