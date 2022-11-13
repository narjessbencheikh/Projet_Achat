package tn.esprit.rh.achat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.mockito.ArgumentMatchers;

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
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	Produit produit = new Produit ((long)1 ,"mpmacpc","macbook",(float)6.3,new Date());

	List<Produit> listProduits = new ArrayList<Produit>() {
		{
			add(new Produit((long)2, "dshfds", "jfstj",(float)6.3, new Date()));
			add(new Produit((long)3, "jfsd", "Mac",(float)22.1, new Date()));
		}
	};

	@Mock
	ProduitRepository pr;

	@Test
	public void testRetrieveAllProduit() {
		l.info("testRetrieveAllProduits()");
		List<Produit> listProduits = ps.retrieveAllProduits();
		Assertions.assertEquals(0, listProduits.size());
		l.info("Out methode testRetrieveAllProduits()");
	}



	@Test
	public void testAddProduit() {
		/*l.info("testAddProduit()");
		Mockito.when(pr.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit produit1 = psm.retrieveProduit(2L);
		Assertions.assertNotNull(produit1);
		l.info("Out methode testAddProduit()");

		 */


		Mockito.when(pr.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
		Produit savedPR= psm.addProduit(produit);

		assertNotNull(savedPR.getLibelleProduit());

		assertTrue(savedPR.getPrix()>0);

		psm.deleteProduit(savedPR.getIdProduit());
	}





	@Test
	public void testRetrieveProduit() {
		l.info("testRetrieveProduit()");
		Mockito.when(pr.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit produit1 = psm.retrieveProduit(2L);
		Assertions.assertNotNull(produit1);
		l.info("Out methode testRetrieveProduit()");
	}


	@Test
	public void testDeleteStock() {
		Produit p = new Produit ((long)5 ,"lll","lll",(float)6.3,new Date());
		p.setIdProduit(Long.valueOf(3));
		psm.addProduit(p);
		psm.deleteProduit(p.getIdProduit());
		assertNull(psm.retrieveProduit(p.getIdProduit()));
	}

	/*
	@Test
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
