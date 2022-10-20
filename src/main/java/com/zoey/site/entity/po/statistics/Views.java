package com.zoey.site.entity.po.statistics;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zoey.site.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Views
 * @author: Zoey He
 * @data: 2022-10-14 14:39
 * @Description 浏览量
 */
@Data
@TableName("content_article")
@ApiModel(value = "文章浏览量", description = "文章浏览量")
public class Views extends BasePo implements Serializable {
    private static final long serialVersionUID = 1L;
}
