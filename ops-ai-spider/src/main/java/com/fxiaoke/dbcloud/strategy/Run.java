package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

/**
 * Created by libn on 2017/8/1.
 */
public class Run {

  public static void main(String[] args) {

    SpiderGet spiderGet = SpiderGet.instance();
    SpiderEngineContext context = SpiderEngineContext.builder().spiderEngine(SpiderOkHttp3Engine.builder().build()).build();
    SpiderRequest request = SpiderRequest.builder().method("get").url("http://cantellow.iteye.com/blog/838473").build();
    SpiderResponse response = context.execute(request);
    System.out.println(response.getBody());


  }
}
