package com.it.rpc.server;

import com.it.rpc.entity.Blog;

public interface BlogService {
    Blog getBlogById(Integer id);
}
