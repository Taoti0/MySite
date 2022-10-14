package com.zoey.site.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zoey.site.entity.form.content.ArticleForm;
import com.zoey.site.entity.form.content.ArticleUpdateForm;
import com.zoey.site.entity.po.content.Article;
import com.zoey.site.service.content.ArticleService;
import com.zoey.site.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ArticleController
 * @author: Zoey He
 * @data: 2022-10-02 13:21
 * @Description 内容 - 文章管理
 */
@RestController("/content")
@Api(tags = "内容 - 文章管理")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/add")
    @ApiOperation(value = "新增文章", notes = "新增文章")
    public Result<Boolean> add(@RequestBody ArticleForm form) {
        return Result.success(articleService.add(form.toPo(Article.class)));
    }

    @GetMapping("/article/page")
    @ApiOperation(value = "获取所有文章", notes = "获取所有文章 page")
    public Result<IPage<Article>> page(String userId, Integer currentPage, Integer pageSize) {
        Page<Article> page = new Page<>(currentPage, pageSize);
        page = articleService.selectPage(page, userId);
        return Result.success(page);
    }

    @GetMapping("/article/list")
    @ApiOperation(value = "获取所有文章", notes = "获取所有文章 list")
    public Result<List<Article>> list(String userId){
        return Result.success(articleService.getList(userId));
    }

    @GetMapping("/article/get")
    @ApiOperation(value = "获取指定文章", notes = "获取指定文章")
    public Result<Article> get(Long id){
        return Result.success(articleService.get(id));
    }

    @PostMapping("/article/update")
    @ApiOperation(value = "修改文章", notes = "修改文章")
    public Result<Boolean> update(@RequestBody ArticleUpdateForm form) {
        return Result.success(articleService.update(form));
    }

    @DeleteMapping("/article/remove")
    @ApiOperation(value = "删除指定文章", notes = "删除指定文章")
    public Result<Boolean> remove(Long id) {
        return Result.success(articleService.removeById(id));
    }
}
