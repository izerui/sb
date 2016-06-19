package com.sb.hyh.web;

import com.sb.hyh.dao.base.search.DynamicSpecifications;
import com.sb.hyh.dao.base.search.SearchFilter;
import com.sb.hyh.dao.base.search.SortItem;
import com.sb.hyh.dao.base.search.SortObject;
import com.sb.hyh.service.base.GenericService;
import com.sb.hyh.utils.ServletUtil;
import com.sb.hyh.vo.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.io.Serializable;
import java.util.Map;

/**
 * 通用查询Controller
 */
public abstract class GenericSearchRestController<T, ID extends Serializable> {
    @Autowired
    protected GenericService<T, ID> genericService;

    /**
     * 通过ID查找
     */
    @ResponseBody
    @RequestMapping("findById")
    public Response findById(@RequestParam ID id) {
        return new Response(genericService.findById(id));
    }

    /**
     * 通过ID判断是否存在
     */
    @ResponseBody
    @RequestMapping("exists")
    public Response exists(ID id) {
        return new Response(genericService.exists(id));
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("page")
    public Response findPage(@RequestParam(defaultValue = "1") int pageNumber,
                             @RequestParam(defaultValue = "20") int pageSize, SortObject sorts,
                             ServletRequest request) {
        return new Response(genericService.findPage(buildSpecification(request), new PageRequest(pageNumber - 1, pageSize, buildSort(sorts))));
    }

    /**
     * 查询数量
     */
    @ResponseBody
    @RequestMapping("count")
    public Response count(ServletRequest request) {
        return new Response(genericService.count(buildSpecification(request)));
    }

    /**
     * 查询所有
     */
    @ResponseBody
    @RequestMapping("all")
    public Response findAll(ServletRequest request, SortObject sorts) {
        return new Response(genericService.findAll(buildSpecification(request), buildSort(sorts)));
    }

    /**
     * 通过ServletRequest构建动态查询参数
     */
    protected Specification<T> buildSpecification(ServletRequest request) {
        Map<String, Object> searchParams = ServletUtil.getParametersStartingWith(request, "search_");

        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);

        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values());
        return spec;
    }


    /**
     * 构建排序对象
     */
    protected Sort buildSort(SortObject sorts) {
        Sort sort = null;
        if (sorts.getSorts() != null) {
            int len = sorts.getSorts().size();
            for (int i = 0; i < len; i++) {
                SortItem item = sorts.getSorts().get(i);
                if (StringUtils.isNotBlank(item.getField())) {
                    Sort sortItem = new Sort(Sort.Direction.fromString(item.getOrder()), item.getField());
                    sort = sort == null ? sortItem : sort.and(sortItem);
                }
            }
        }
        return sort;
    }
}
