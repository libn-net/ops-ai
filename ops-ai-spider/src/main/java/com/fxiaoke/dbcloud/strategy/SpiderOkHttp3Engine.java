package com.fxiaoke.dbcloud.strategy;

import com.fxiaoke.dbcloud.entity.SpiderClient;
import com.fxiaoke.dbcloud.entity.SpiderHeader;
import com.fxiaoke.dbcloud.entity.SpiderParameter;
import com.fxiaoke.dbcloud.entity.SpiderRequest;
import com.fxiaoke.dbcloud.entity.SpiderResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by libn on 2017/8/1.
 */
@Builder
public class SpiderOkHttp3Engine implements SpiderEngine {


  private Headers appendHeaders(SpiderRequest request) {
    List<SpiderHeader> headers = request.getHeaders();
    Headers.Builder headersBuilder = new Headers.Builder();
    if (headers != null && !headers.isEmpty()) {
      headers.forEach(spiderHeader -> headersBuilder.add(spiderHeader.getKey(), spiderHeader.getValue()));
    }
    return headersBuilder.build();
  }

  private HttpUrl appendUrlAndQueryString(SpiderRequest request) {
    String url = request.getUrl();
    List<SpiderParameter> parameters = request.getParameters();
    if (url != null && !url.isEmpty()) {
      if (!url.startsWith("http")) {
        url = "http://" + url;
      }
    }
    HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(url).newBuilder();
    if (parameters != null && !parameters.isEmpty()) {
      parameters.forEach(spiderParameter -> httpUrlBuilder.addQueryParameter(spiderParameter.getKey(), spiderParameter.getValue()));
    } else {
    }
    return httpUrlBuilder.build();
  }

  @Override
  public SpiderClient client() {
    return null;
  }

  @Override
  public SpiderResponse get(SpiderRequest request) {

    Headers appendHeaders = appendHeaders(request);
    HttpUrl appendUrlAndQueryString = appendUrlAndQueryString(request);

    OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();
    Request httpRequest = new Request.Builder().headers(appendHeaders).url(appendUrlAndQueryString).build();

    SpiderResponse spiderResponse = new SpiderResponse();
    try {
      Response response = client.newCall(httpRequest).execute();
      spiderResponse.setCode(response.code());
      if (response.isSuccessful()) {
        String body = response.body().string();
        spiderResponse.setBody(body);
        spiderResponse.setSuccess(Boolean.TRUE);
      } else {
        spiderResponse.setSuccess(Boolean.FALSE);
      }
    } catch (IOException e) {
      spiderResponse.setSuccess(Boolean.FALSE);
      spiderResponse.setMessage(e.getMessage());
    }
    return spiderResponse;
  }

  @Override
  public SpiderResponse post(SpiderRequest request) {
    return null;
  }
}
