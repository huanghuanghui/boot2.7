package cn.showcon.boot.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Parameter;
import java.util.Iterator;
import java.util.List;

@Component
public class GlobalHeaderOperationCustomizer implements OperationCustomizer {
    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            Parameter parameter = methodParameter.getParameter();
            Class<?> type = parameter.getType();
            if (type!=null &&type.isAssignableFrom(PageRequest.class)){
                List<io.swagger.v3.oas.models.parameters.Parameter> parameters = operation.getParameters();
                Iterator<io.swagger.v3.oas.models.parameters.Parameter> iterator = parameters.iterator();
                if (iterator.hasNext()){
                    io.swagger.v3.oas.models.parameters.Parameter parameter1 =iterator.next();
                    if (parameter1.getSchema()!=null&& StringUtils.isNotBlank(parameter1.getSchema().get$ref())) {
                        if (parameter1.getSchema().get$ref().contains(SwaggerPageable.class.getSimpleName())) {
                            parameters.remove(parameter1);
                        }
                    }
                }
                operation.addParametersItem(getParameter("size","Number of records per page","10"));
                operation.addParametersItem(getParameter("page","Results page you want to retrieve (0..N)","1"));
                operation.addParametersItem(getParameter("sort","Sorting criteria in the format: property(,asc|desc) Default sort order is ascending. Multiple sort criteria are supported.",""));
            }
        }
        return operation;
    }

    private io.swagger.v3.oas.models.parameters.Parameter getParameter(String name, String desc,String example) {
        return new io.swagger.v3.oas.models.parameters.Parameter().in(ParameterIn.QUERY.toString()).name(name)
                .description(desc).schema(new StringSchema()).example(example).required(false);
    }
}