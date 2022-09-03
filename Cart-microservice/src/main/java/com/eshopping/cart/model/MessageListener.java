package com.eshopping.cart.model;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.eshopping.cart.config.MQConfig;

@Component
public class MessageListener {

//    @RabbitListener(queues = MQConfig.QUEUE)
//    public void listener(Product productList) {
//        
//    }

}