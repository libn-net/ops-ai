package com.fxiaoke.dbcloud.strategy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by libn on 2017/8/1.
 */
public enum SpiderHttpMethodObjectMapping {

  INSTANCE;
  private Map<String, Spider> methodMapping = Maps.newHashMap();

  public void putMapping(String method, Spider spider) {
    this.methodMapping.put(method, spider);
  }

  public Spider getMapping(String method) {
    return this.methodMapping.get(method);
  }

  public SpiderHttpMethodObjectMapping instance() {
    return INSTANCE;
  }

}
