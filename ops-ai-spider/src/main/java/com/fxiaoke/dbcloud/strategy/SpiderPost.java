package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

import javax.annotation.PostConstruct;

/**
 * Created by libn on 2017/8/1.
 */
public class SpiderPost implements Spider {


  @PostConstruct
  public void register() {
    SpiderHttpMethodObjectMapping.INSTANCE.putMapping("post", this);
  }


  @Override
  public SpiderResponse go(SpiderRequest request, SpiderEngine engine) {
    return engine.post(request);
  }
}
