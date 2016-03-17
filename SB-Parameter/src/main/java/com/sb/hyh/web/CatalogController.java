package com.sb.hyh.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hyh.vo.Catalog;
import com.sb.hyh.vo.Catalog2;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    /**
     * List<String>参数
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(@RequestParam List<String> idList, @RequestParam Boolean isBatch) {
        for (String str : idList) {
            System.out.println(str);
        }
        System.out.println(isBatch);
        return "";
    }

    @RequestMapping(value = "/saveByGet", method = RequestMethod.GET)
    public String saveByGet(@RequestParam List<Catalog> catalogList) {
        for (Catalog catalog : catalogList) {
            System.out.println(catalog);
        }
        return "";
    }

    /**
     * 有问题
     */
    // @RequestMapping(value = "/saveByGet2", method = RequestMethod.GET)
    // public void saveByGet(@RequestParam Catalog[] catalogList) {
    // for (Catalog catalog : catalogList) {
    // System.out.println(catalog);
    // }
    // }

    @RequestMapping(value = "/saveByPost", method = RequestMethod.POST)
    public String saveByPost(@RequestBody List<Catalog> catalogList) {
        for (Catalog catalog : catalogList) {
            System.out.println(catalog);
        }
        return "";
    }

    @RequestMapping(value = "/saveByPost2", method = RequestMethod.POST)
    public String saveByPost(@RequestBody Catalog[] catalogList) {
        for (Catalog catalog : catalogList) {
            System.out.println(catalog);
        }
        return "";
    }

    /**
     * 有问题
     */
    // @RequestMapping(value = "/listmapByGet", method = RequestMethod.GET)
    // public String listmapByGet(@RequestParam List<Map<String, Object>>
    // listMap) {
    // for (Map<String, Object> map : listMap) {
    // System.out.println(map.get("test"));
    // }
    // return "";
    // }

    @RequestMapping(value = "/listmapByPost", method = RequestMethod.POST)
    public String listmapByPost(@RequestBody List<Map<String, Object>> listMap) {
        for (Map<String, Object> map : listMap) {
            System.out.println(map.get("test"));
        }
        return "";
    }

    @RequestMapping(value = "/catalogList", method = RequestMethod.POST)
    public String catalogList(@RequestBody Catalog2 catalog2) {
        System.out.println(catalog2.getName());
        List<Catalog2> list = catalog2.getList();
        for (Catalog2 catalog22 : list) {
            System.out.println(catalog22.getName());
        }
        return "";
    }
}