package org.example.gallery.backend.controller;

import org.example.gallery.backend.dto.OrderDto;
import org.example.gallery.backend.entity.Cart;
import org.example.gallery.backend.entity.Item;
import org.example.gallery.backend.entity.Order;
import org.example.gallery.backend.repository.CartRepository;
import org.example.gallery.backend.repository.ItemRepository;
import org.example.gallery.backend.repository.OrderRepository;
import org.example.gallery.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    JwtService jwtService;
    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/api/orders")
    public ResponseEntity getOrder(
            @CookieValue(value="token",required = false)String token
    ){
        if(!jwtService.isValid(token)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int memberId=jwtService.getId(token);
        List<Order>orders=orderRepository.findByMemberIdOrderByIdDesc(memberId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/api/orders")
    public ResponseEntity pushOrder(
            @RequestBody OrderDto dto,
            @CookieValue(value="token",required = false)String token
            ) {


        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int memberId=jwtService.getId(token);
        Order order= new Order();
        order.setMemberId(jwtService.getId(token));
        order.setName(dto.getName());
        order.setAddress(dto.getAddress());
        order.setPayment(dto.getPayment());
        order.setCardNumber(dto.getCardNumber());
        order.setItems(dto.getItems());

        orderRepository.save(order);
        cartRepository.deleteByMemberId(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
