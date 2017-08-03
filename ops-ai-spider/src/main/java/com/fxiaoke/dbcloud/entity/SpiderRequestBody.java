package com.fxiaoke.dbcloud.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by libn on 2017/7/31.
 */
@Getter
@Setter
@NoArgsConstructor
public class SpiderRequestBody {

  private String type;
  private List<SpiderRequestFormData> requestFormData;
  private String raw;
  private Byte[] binary;
  private String contentType;

}
