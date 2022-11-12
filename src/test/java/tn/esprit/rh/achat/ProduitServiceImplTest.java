package tn.esprit.rh.achat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import jdk.internal.org.jline.utils.Log;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProduitServiceImplTest {

	private static final Logger l =LogManager.getLogger(ProduitServiceImplTest.class);
	
	/*@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;*/

	@Autowired
	ProduitServiceImpl ps;

	@InjectMocks
	ProduitServiceImpl psm;

	@Mock
	ProduitRepository pr;

	@Test
	public void testRetrieveAllReglements() {
		l.info("testRetrieveAllReglements()");
		List<Produit> listReglements = ps.retrieveAllProduits();
		Assertions.assertEquals(0, listReglements.size());
		l.info("Out methode testRetrieveAllReglements()");
	}




	
	/*@Test
	public void addProduitTest () 
	{
		//Produit p =new Produit ((long)1 ,"ghada","yosra",(float)12.2);
		Produit p2 =new Produit ((long)1 ,"mpmacpc","macbook",(float)6.3,new Date());
		produitRepository.save(p2);
		
	}
	
	@Test 
	public void retrieveProduitTest()
	{
		Produit p = produitRepository.findById(2L).get();
		//log.info("produit :" + p);
		System.out.println(p);
		
	}
	
	
	
	
	@Test
	public void updateProduitTest() 
	{
		//Produit p =new Produit ((long)1 ,"ghada","yosra",(float)12.2);
		Produit pd = produitRepository.findById(2L).get();
		pd.setLibelleProduit("hhhhhhh");		
		produitRepository.save(pd);
		System.out.println(pd);
	}
	
	
	@Test
	public void deleteProduitTest () 
	{
		//Produit p =new Produit ((long)1 ,"ghada","yosra",(float)12.2);
		
		produitRepository.deleteById(3L);
		
	}
	
	@Test
	public void retrieveAllProduitsTest()
	{
		List<Produit> produits = produitRepository.findAll();
		for (Produit produit : produits) {
			System.out.println(" Produit : " + produit);
		}
		
	}*/

	
	
	

}
