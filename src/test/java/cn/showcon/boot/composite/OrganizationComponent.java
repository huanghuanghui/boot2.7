package cn.showcon.boot.composite;

public abstract class OrganizationComponent {
    private String name;// 名字
    private String des;// 说明
    public String getName() {
        return name;
    }
    public String getDes() {
        return des;
    }
    protected void add(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }
    protected void remove(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }
    // 构造器
    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }
    // 方法print，抽象方法
    protected abstract void print();
}