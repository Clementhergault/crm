package com.tpcrm.crm;

import com.tpcrm.crm.business.CrmService;
import com.tpcrm.crm.dao.Client;
import com.tpcrm.crm.dao.ClientRepository;
import com.tpcrm.crm.dao.Order;
import com.tpcrm.crm.dao.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.tpcrm.crm.dao.ClientState.ACTIVE;
import static com.tpcrm.crm.dao.ClientState.INACTIVE;
import static com.tpcrm.crm.dao.OrderState.CANCELED;
import static com.tpcrm.crm.dao.OrderState.OPTION;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CrmApplicationTests {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CrmService crmService;

	@Test //Post/client
	void testRepositoryClient() {
		Client client = new Client("Spie","Erwan","Legoff",
				"elegoff@spie.fr","06 73 85 17 69","azer","b",
				"Rennes","France",INACTIVE);
		clientRepository.save(client);
	}

	@Test //Post/order Test ManyToOne
	void testRepositoryOrder() {
		Client client = new Client("SNCF","Hélène","Pirotais",
				"hpirotais@sncf.fr","06 02 25 13 45","azer","b",
				"Strasbourg","France",ACTIVE);
		clientRepository.save(client);
		Order order = new Order("Accompagnement","SQL",3,800,OPTION,client);
		orderRepository.save(order);
	}

	@Test
	void testAjoutDeuxiemeOrder(){
		Client client = clientRepository.findById(19).get();

		Order order = new Order("Formation","Java",15,1175,CANCELED,client);
		orderRepository.save(order);
		order.setClient(client);
		orderRepository.save(order);
	}



//
//	@Test
//	void testLivreAvecAuteur() {
//		Auteur auteur = new Auteur("Jean", "Bond");
//		auteurRepository.save(auteur);
//		Livre livre = new Livre("Java pour les Nuls", 2022);
//		livre.setAuteur(auteur);
//		livreRepository.save(livre);
//	}
//
//	@Test
//	void testRepositoryCategorie() {
//		Categorie cat = new Categorie("Sport");
//		categorieRepository.save(cat);
//	}
//
//	@Test
//	void testLivreAvecCategorie() {
//		Categorie cat1 = new Categorie("Sciences");
//		categorieRepository.save(cat1);
//		Categorie cat2 = new Categorie("Humour");
//		categorieRepository.save(cat2);
//
//		Livre livre = new Livre("Java pour les Nuls", 2022);
//		livre.addCategorie(cat1);
//		livre.addCategorie(cat2);
//		livreRepository.save(livre);
//	}

}
