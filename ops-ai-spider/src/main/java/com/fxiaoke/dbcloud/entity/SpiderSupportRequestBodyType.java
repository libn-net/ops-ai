package com.fxiaoke.dbcloud.entity;

/**
 * Created by libn on 2017/7/31.
 */
public enum SpiderSupportRequestBodyType {

  FORM_DATA("form-data"), X_WWW_FORM_URLENCODED("x_www_form_urlencoded"), RAW("raw"), BINARY("binary");

  private String type;

  SpiderSupportRequestBodyType(String type) {
    this.type = type;
  }
}
