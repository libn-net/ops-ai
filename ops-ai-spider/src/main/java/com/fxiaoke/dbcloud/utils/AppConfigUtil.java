package com.fxiaoke.dbcloud.utils;

import com.github.autoconf.ConfigFactory;
import com.github.autoconf.api.IChangeListener;
import com.github.autoconf.api.IConfig;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * Created by libn on 2016/9/6.
 */
@Slf4j
public class AppConfigUtil {

    private static Map<String, String> configMap = null;

    /**
     * 获取配置信息
     */
    public static Map<String, String> getConfigMap() {
        // 获取配置中心的数据
        ConfigFactory.getInstance().getConfig("fs-db-cloud", new IChangeListener() {
            @Override
            public void changed(IConfig iConfig) {
                configMap = iConfig.getAll();
            }
        });
        return configMap;
    }

    /**
     * 获取配置中心数据
     */
    public static String get(String key) {
        if (configMap == null) {
            getConfigMap();
        }
        return configMap.get(key);
    }

    public static Integer getInt(String key) {
        if (configMap == null) {
            getConfigMap();
        }

        Integer rst = null;
        String val = configMap.get(key);
        if (val != null && !val.isEmpty()) {
            try {
                rst = Integer.valueOf(val);
            } catch (Exception e) {
                log.error("Con not convert value when use 'Integer.valueOf'", e);
            }
        }

        return rst;
    }

}

