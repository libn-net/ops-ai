package com.fxiaoke.dbcloud.service;

import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;
import com.fxiaoke.dbcloud.strategy.Spider;
import com.fxiaoke.dbcloud.strategy.SpiderHttpMethodObjectMapping;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hanmz on 2016/8/29.
 */
@Slf4j
@Service
public class HttpToolService {

  //    @Autowired
  //    private AppLogMapper appLogMapper;

  public SpiderResponse send(SpiderRequest spiderRequest) {

    String method = spiderRequest.getMethod();
    if (method == null || method.isEmpty()) {
      method = "get";
    }
    Spider spider = SpiderHttpMethodObjectMapping.INSTANCE.getMapping(method);
    if (spider == null) {
      throw new RuntimeException("unsupported method : " + method);
    }
    return null;
  }
}
