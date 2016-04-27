package com.wechat.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import com.wechat.trans.Data;
import com.wechat.trans.Parts;
import com.wechat.trans.Symbols;
import com.wechat.trans.TransResult;

import net.sf.json.JSONObject;

/**
 * 微信工具类
 */
public class HttpUtil {

	/**
	 * ssl
	 */
	public static JSONObject customSSL(String url)
			throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom().build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse httpResponse = client.execute(httpget);
		HttpEntity entity = httpResponse.getEntity();
		JSONObject jsonObject = null;
		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpResponse.close();
		client.close();
		return jsonObject;
	}

	/**
	 * get请求
	 */
	public static JSONObject doGetStr(String url) throws ParseException, IOException {
		// 老版本DefaultHttpClient client = new DefaultHttpClient();
		CloseableHttpClient client = HttpClients.custom().build();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		CloseableHttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpResponse.close();
		client.close();
		return jsonObject;
	}

	/**
	 * post请求
	 */
	public static JSONObject doPostStr(String url, String outStr) throws ParseException, IOException {
		CloseableHttpClient client = HttpClients.custom().build();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr, "UTF-8"));
		CloseableHttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		jsonObject = JSONObject.fromObject(result);
		response.close();
		client.close();
		return jsonObject;
	}

	/**
	 * 文件上传
	 */
	public static String upload(String url, String filePath, String accessToken, String type)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		URL urlObj = new URL(url);

		// 连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 结尾部分
		// 定义最后数据分隔线
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");
		out.write(foot);
		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if ("thumb".equals(type)) {
			typeName = type + "_media_id";
		} else if ("image".equals(type)) {

		} else if ("voice".equals(type)) {

		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}

	/**
	 * 计算采用编码方式时字符串所占字节数:
	 * 采用ISO8859-1编码方式时，一个中/英文都只占一个字节；采用GB2312或GBK编码方式时，一个中文占两个字节；而采用UTF-8编码方式时，
	 * 一个中文占三个字节。
	 */
	public static int getByteSize(String content) {
		int size = 0;
		if (null != content) {
			try {
				// 汉字采用utf-8编码时占3个字节
				size = content.getBytes("utf-8").length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return size;
	}

	public static String translate(String source) throws ParseException, IOException {
		String url = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		String errno = jsonObject.getString("errno");
		Object obj = jsonObject.get("data");
		StringBuffer dst = new StringBuffer();
		if ("0".equals(errno) && !"[]".equals(obj.toString())) {
			TransResult transResult = (TransResult) JSONObject.toBean(jsonObject, TransResult.class);
			Data data = transResult.getData();
			Symbols symbols = data.getSymbols()[0];
			String phzh = symbols.getPh_zh() == null ? "" : "中文拼音：" + symbols.getPh_zh() + "\n";
			String phen = symbols.getPh_en() == null ? "" : "英式英标：" + symbols.getPh_en() + "\n";
			String pham = symbols.getPh_am() == null ? "" : "美式英标：" + symbols.getPh_am() + "\n";
			dst.append(phzh + phen + pham);

			Parts[] parts = symbols.getParts();
			String pat = null;
			for (Parts part : parts) {
				pat = (part.getPart() != null && !"".equals(part.getPart())) ? "[" + part.getPart() + "]" : "";
				String[] means = part.getMeans();
				dst.append(pat);
				for (String mean : means) {
					dst.append(mean + ";");
				}
			}
		} else {
			dst.append(translateFull(source));
		}
		return dst.toString();
	}

	public static String translateFull(String source) throws ParseException, IOException {
		String url = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		StringBuffer dst = new StringBuffer();
		List<Map> list = (List<Map>) jsonObject.get("trans_result");
		for (Map map : list) {
			dst.append(map.get("dst"));
		}
		return dst.toString();
	}
}
