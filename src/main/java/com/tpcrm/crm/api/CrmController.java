package com.tpcrm.crm.api;

import com.tpcrm.crm.business.CrmService;
import com.tpcrm.crm.dao.Client;
import com.tpcrm.crm.dao.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CrmController {

    @Autowired
    private CrmService crmService;

    //CRUD Client
    @PostMapping("clients")
    public void createClients(@RequestBody Client client){
        crmService.createClient(client);
    }

    @GetMapping("clients")
    public List<Client> getClients(){
        return crmService.getClients();
    }

    @GetMapping("clients/{id}")
    public Client getOneClient(@PathVariable Integer id){
        return crmService.getClientId(id);
    }

    @PutMapping("clients/{id}")
    public ResponseEntity updateClient(@PathVariable Integer id, @RequestBody Client client){
        return crmService.updateClient(id,client);
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id){
        return crmService.deleteClient(id);
    }

    //CRUD Order
    @PostMapping("orders")
    public void createOrders(@RequestBody Order order){
        crmService.createOrder(order);
    }

    @GetMapping("orders")
    public List<Order> getOrders(){
        return crmService.getOrders();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity getOneOrder(@PathVariable Integer id){
        return crmService.getOrderId(id);
    }

    @PutMapping("orders/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody Order order){
        return crmService.updateOrder(id,order);
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        return crmService.deleteOrder(id);
    }


    //@GetMapping("personnes")
//    public List<PersonneDTO> getPersonnes(){
//
//        List<PersonneDTO> dtos = new ArrayList<>();
//        List<Personne> entities = annuaireDatabaseService.getPersonnes();
//
//        for(Personne entity : entities){
//            PersonneDTO dto = PersonneMapper.convertToDTO(entity);
//            dtos.add(dto);
//        }
//
//        return dtos;
//    }
}
