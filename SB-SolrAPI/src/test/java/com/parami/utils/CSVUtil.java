package com.parami.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.common.SolrInputDocument;

import com.sb.hyh.solr.utils.SolrUtil;

public class CSVUtil {

	/**
	 * 导出
	 */
	public static boolean exportCsv(File file, List<String> dataList) {
		boolean isSucess = false;
		FileOutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			out = new FileOutputStream(file);
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			if (dataList != null && !dataList.isEmpty()) {
				for (String data : dataList) {
					bw.append(data).append("\r");
				}
			}
			isSucess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSucess = false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (osw != null) {
				try {
					osw.close();
					osw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isSucess;
	}

	public static void importCsv(File file) {
		SolrUtil solrUtil = new SolrUtil("http://127.0.0.1:8080/solr/product");

		Collection<SolrInputDocument> docs = new LinkedList<SolrInputDocument>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			int count = 1;
			while ((line = br.readLine()) != null) {
				if (count != 1) {
					String[] strs = line.split(",");
					String id = strs[0];
					int price = Integer.valueOf(strs[1]);
					int saleNum = Integer.valueOf(strs[2]);
					int favNum = Integer.valueOf(strs[3]);
					String color = strs[4];
					int size = Integer.valueOf(strs[5]);
					int itemNum = Integer.valueOf(strs[6]);
					long created_at = Long.valueOf(strs[7]);
					float dsr = Float.valueOf(strs[8]);
					String tag = strs[9];

					SolrInputDocument doc = new SolrInputDocument();
					doc.addField("id", id, 1.0f);
					doc.addField("price", price, 1.0f);
					doc.addField("saleNum", saleNum, 1.0f);
					doc.addField("favNum", favNum, 1.0f);
					doc.addField("color", color, 1.0f);
					doc.addField("size", size, 1.0f);
					doc.addField("itemNum", itemNum, 1.0f);
					doc.addField("created_at", created_at, 1.0f);
					doc.addField("dsr", dsr, 1.0f);
					doc.addField("tag", tag, 1.0f);
					docs.add(doc);
				}

				if (count % 10000 == 0) {
					solrUtil.add(docs);
					docs = new LinkedList<SolrInputDocument>();
					System.out.println(count);
				}

				count++;
			}

			if (docs.size() != 0) {
				solrUtil.add(docs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}