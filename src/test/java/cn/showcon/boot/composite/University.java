package cn.showcon.boot.composite;

import java.util.ArrayList;
import java.util.List;

// University 就是 Composite，可以管理College
public class University extends OrganizationComponent {
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();
    // 构造器
    public University(String name, String des) {
        super(name, des);
    }
    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }
    // 重写remove
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }
    @Override
    protected void print() {
        System.out.println("==========" + getName() + "=========");
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getDes() {
        return super.getDes();
    }
}