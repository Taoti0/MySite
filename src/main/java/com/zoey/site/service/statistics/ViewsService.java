package com.zoey.site.service.statistics;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zoey.site.entity.po.statistics.Views;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ViewsService extends IService<Views> {
    ArrayList<Integer> get(LocalDateTime startTime, LocalDateTime endTime);
}
