package com.zoey.site.mapper.content;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zoey.site.entity.form.content.ArticleUpdateForm;
import com.zoey.site.entity.po.content.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends BaseMapper<Article> {
    int updateArticle(@Param("param") ArticleUpdateForm form);
}
