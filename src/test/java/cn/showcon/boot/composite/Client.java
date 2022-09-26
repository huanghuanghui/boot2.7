package cn.showcon.boot.composite;

public class Client {
    public static void main(String[] args) {
        // 创建大学
        OrganizationComponent university = new University("清华大学", "中国最好的大学");
        // 创建学院
        OrganizationComponent college1 = new College("计算机学院", "计算机学院");
        OrganizationComponent college2 = new College("信息工程学院", "信息工程学院");
        // 创建各个学院下面的系
        college1.add(new Department("软件工程", "软件工程"));
        college1.add(new Department("网络工程", "网络工程"));
        college1.add(new Department("计算机科学与技术", "老牌专业"));
        college2.add(new Department("通信工程", "通信工程"));
        college2.add(new Department("信息工程", "信息工程"));
        // 将学院添加到学校中
        university.add(college1);
        university.add(college2);
        // 打印大学底下的所有院系
        university.print();
        // 打印学院底下的所有系
        college1.print();
    }
}