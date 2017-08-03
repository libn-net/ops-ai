package com.fxiaoke.dbcloud.utils;

import com.google.common.collect.Lists;
import okhttp3.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {
  public static final OkHttpClient CLIENT = new OkHttpClient.Builder()
    .connectTimeout(6, TimeUnit.SECONDS)
    .readTimeout(1, TimeUnit.MINUTES)
    .build();

  private OkHttpUtil() {
  }

  /**
   * 该请求不会开启异步线程。
   *
   * @param request 请求
   * @return 响应对象
   * @throws IOException
   */
  public static Response execute(Request request) throws IOException {
    return CLIENT.newCall(request).execute();
  }

  /**
   * 开启异步线程访问网络
   *
   * @param request          网络请求
   * @param responseCallback 异步响应回调
   */
  public static void enqueue(Request request, Callback responseCallback) {
    CLIENT.newCall(request).enqueue(responseCallback);
  }

  /**
   * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
   *
   * @param request 网络请求
   */
  public static void sendOnly(Request request) {
    CLIENT.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
      }
    });
  }

  /**
   * 获取一个url对应的内容
   *
   * @param url url
   * @return
   * @throws IOException
   */
  public static String getContent(String url) throws IOException {
    Request request = new Request.Builder().url(url).build();
    Response response = execute(request);
    if (response.isSuccessful()) {
      return response.body().string();
    } else {
      throw new IOException("Unexpected code " + response);
    }
  }

  /**
   * 这里使用了HttpClinet的API。只是为了方便
   *
   * @param params 请求参数
   * @return
   */
  public static String formatParams(List<BasicNameValuePair> params) {
    return URLEncodedUtils.format(params, "UTF-8");
  }

  /**
   * 为HttpGet 的 url 方便的添加多个name value 参数。
   *
   * @param url    url
   * @param params 参数对
   * @return
   */
  public static String appendParams(String url, List<BasicNameValuePair> params) {
    return url + '?' + formatParams(params);
  }

  /**
   * 为HttpGet 的 url 方便的添加1个name value 参数。
   *
   * @param url   url
   * @param name  参数名
   * @param value 参数值
   * @return
   */
  public static String appendParam(String url, String name, String value) {
    return appendParams(url, Lists.newArrayList(new BasicNameValuePair(name, value)));
  }
}
