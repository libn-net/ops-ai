package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

/**
 * Created by libn on 2017/8/1.
 */
public interface Spider {

  SpiderResponse go(SpiderRequest request, SpiderEngine engine);

}
