package com.linchaokun.controller;

import com.linchaokun.utils.DouyinVideoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by linchaokun on 2018/5/24.
 */
@Controller
public class DouYinController {

    @GetMapping("/")
    public ModelAndView list(String videoUrl, Map<String, Object> map) {
        if(!StringUtils.isEmpty(videoUrl)){
            videoUrl = DouyinVideoUtil.douyin(videoUrl);

        }else {
            videoUrl = "暂无视频";
        }

        map.put("videoUrl",videoUrl);
        return new ModelAndView("douyin",map);
    }


}
