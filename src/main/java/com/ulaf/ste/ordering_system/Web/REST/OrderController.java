package com.ulaf.ste.ordering_system.Web.REST;


import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Model.OrderItem;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import com.ulaf.ste.ordering_system.Service.OrderItemService;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Service.ProductService;
import com.ulaf.ste.ordering_system.Web.requests.OrderItemRequest;
import com.ulaf.ste.ordering_system.Web.requests.OrderRequest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final ProductService productService;
    private final IngredientService ingredientService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders().stream().sorted(Comparator.comparing(Order::getCreatedOn)).collect(Collectors.toList());
        Collections.reverse(orders);
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/today")
    public ResponseEntity<List<Order>> getTodayOrders() {
        List<Order> orders = orderService.getTodaysOrders();
        return ResponseEntity.ok(orders);
    }
    @PutMapping(value = "/status/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> changeOrderStatus(@PathVariable Long id) {
        List<Order> orders = orderService.changeOrderStatus(id);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderItemRequest> orderItemRequests = orderRequest.getOrderItemRequests();
        List<OrderItem> orderItems = orderItemRequests.stream().map(a -> {
            try {
                Product product = productService.getProductById(a.getProductId());
                List<Ingredient> notIngredients = a.getNotIngredients().stream().map(ingredientService::findByName).toList();
                return new OrderItem(product,a.getQuantity(),notIngredients);
            } catch (NotFoundByIdException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        orderItemService.saveAll(orderItems);

        String customerName = orderRequest.getCustomerName();
        String customerSurname = orderRequest.getCustomerSurname();
        String customerEmailAddress = orderRequest.getCustomerEmailAddress();
        String customerPhone = orderRequest.getCustomerPhone();
        Order order = new Order(orderItems, customerName, customerSurname, customerEmailAddress, customerPhone,false);

        order.setCreatedOn(LocalDateTime.now().plusHours(2));

        Order createdOrder = orderService.createOrder(order);
        simpMessagingTemplate.convertAndSend("/orders",createdOrder);
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
