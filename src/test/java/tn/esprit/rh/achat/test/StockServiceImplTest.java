package tn.esprit.rh.achat.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
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
	@Autowired
	StockRepository strepo;
	
	//@Mock private StockRepository stockrepo;
	
	
	//@Test
	//public void TestGetAllStock() {
		//when(stock.retrieveAllStocks());
		//verify(strepo)findAll();
	//}
	
	
	
	@Test
    void TestAddSecteurActivite() {
		
	Stock s = stock.addStock(Stock.builder()
				
				.libelleStock("caasd")
				.qte(546)
				.qteMin(1)
				.build());
	assertNotNull(s);
	assertNotNull(s.getIdStock());	
   }
	
	
	
	
	@Test
	void TestretrieveAllStocks(){
		
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
	void TestretrieveStock(){
		
		Stock exist = stock.retrieveStock((long) 1);
		System.out.println("ID = " +exist.getIdStock());
		assertNotNull(exist);
}
	
	//@Test
	//void TestdeleteStock(){
		
		//stock.deleteStock((long) 2);
		
//}
	
	
	
	
	
	
}

	
	
		
	
