package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderClient;
import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

/**
 * Created by libn on 2017/8/1.
 */
public interface SpiderEngine {

  SpiderClient client();

  SpiderResponse get(SpiderRequest request);

  SpiderResponse post(SpiderRequest request);

}
