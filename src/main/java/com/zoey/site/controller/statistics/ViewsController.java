package com.zoey.site.controller.statistics;

import com.zoey.site.entity.po.content.Article;
import com.zoey.site.service.statistics.ViewsService;
import com.zoey.site.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @ClassName ViewsController
 * @author: Zoey He
 * @data: 2022-10-14 14:18
 * @Description 浏览量。设置定时任务，存储每天文章的浏览量
 */
@RestController("/statistics")
@Api(tags = "统计 - 浏览量")
public class ViewsController {
    @Autowired
    private ViewsService viewsService;

    @GetMapping("/views/get")
    @ApiOperation(value = "统计周浏览量", notes = "统计周浏览量")
    public Result<ArrayList<Integer>> get(LocalDateTime startTime, LocalDateTime endTime) {
        return Result.success(viewsService.get(startTime, endTime));
    }
}
