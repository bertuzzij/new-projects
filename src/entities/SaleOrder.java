package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class SaleOrder {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private OrderItem orderitem;
	private List<OrderItem> pedidos = new ArrayList<>();
	
	public SaleOrder() {
	}

	public SaleOrder(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getPedidos() {
		return pedidos;
	}
	
	public void addItem(OrderItem item) {
		pedidos.add(item);
	}
	
	public void removeItem(OrderItem item) {
		pedidos.remove(item);
	}
	
}
