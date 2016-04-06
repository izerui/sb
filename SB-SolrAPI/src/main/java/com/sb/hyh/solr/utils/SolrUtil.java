package com.sb.hyh.solr.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.sb.hyh.entity.User;

public class SolrUtil {
    private static HttpSolrClient httpSolrClient;
    private static int connectionTimeout = 60000;
    private static int soTimeout = 60000;
    private static int defaultMaxCOnnectionPerhost = 100;
    private static int maxTotalConnections = 100;
    private static boolean followRedirects = false;
    private static boolean allowCompression = true;
    private static int maxRetries = 1;

    public SolrUtil(String url) {
        httpSolrClient = new HttpSolrClient(url);
        httpSolrClient.setConnectionTimeout(connectionTimeout);
        httpSolrClient.setSoTimeout(soTimeout);
        httpSolrClient.setDefaultMaxConnectionsPerHost(defaultMaxCOnnectionPerhost);
        httpSolrClient.setMaxTotalConnections(maxTotalConnections);
        httpSolrClient.setFollowRedirects(followRedirects);
        httpSolrClient.setAllowCompression(allowCompression);
        httpSolrClient.setMaxRetries(maxRetries);
    }

    public void add(Collection<SolrInputDocument> docs) {
        try {
            httpSolrClient.add(docs);
            // 提交到索引中,不会出现在搜索结果中
            httpSolrClient.commit();

            // 快速提交commit
            // UpdateRequest req = new UpdateRequest();
            // req.setAction(UpdateRequest.ACTION.COMMIT, false, false);
            // req.add(docs);
            // req.process(httpSolrClient);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBean(Object... objs) {
        try {
            httpSolrClient.addBean(objs);
            httpSolrClient.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(String id) {
        try {
            httpSolrClient.deleteById(id);
            httpSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteByIdList(List<String> idList) {
        try {
            httpSolrClient.deleteById(idList);
            httpSolrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找所有
     */
    public <T> List<T> findAll(SolrQuery solrQuery, Class<T> myClass) {
        try {
            QueryResponse qr = httpSolrClient.query(solrQuery);

            SolrDocumentList results = qr.getResults();
            System.out.println(results.toString());

            return qr.getBeans(myClass);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void highLight(SolrQuery solrQuery, Class<User> class1) {
        try {
            QueryResponse qr = httpSolrClient.query(solrQuery);
            Iterator<SolrDocument> iter = qr.getResults().iterator();
            while (iter.hasNext()) {
                SolrDocument resultDoc = iter.next();
                String id = (String) resultDoc.getFieldValue("id");
                String name = (String) resultDoc.getFieldValue("name");
                if (qr.getHighlighting().get(id) != null) {
                    List<String> highlightSnippets = qr.getHighlighting().get(id).get("name");
                }
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void groupBy() throws SolrServerException, IOException {
        SolrQuery solrQuery = new SolrQuery("title:手机");
        // 是否分组
        solrQuery.setParam("group", true);
        // 分组的域
        solrQuery.setParam("group.field", "companyId");

        solrQuery.setParam("group.query", "price:[0 TO 100]");

        // 每组显示的个数,默认为1,当每个分组显示数目大于1个时,不能用分组数量来计算总页码
        solrQuery.setParam("group.limit", "10");
        // 是否计算所得分组个数
        solrQuery.setParam("group.ngroups", true);

        // solrQuery.setStart(0); //起始索引值
        // solrQuery.setRows(100);//显示几条数据

        QueryResponse resp = httpSolrClient.query(solrQuery);
        GroupResponse gresp = resp.getGroupResponse();
        List<GroupCommand> commands = gresp.getValues();
        if (commands != null) {
            for (GroupCommand com : commands) {
                System.out.println("总分组个数：" + com.getNGroups().longValue());
                for (Group group : com.getValues()) {
                    SolrDocumentList hits = group.getResult();
                    for (SolrDocument doc : hits) {
                        System.out.println("id: " + (String) doc.getFieldValue("id") + ", title: "
                                + (String) doc.getFieldValue("title") + ", price: "
                                + (Float) doc.getFieldValue("price"));
                    }
                }
            }
        }
    }
}
