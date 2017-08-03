package com.fxiaoke.dbcloud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by libn on 2017/8/1.
 */
@NoArgsConstructor
@Setter
@Getter
public class SpiderResponse {

  private SpiderRequest spiderRequest;
  private int code;
  private byte[] bytes;
  private String body;
  private boolean success;
  private String message;


}
