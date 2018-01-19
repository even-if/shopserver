package cn.edu.neu.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;

public interface OrderMapper {

	void addOrder(Order order);

	List<Order> getMyOrders(Page<Order> page);

	void addOrderDetail(OrderDetail od);

	void deleteOrderDetail(String orderId);

	void deleteOrder(String orderId);

	void updateOrderStatus(String orderId, int status);

	int getOrderStatusById(int orderId);

	Order getOrderDetailById(String orderId);

	

	

	
}
