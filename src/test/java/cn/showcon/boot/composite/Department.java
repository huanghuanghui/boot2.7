package cn.showcon.boot.composite;

public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
    }
    // add和remove方法就不需要再写了
    @Override
    protected void print() {
        System.out.println("===========" + getName() + "=========");
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