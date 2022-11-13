package tn.esprit.rh.achat.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StockServiceImplTest {

	@Autowired
	IStockService stock;
	
	
	
	
	
	
	@Test
	void testAddStock() {
		List<Stock> stocks = stock.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stock.addStock(s);

		assertEquals(expected+1, stock.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		

	}
	
	
	
	
	@Test
	public void testRetrieveAllStocks() {
		List<Stock> listStocks = stock.retrieveAllStocks();
		Assertions.assertEquals(0, listStocks.size());
	}
	
	@Test
	void TestretrieveStock(){
		
		Stock exist = stock.retrieveStock((long) 1);
		System.out.println("ID = " +exist.getIdStock());
		assertNotNull(exist);
}
	@Test
	void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stock.addStock(s);
		stock.deleteStock(savedStock.getIdStock());
		assertNull(stock.retrieveStock(savedStock.getIdStock()));
	}
}
	
	
	
	
	


	
	
		
	
