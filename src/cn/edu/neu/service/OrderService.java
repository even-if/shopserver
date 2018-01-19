package cn.edu.neu.service;

import java.util.List;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;

public interface OrderService {

	int addOrder(Order order,List<OrderDetail> orderDetails);

	Page<Order> getMyOrders(int loginUserId,String status);

	void deleteOrder(String orderId);

	void updateOrderStatus(String orderId, int status);

	int getOrderStatusById(String orderId);

	Order getOrderDetailById(String orderId);

	
}
