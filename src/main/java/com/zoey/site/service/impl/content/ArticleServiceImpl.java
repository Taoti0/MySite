package com.zoey.site.service.impl.content;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zoey.site.entity.form.content.ArticleForm;
import com.zoey.site.entity.po.content.Article;
import com.zoey.site.mapper.UserMapper;
import com.zoey.site.mapper.content.ArticleMapper;
import com.zoey.site.service.content.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ArticleServiceImpl
 * @author: Zoey He
 * @data: 2022-10-02 15:57
 * @Description TODO
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean add(Article article) {
        String author = userMapper.selectById(article.getUserId()).getUsername();
        article.setAuthor(author);
        return 1 == articleMapper.insert(article);
    }
}