package be.course.design.encapsulation.order;

public enum OrderStatus {
    NEW(1, "Unprocessed"),
    PACKAGING(2,"Being packaged"),
    UNDERWAY(3, "On its way"),
    DELIVERED(4, "Delivered");

    private final int index;
    private final String readableStatus;

    OrderStatus(int index, String readableStatus) {
        this.readableStatus = readableStatus;
        this.index = index;
    }

    public static OrderStatus forIndex(int index) {
        for(OrderStatus status : OrderStatus.values()) {
            if(status.index == index) {
                return status;
            }
        }
        return OrderStatus.NEW;
    }

    public String getReadableStatus() {
        return this.readableStatus;
    }

    public int getIndex() {
        return this.index;
    }
}
