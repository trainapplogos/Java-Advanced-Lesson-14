package ua.lviv.trainapplogos.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateXMLConfStarter {
	public static void main(String[] args) {
		//create configuration object with credentials to DB
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
//		//create 
//		Cart cart = new Cart(42, "Peter Somebody");
//		session.persist(cart);
//		
//		Cart cart2 = new Cart(23, "Andrew Lincoln");
//		session.persist(cart2);
//		
//		//read single entity and delete it
//		Cart cartFromDB = (Cart) session.get(Cart.class, 2);
//		System.out.println(cartFromDB);
//		if (cartFromDB != null) session.delete(cartFromDB);
//		
//		//get list of person from DB
//		CriteriaQuery<Cart> criteria = session.getCriteriaBuilder().createQuery(Cart.class);
//		criteria.from(Cart.class);
//		List<Cart> ListOfCarts = session.createQuery(criteria).getResultList();
//		ListOfCarts.forEach(System.out::println);
//		
//		//update of entity
//		Cart cartForUpdate = session.get(Cart.class, 1);
//		cartForUpdate.setTotal(65);
//		cartForUpdate.setName("Antonio Banderas");
//		session.persist(cartForUpdate);
//		Cart cartAfterUpdate = session.get(Cart.class, 1);
//		System.out.println("> Cart with id=1 after update: \n" + cartAfterUpdate);
		
		//create Person with cars
		Cart cart3 = new Cart(434, "John Summer");
		Item item1 = new Item(15);
		Item item2 = new Item(53);
		Item item3 = new Item(43);
		Item item4 = new Item(61);
		HashSet<Item> items = new HashSet<Item>(Arrays.asList(item1, item2, item3, item4));
		cart3.setItems(items);
		session.persist(cart3);
		
		transaction.commit();
		session.close();
	}
}
