package com.csot.csotoa.config;

import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 模板ID的配置类
 * 对应的模板ID 都是实现了移动端能访问的流程
 * Created by hank.he on 2017/7/20.
 */
@Component
@Configuration
@PropertySource("classpath:templateConfig-${spring.profiles.active}.properties")
public class TemplateDateUtil {
    private static final Logger logger = LoggerFactory.getLogger(TemplateDateUtil.class);

    @Value("${mobile.templateList}")
    private String templateDateList;

    /**
     * 处理配置文件中的模板ID
     *
     * @return
     * @author hank.he
     * @date ${date}
     */
    public Map<String, String> getTemplateOfMobile() {
        String[] templateList = templateDateList.split(",");
        Map<String, String> templateMap = new HashMap<>();
        for (String templateId : templateList) {
            if (templateMap.containsKey(templateId)) {
                continue;
            }
            templateMap.put(templateId, templateId);
        }
        return templateMap;
    }

    /**
     * 判断templateId是否在配置文件中存在
     *
     * @param templateId
     * @return turn or false
     * @author hank.he
     */
    public boolean checkTemplate(String templateId) {
        if (StringUtil.isBlank(templateId)) {
            return false;
        }
        Map<String, String> templateMap = this.getTemplateOfMobile();
        if (templateMap.containsKey(templateId)) {
            return true;
        }
        return false;
    }

}
