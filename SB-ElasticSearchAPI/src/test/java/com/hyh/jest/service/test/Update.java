package com.hyh.jest.service.test;

//
// import java.util.List;
//
// import org.elasticsearch.search.builder.SearchSourceBuilder;
// import org.junit.Test;
//
// import com.hyh.utils.es.ESSearchOperatorUtil;
// import com.hyh.utils.es.ElasticSearchUtil;
//
/// **
// * 分页查找数据
// */
// public class Update {
// public static void main(String[] args) {
// SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
// searchSourceBuilder.from(0);
// searchSourceBuilder.size(6);
// List<CrawlData4PortalSite> list = new
// ESSearchOperatorUtil<CrawlData4PortalSite>().search4RetObj("conac_yuqing",
// "portals_web_data", searchSourceBuilder, CrawlData4PortalSite.class);
//
// for (CrawlData4PortalSite crawlData4PortalSite : list) {
// System.out.println(crawlData4PortalSite.getLab());
// }
// // crawlData4PortalSite.setLab(1);
// //
// // CrawlData4PortalSite crawlData4PortalSite = new
// // CrawlData4PortalSite();
// // new ElasticSearchHandler().createIndexResponse("conac_yuqing",
// // "portals_web_data", FastJsonUtil.getJson(crawlData4PortalSite));
// }
// }
