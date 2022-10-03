package com.zoey.site.controller.content;

import com.zoey.site.entity.form.content.ArticleForm;
import com.zoey.site.entity.po.content.Article;
import com.zoey.site.service.content.ArticleService;
import com.zoey.site.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ArticleController
 * @author: Zoey He
 * @data: 2022-10-02 13:21
 * @Description TODO
 */
@RestController("/content/article")
@Api(tags = "内容 - 文章管理")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    @ApiOperation(value = "新增文章", notes = "新增文章")
    public Result<Boolean> add(@RequestBody ArticleForm form){
        return Result.success(articleService.add(form.toPo(Article.class)));
    }
}
