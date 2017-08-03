package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by libn on 2017/8/1.
 */

@NoArgsConstructor
@Builder
public class SpiderEngineContext {

  private SpiderEngine spiderEngine;

  public SpiderEngineContext(SpiderEngine spiderEngine) {
    this.spiderEngine = spiderEngine;
  }

  public SpiderResponse execute(SpiderRequest request) {
    Spider spider = SpiderHttpMethodObjectMapping.INSTANCE.getMapping("get");
    return spider.go(request, spiderEngine);
  }

}
