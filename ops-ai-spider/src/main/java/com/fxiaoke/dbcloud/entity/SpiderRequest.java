package com.fxiaoke.dbcloud.entity;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpiderRequest {
  private String scheme;
  private String method;
  private String url;
  private List<SpiderParameter> parameters;
  private List<SpiderHeader> headers;
  private SpiderRequestBody requestBody;
}
