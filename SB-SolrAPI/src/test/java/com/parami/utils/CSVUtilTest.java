package com.parami.utils;

import java.io.File;

public class CSVUtilTest {
	public static void main(String[] args) {
		CSVUtil.importCsv(new File("solr_data.csv"));
	}
}
