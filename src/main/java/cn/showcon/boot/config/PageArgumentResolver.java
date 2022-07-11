package cn.showcon.boot.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return PageRequest.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String size = webRequest.getParameter("size");
        String page = webRequest.getParameter("page");
        String[] sorts = webRequest.getParameterValues("sort");
        PageRequest result = new PageRequest();
        result.setPage(Integer.parseInt(page));
        result.setSize(Integer.parseInt(size));
        List<PageRequest.SortItem> itemList = new ArrayList<>();
        if (sorts != null && sorts.length > 0) {
            Arrays.stream(sorts).forEach(a -> {
                String[] item = a.split(",");
                PageRequest.SortItem orderItem = new PageRequest.SortItem();
                orderItem.setName(item[0]);
                if (item.length == 1) {
                    orderItem.setAsc(true);
                } else {
                    orderItem.setAsc(item[1].equals("asc"));
                }
                itemList.add(orderItem);
            });
        }
        if (itemList.size() > 0) result.setSortItem(itemList);
        return result;
    }
}
