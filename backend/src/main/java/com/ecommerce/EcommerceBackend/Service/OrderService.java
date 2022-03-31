package com.ecommerce.EcommerceBackend.Service;


import com.ecommerce.EcommerceBackend.Dto.OrderDto;
import com.ecommerce.EcommerceBackend.Model.Cart;
import com.ecommerce.EcommerceBackend.Model.Customer;
import com.ecommerce.EcommerceBackend.Model.Orders;
import com.ecommerce.EcommerceBackend.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    public void addOrder(Long cartId, Long customerId, OrderDto orderDto) {
        Customer customer = customerService.findCustomerById(customerId);
        Cart cart = cartService.findCartById(cartId);
//        Customer customer = new Customer();
//        customer.setId(customerId);
//        Cart cart = new Cart();
//        cart.setId(cartId);
        Orders order = new Orders();
        order.setId(orderDto.getId());
        order.setName(orderDto.getName());
        order.setCart(cart);
        order.setCustomer(customer);
        orderRepository.save(order);
    }

    public Orders findById(Long id) {
        try {
            return orderRepository.findById(id).orElseThrow(null);
        }
        catch (Exception e) {
            System.out.println("Order NOt FOund  " +e);
            return null;
        }
    }

    public void deleteOrder(Long id) {
        try {
            Orders order = orderRepository.findById(id).orElseThrow(null);
            orderRepository.delete(order);
        }
        catch (Exception e) {
            System.out.println("order not deleted  " +e);
        }
    }

    public void updateOrder(Long id, OrderDto orderDto) {
        Orders order = orderRepository.findById(id).orElseThrow(null);
        order.setName(orderDto.getName());
        orderRepository.save(order);
    }
}
