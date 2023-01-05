package cn.showcon.boot.invocationhandler;

public class AddServiceImpl implements AddService {

    @Override
    public int add(int a, int b) {
        return  a + b;
    }
}