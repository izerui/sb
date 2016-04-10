package com.sb.hyh.solr.utils.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.sb.hyh.entity.User;
import com.sb.hyh.solr.utils.SolrUtil;

public class SolrUtilTest {
    private SolrUtil solrUtil = new SolrUtil("http://172.17.80.167:8080/solr/new_core");

    @Test
    public void add() {
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.addField("id", "id1", 1.0f);
        doc1.addField("name", "doc1", 1.0f);
        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.addField("id", "id2", 1.0f);
        doc2.addField("name", "doc2", 1.0f);
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        docs.add(doc1);
        docs.add(doc2);

        solrUtil.add(docs);
    }

    @Test
    public void addBean() {
        User user = new User();
        user.setId("123");
        user.setName("洪水");
        solrUtil.addBean(user);
    }

    @Test
    public void find() {
        SolrQuery solrQuery = new SolrQuery().setQuery("洪").setFacet(true).setFacetMinCount(1).setFacetLimit(8)
                .addFacetField("id").addFacetField("name");
        List<User> list = solrUtil.findAll(solrQuery, User.class);
        for (User user : list) {
            System.out.println(user.getId() + "," + user.getName());
        }
    }

    @Test
    public void highLight() {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("洪");
        solrQuery.setHighlight(true).setHighlightSnippets(1);
        solrQuery.setParam("hl.fl", "name");

        solrUtil.highLight(solrQuery, User.class);
    }

    @Test
    public void testFindAll() {
        SolrQuery solrQuery = new SolrQuery("*:*");
        List<User> list = solrUtil.findAll(solrQuery, User.class);
        for (User user : list) {
            System.out.println(user.getId() + "," + user.getName());
        }
    }

    @Test
    public void delete() {
        solrUtil.deleteById("1");

        List<String> list = new LinkedList<String>();
        list.add("id1");
        solrUtil.deleteByIdList(list);
    }
}
