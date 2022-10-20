package com.zoey.site.service.impl.statistics;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zoey.site.entity.po.statistics.Views;
import com.zoey.site.mapper.statistics.ViewsMapper;
import com.zoey.site.service.statistics.ViewsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @ClassName ViewsServiceImpl
 * @author: Zoey He
 * @data: 2022-10-14 14:50
 * @Description TODO
 */

@Service
public class ViewsServiceImpl extends ServiceImpl<ViewsMapper, Views> implements ViewsService {
    @Override
    public ArrayList<Integer> get(LocalDateTime startTime, LocalDateTime endTime) {
        return null;
    }
}
