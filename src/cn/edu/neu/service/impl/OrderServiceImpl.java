package cn.edu.neu.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.mapper.OrderMapper;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;
import cn.edu.neu.model.Size;
import cn.edu.neu.service.OrderService;
@Transactional
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper mapper;

	@Override
	public int addOrder(Order order,List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String str=sf.format(d);
		Random r=new Random();
		int i=r.nextInt(100);
		String s="";
		if(i<10)
			s="00"+i;
		else if(i>=10&&i<=99)
			s="0"+i;
		String orderCode=str+s;
		
	
		order.setOrderCode(orderCode);
		mapper.addOrder(order);
		int orderId=order.getOrderId();
		System.out.println("---------"+order.getOrderId());
		
		for(int j=0;j<orderDetails.size();j++){
			OrderDetail od=orderDetails.get(j);
			od.setOrderId(orderId);
			mapper.addOrderDetail(od);
		}
		
		return orderId;
	}

	@Override
	public Page<Order> getMyOrders(int loginUserId,String status) {
		// TODO Auto-generated method stub
		Page<Order> page = new Page<Order>(10);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("userId", loginUserId+"");
		m.put("status", status);
		page.setParams(m);
		List<Order> orderList=mapper.getMyOrders(page);
		System.out.println(orderList);
		page.setList(orderList);
		return page;
	}

	@Override
	public void deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		mapper.deleteOrderDetail(orderId);
		mapper.deleteOrder(orderId);
	}

	@Override
	public void updateOrderStatus(String orderId,int status) {
		// TODO Auto-generated method stub
		Map<String,String> m=new HashMap<String,String>();
		m.put("orderId", orderId);
		mapper.updateOrderStatus(orderId,status);
	}

	@Override
	public int getOrderStatusById(String orderId) {
		// TODO Auto-generated method stub
		int status=mapper.getOrderStatusById(Integer.parseInt(orderId));
		return status;
	}

	@Override
	public Order getOrderDetailById(String orderId) {
		// TODO Auto-generated method stub
		Order orderDetail=mapper.getOrderDetailById(orderId);
		return orderDetail;
	}

	
}
