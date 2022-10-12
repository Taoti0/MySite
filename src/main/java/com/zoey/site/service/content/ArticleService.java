package com.zoey.site.service.content;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zoey.site.entity.form.content.ArticleUpdateForm;
import com.zoey.site.entity.po.content.Article;

import java.util.List;

public interface ArticleService extends IService<Article> {
    boolean add(Article article);

    Page<Article> selectPage(Page<Article> page, String userId);

    List<Article> getList(String userId);

    boolean update(ArticleUpdateForm form);

    Article get(Long id);
}
