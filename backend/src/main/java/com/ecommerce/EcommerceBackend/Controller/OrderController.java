package com.ecommerce.EcommerceBackend.Controller;


import com.ecommerce.EcommerceBackend.Dto.OrderDto;
import com.ecommerce.EcommerceBackend.Model.Orders;
import com.ecommerce.EcommerceBackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public void addOrder(@RequestParam Long cartId, @RequestParam Long customerId,@RequestBody OrderDto orderDto) {
        orderService.addOrder(cartId,customerId,orderDto);
    }
    @GetMapping("/{id}")
    public Orders findById(@PathVariable Long id) {
        try {
            return orderService.findById(id);
        }
        catch (Exception e) {
             System.out.println("Order not Found" + e);
             return  null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id,@RequestBody OrderDto orderDto) {
        orderService.updateOrder(id,orderDto);
    }
}
