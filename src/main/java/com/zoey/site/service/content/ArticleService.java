package com.zoey.site.service.content;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zoey.site.entity.po.content.Article;

public interface ArticleService extends IService<Article> {
    boolean add(Article article);
}
