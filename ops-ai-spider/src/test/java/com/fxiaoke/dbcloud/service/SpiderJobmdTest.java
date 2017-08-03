package com.fxiaoke.dbcloud.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangyuebin on 16/3/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpiderJobmdTest {

  private static OkHttpClient client = new OkHttpClient();


  @Before
  public void init() {
    //    client.setCookieHandler(newCookieManager(new PersistentCookieStore(), CookiePolicy.ACCEPT_ALL));
  }


  @Test
  public void testRun1() throws IOException {






    FormBody formBody = new FormBody.Builder().addEncoded("lang", "c")
                                              .addEncoded("action", "save")
                                              .addEncoded("from_domain", "i")
                                              .addEncoded("loginname", "781111280@qq.com")
                                              .addEncoded("password", "woaiqiu14")
                                              .addEncoded("verifycode", "save")
                                              .addEncoded("isread", "on")
                                              .build();

    Request request = new Request.Builder().url("https://login.51job.com/")
                                           .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
                                           .addHeader("Upgrade-Insecure-Requests", "1")
                                           .addHeader("Referer", "https://login.51job.com/")
                                           .addHeader("Origin", "https://login.51job.com")
                                           .addHeader("Host", "login.51job.com")
                                           .addHeader("Cookie", "guid=14919943821555220092; 51job=cenglish%3D0; ps=us%3DCTBSO1Q3Vn5UM186VS5QYQYwATVacgFlVmhSMwx6BDUBPQBiBWYDPFw0WzMLbVNpATAFMAYyBWkAelFiCGUCQAlCUkA%253D%26%7C%26")
                                           .addHeader("Content-Type", "application/x-www-form-urlencoded")
                                           .addHeader("Content-Length", "105")
                                           .addHeader("Connection", "keep-alive")
                                           .addHeader("Cache-Control", "max-age=0")
                                           .addHeader("Accept-Encoding:", "gzip, deflate, br")
                                           .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
                                           .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                                           .post(formBody)
                                           .build();

    Response response = client.newCall(request).execute();
    byte[] bytes = response.body().bytes();
    String result = new String(bytes, "gbk");
    System.out.println(result);
  }

}
