package com.zoey.site.entity.form.content;

import com.zoey.site.entity.form.BaseForm;
import com.zoey.site.entity.po.content.Article;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ArticleForm
 * @author: Zoey He
 * @data: 2022-10-02 13:24
 * @Description 新增文章表单
 */
@Data
@ApiModel(description = "新增文章表单")
public class ArticleForm extends BaseForm<Article> {
    @NotNull
    @ApiParam(name = "作者ID", required = true)
    private Long userId;

    @NotBlank
    @ApiParam(name = "标题", required = true)
    private String title;

    @NotBlank
    @ApiParam(name = "文章正文", required = true)
    private String content;

    @ApiParam(name = "文章分类, 两位: 一号位 {1: 原创, 2: 转载}, 二号位{0: 技术, 1: 游戏, 2: 旅行, 3: 其他}")
    private int category;

    @ApiParam(name = "文章标签")
    private String label;
}
