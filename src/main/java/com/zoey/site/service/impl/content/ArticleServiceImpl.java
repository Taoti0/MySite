package com.zoey.site.service.impl.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zoey.site.entity.form.content.ArticleUpdateForm;
import com.zoey.site.entity.po.content.Article;
import com.zoey.site.exception.BaseException;
import com.zoey.site.exception.SystemErrorType;
import com.zoey.site.mapper.UserMapper;
import com.zoey.site.mapper.content.ArticleMapper;
import com.zoey.site.service.content.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Page<Article> selectPage(Page<Article> page, String userId) {
        return articleMapper.selectPage(page, new LambdaQueryWrapper<Article>()
                .eq(Article::getUserId, userId)
                .eq(Article::getDeleted, 0)
                .orderByDesc(Article::getUpdatedTime));
    }

    @Override
    public List<Article> getList(String userId) {
        return articleMapper.selectList(new LambdaQueryWrapper<Article>()
                .eq(Article::getUserId, userId)
                .eq(Article::getDeleted, 0)
                .orderByDesc(Article::getUpdatedTime));
    }

    @Override
    public boolean update(ArticleUpdateForm form) {
        Long id = form.getId();
        if (null == articleMapper.selectById(id))
            throw new BaseException(SystemErrorType.Article_NOT_EXIST);
        return  1 == articleMapper.updateArticle(form);
    }

    @Override
    public Article get(Long id) {
        Article article = articleMapper.selectById(id);
        if (1 == article.getDeleted())
            throw new BaseException(SystemErrorType.Article_NOT_EXIST);
        // 当天该文章的浏览量 + 1
        /* 这种频繁访问数据库的方式不是很好，鉴于可能没多少人会浏览网页，暂时先这么写，以后可等累计到一定数量，单独写接口存储 */
        article.setViews(article.getViews() + 1);
        articleMapper.updateById(article);
        return article;
    }
}
