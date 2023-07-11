package com.ulaf.ste.ordering_system.Web.REST;


import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Model.OrderItem;
import com.ulaf.ste.ordering_system.Service.OrderItemService;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Web.requests.OrderRequest;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    public OrderController(OrderService orderService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/today")
    public ResponseEntity<List<Order>> getTodayOrders() {
        List<Order> orders = orderService.getTodaysOrders();
        return ResponseEntity.ok(orders);
    }
    @PutMapping(value = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> changeOrderStatus(@RequestBody OrderRequest order) {
        List<Order> orders = orderService.changeOrderStatus(1L);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        // ORDER REQUEST NE MOZHE DA PRIMA LISTA OD ORDER ITEMS ZATOA SHTO NE MOZHE
        // DA SE MACHUAA FRONTEND SO ENTITET. TREBA DA IMA LISTA OD ORDER ITEM IDS - DA SE NAPRAE REQUEST

//        List<OrderItemRequest> orderItems = orderRequest.getOrderItems();
        String customerName = orderRequest.getCustomerName();
        String customerSurname = orderRequest.getCustomerSurname();
        String customerEmailAddress = orderRequest.getCustomerEmailAddress();
        String customerPhone = orderRequest.getCustomerPhone();

        // Create the Order object
        List<OrderItem> orderItems = orderItemService.findAllByIds(orderRequest.getOrderItemIds());
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
