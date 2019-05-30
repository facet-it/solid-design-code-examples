package be.course.design.encapsulation.order;

public class OnlineOrder {

    private double[] currentLocation;

    private OrderStatus currentStatus = OrderStatus.NEW;
    private String orderId;

    public OnlineOrder(double[] storageLocation, String orderId) {
        this.currentLocation = storageLocation;
        this.orderId = orderId;
    }

    public double[] getCurrentLocation() {
        return currentLocation;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void bumpStatus() {
        if(currentStatus != OrderStatus.DELIVERED) {
            currentStatus = OrderStatus.forIndex(currentStatus.getIndex() + 1);
        }
    }

    public void unbumpStatus() {
        if(currentStatus != OrderStatus.NEW) {
            currentStatus = OrderStatus.forIndex(currentStatus.getIndex() - 1);
        }
    }

    public void setCurrentLocation(double[] location) {
        this.currentLocation = location;
    }
}
