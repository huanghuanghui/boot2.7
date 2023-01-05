package cn.showcon.boot.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AddServiceHandler implements InvocationHandler {
    private AddService addService;

    public AddServiceHandler(AddService addService) {
        this.addService = addService;
    }

    public AddService getProxy() {
        return (AddService) Proxy.newProxyInstance(addService.getClass().getClassLoader(),
                addService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(addService, args);
        System.out.println("after");
        return invoke;
    }
}