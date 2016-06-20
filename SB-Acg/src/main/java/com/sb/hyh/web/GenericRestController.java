package com.sb.hyh.web;

import com.sb.hyh.vo.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 通用CRUD Controller
 */
public abstract class GenericRestController<T, ID extends Serializable> extends GenericSearchRestController<T, ID> {

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("save")
    public <S extends T> Response save(S entity) {
        baseService.save(entity);
        return new Response("保存成功");
    }

    /**
     * 通过ID删除
     */
    @ResponseBody
    @RequestMapping("delete")
    public Response delete(@RequestParam ID id) {
        baseService.delete(id);
        return new Response("删除成功");
    }

    /**
     * 通过ID批量删除
     */
    @ResponseBody
    @RequestMapping("batchDelete")
    public Response batchDelete(@RequestParam ID[] ids) {
        baseService.delete(Arrays.asList(ids));
        return new Response("删除成功");
    }
}
