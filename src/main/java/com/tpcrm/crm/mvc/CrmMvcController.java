package com.tpcrm.crm.mvc;

import com.tpcrm.crm.business.CrmService;
import com.tpcrm.crm.dao.Client;
import com.tpcrm.crm.dao.Order;
import com.tpcrm.crm.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CrmMvcController {

    @Autowired
    CrmService crmService;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("clients")
    public ModelAndView getClients(){

        ModelAndView view = new ModelAndView("clients.html");
        List<Client> clients = crmService.getClients();
        view.addObject("clients", clients);

        return view;
    }

    @GetMapping("orders")
    public ModelAndView getOrders(){

        ModelAndView view = new ModelAndView("orders.html");
        List<Order> orders = crmService.getOrders();
        List<Client> clients=crmService.getClients();
        view.addObject("orders", orders);
        view.addObject("clients", clients);

        return view;
    }

    @GetMapping("ficheclient")
    public ModelAndView getClients(@RequestParam Integer id){

        ModelAndView view = new ModelAndView("client-details.html");

        Client client = crmService.getClientId(id);
        view.addObject("client", client);

        return view;
    }
    @GetMapping("ficheorder")
    public ModelAndView getOrders(@RequestParam Integer id){

        ModelAndView view = new ModelAndView("order-details.html");

        Order order = orderRepository.findById(id).get();
        view.addObject("order", order);

        return view;
    }

}
