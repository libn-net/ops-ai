package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

import javax.annotation.PostConstruct;

/**
 * Created by libn on 2017/8/1.
 */
public class SpiderGet implements Spider {

  private volatile static SpiderGet instance;

  private SpiderGet() {
  }

  public static SpiderGet instance() {
    if (instance == null) {
      synchronized (SpiderGet.class) {
        if (instance == null) {
          instance = new SpiderGet();
          instance.register();
        }
      }
    }
    return instance;
  }

  @PostConstruct
  public void register() {
    SpiderHttpMethodObjectMapping.INSTANCE.putMapping("get", this);
  }

  @Override
  public SpiderResponse go(SpiderRequest request, SpiderEngine engine) {
    return engine.get(request);
  }
}
