package be.course.design.encapsulation.order;

import java.util.HashMap;
import java.util.Map;

public class OnlineOrder {

    private double[] currentLocation;

    private OrderStatus currentStatus = OrderStatus.NEW;
    private String orderId;

    public OnlineOrder(double latitude, double longitude, String orderId) {
        this.currentLocation = new double[] {latitude, longitude};
        this.orderId = orderId;
    }

    public Map<String, Double> getCurrentLocation() {
        Map<String, Double> coordinates = new HashMap<>();
        coordinates.put("latitude", currentLocation[0]);
        coordinates.put("longitude", currentLocation[1]);

        return coordinates;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setCurrentLocation(double latitude, double longitude) {
        this.currentLocation = new double[]{latitude, longitude};
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
}
