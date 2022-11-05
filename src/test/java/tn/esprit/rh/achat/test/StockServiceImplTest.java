package tn.esprit.rh.achat.test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class StockServiceImplTest {

	@Autowired
	IStockService stock;
	@Autowired
	StockRepository strepo;
	
	//@Mock private StockRepository stockrepo;
	
	
	//@Test
	//public void TestGetAllStock() {
		//when(stock.retrieveAllStocks());
		//verify(strepo).findAll();
	//}
	
	
	
	@Test
	public void TestAddSecteurActivite() {
		
	Stock s = stock.addStock(Stock.builder()
				
				.libelleStock("gggg")
				.qte(5)
				.qteMin(1)
				.build());
	assertNotNull(s);
	assertNotNull(s.getIdStock());	
   }
	
	
	
	
	@Test
	public void TestretrieveAllStocks(){
		
		List<Stock> l = stock.retrieveAllStocks();
		for(Stock s : l) {
			System.out.println("Stock : " + s.getIdStock());
			System.out.println("Stock : " + s.getLibelleStock());
			System.out.println("Stock : " + s.getQte());
			System.out.println("Stock : " + s.getQteMin());
			System.out.println("**********************************");
			}
		//assertEquals(strepo.findAll().size(),l.size());
		System.out.println("Quantités de Stock : " + l.size());
	
	
		assertThat(l).hasSize(strepo.findAll().size());
		
	
	}
	
	@Test
	public void TestretrieveStock(){
		
		Stock exist = stock.retrieveStock((long) 1);
		System.out.println("ID = " +exist.getIdStock());
}
	
	@Test
	public void TestdeleteStock(){
		
		stock.deleteStock((long) 2);
		
}
	
	
	
	
	
	
}

	
	
		
	
