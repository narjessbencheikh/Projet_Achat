package tn.esprit.rh.achat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import jdk.internal.org.jline.utils.Log;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

@SpringBootTest
public class ProduitServiceImplTest {
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	

	
	
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
		
	}

	
	
	

}
