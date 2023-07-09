package com.ulaf.ste.ordering_system.Web.REST;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Model.OrderItem;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Web.requests.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;

    public OrderController(OrderService orderService, ObjectMapper objectMapper) {
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/today")
    public ResponseEntity<List<Order>> getTodaysOrders() {
        List<Order> orders = orderService.getTodaysOrders();
        return ResponseEntity.ok(orders);
    }
    @PutMapping(value = "/status")
    public ResponseEntity<List<Order>> changeOrderStatus(@RequestBody OrderRequest order) {
        List<Order> orders = orderService.changeOrderStatus(order.getId());
        return ResponseEntity.ok(orders);
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        // Extract the data from the orderRequest and create the order
        List<OrderItem> orderItems = orderRequest.getOrderItems();
        String customerName = orderRequest.getCustomerName();
        String customerSurname = orderRequest.getCustomerSurname();
        String customerEmailAddress = orderRequest.getCustomerEmailAddress();
        String customerPhone = orderRequest.getCustomerPhone();

        // Create the Order object
        Order order = new Order(orderItems, customerName, customerSurname, customerEmailAddress, customerPhone,false);
        order.setCreatedOn(LocalDateTime.now());

        // Save the order to the database or perform any other required actions
        Order createdOrder = orderService.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) throws NotFoundByIdException{
        Order order = orderService.getOrderById(id);
        if(order != null)
        {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) throws NotFoundByIdException{
        Order updatedOrder = orderService.updateOrder(id,order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/finish") //so GetMapping rabota
    public ResponseEntity<Order> finishOrder(@PathVariable Long id) throws NotFoundByIdException {
        Order finishedOrder = orderService.finishOrder(id);
        if (finishedOrder != null) {
            return ResponseEntity.ok(finishedOrder);
        }
        return ResponseEntity.notFound().build();
    }
}
