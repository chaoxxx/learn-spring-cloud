package com.chao.util.http;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String getForRest(String param, String url) {
		StringBuilder uriParam = new StringBuilder();
		uriParam.append("/").append(param);
		return get(url, uriParam);
	}

	private static String get(String url, StringBuilder uriParam) {
		CloseableHttpClient httpClient = (CloseableHttpClient) HttpClients.createDefault();

		String uri = url + uriParam.toString();

		logger.info("http get data from {}", uri);

		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = null;
		String result = null;
		try {
			response = (CloseableHttpResponse) httpClient.execute(get);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				result = entityToString(entity);
			} else {
				logger.warn(" http method get response error!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("http get data {}", result);
		return result;
	}

	public static String get(Map<String, String> param, String url) {
		CloseableHttpClient httpClient = (CloseableHttpClient) HttpClients.createDefault();
		StringBuilder uriParam = new StringBuilder();
		uriParam.append("?");
		for (Map.Entry e : param.entrySet()) {
			String key = (String) e.getKey();
			String value = (String) e.getValue();
			if (logger.isDebugEnabled()) {
				logger.debug(" http method get param key {},value {}", key, value);
			}
			uriParam.append(key).append("=").append(value).append("&");
		}

		String uri = url + uriParam.toString();

		logger.info("http get data from {}", uri);

		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = null;
		String result = null;
		try {
			response = (CloseableHttpResponse) httpClient.execute(get);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				result = entityToString(entity);
			} else {
				logger.warn(" http method get response error!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("http get data {}", result);
		return result;

	}

	private static String entityToString(HttpEntity entity) throws IOException {
		String result = null;
		if (entity != null) {
			long lenth = entity.getContentLength();
			if (lenth != -1 && lenth < 2048) {
				result = EntityUtils.toString(entity, "UTF-8");
			} else {
				InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
				CharArrayBuffer buffer = new CharArrayBuffer(2048);
				char[] tmp = new char[1024];
				int l;
				while ((l = reader1.read(tmp)) != -1) {
					buffer.append(tmp, 0, l);
				}
				result = buffer.toString();
			}
		}
		return result;
	}

}
