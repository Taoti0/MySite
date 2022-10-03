package com.zoey.site.entity.po.content;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zoey.site.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Article
 * @author: Zoey He
 * @data: 2022-10-02 15:58
 * @Description TODO
 */
@Data
@TableName("content_article")
@ApiModel(value = "博客文章", description = "博客文章表")
public class Article extends BasePo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private Long userId;
    @TableField("author")
    private String author;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("category")
    private int category;
    @TableField("label")
    private String label;
    @TableLogic("deleted")
    private Byte deleted;
}
