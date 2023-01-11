package com.tpcrm.crm.business;

import com.tpcrm.crm.dao.Client;
import com.tpcrm.crm.dao.ClientRepository;
import com.tpcrm.crm.dao.Order;
import com.tpcrm.crm.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    //Post
    public void createClient(Client client){
        clientRepository.save(client);
    }

    //Post
    public void createOrder(Order order){
        orderRepository.save(order);
    }

    //Get
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    //Get
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    //Get/id
    public Client getClientId(Integer id){
        Optional o=clientRepository.findById(id);
        if (o.isEmpty()){
            return null;
        }else{
            return clientRepository.findById(id).get();
        }
    }

    //Get/id
    public ResponseEntity getOrderId(Integer id){
        Optional o=orderRepository.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Order order =orderRepository.findById(id).get();
            return ResponseEntity.ok(order);
        }
    }

    //Put/id
    public ResponseEntity updateClient(Integer id, Client client){
        Optional o=clientRepository.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if (client.getId()!=id){
                return ResponseEntity.badRequest().build();
            }else {
                client = clientRepository.findById(id).get();
                clientRepository.save(client);
                return ResponseEntity.ok(client);
            }
        }
    }

    //Put/id
    public ResponseEntity updateOrder(Integer id, Order order){
        Optional o=orderRepository.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            if (order.getId()!=id){
                return ResponseEntity.badRequest().build();
            }else {
                order = orderRepository.findById(id).get();
                orderRepository.save(order);
                return ResponseEntity.ok(order);
            }
        }
    }

    //Delete/id
    public ResponseEntity deleteClient(Integer id){
        Optional o=clientRepository.findById(id);
      if (o.isEmpty()){
          return ResponseEntity.notFound().build();
      }else {
          Client client = clientRepository.findById(id).get();
          clientRepository.deleteById(id);
          return ResponseEntity.ok().build();
      }
    }

    //Delete/id
    public ResponseEntity deleteOrder(Integer id){
        Optional o=orderRepository.findById(id);
        if (o.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Order order = orderRepository.findById(id).get();
            orderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
