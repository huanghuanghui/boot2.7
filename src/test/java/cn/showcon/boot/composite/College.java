package cn.showcon.boot.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {
    // list中存放department
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();
    public College(String name, String des) {
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