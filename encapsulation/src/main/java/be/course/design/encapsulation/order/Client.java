package be.course.design.encapsulation.order;

public class Client {

    public static void main(String[] args) {
        OnlineOrder order = new OnlineOrder(51.000389, 3.326935, "order-2019/344567");

        order.getCurrentLocation();
    }

}