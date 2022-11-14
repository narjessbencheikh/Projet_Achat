package tn.esprit.rh.achat;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;



import org.springframework.boot.test.context.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProduitServiceImplTest {
//@SpringBootTest(classes =  ProduitServiceImplTes.class)

	@Mock
	ProduitRepository profRepository;
	@InjectMocks
	ProduitServiceImpl serviceImpl;
	Produit prod = new Produit(1L, "ano", "libe", 25L,null, null );

	List<Produit> listproduit = new ArrayList<Produit>() {
		{
			add(new Produit(2L, "qbc", "libe3", 50L, null, null ));
			add(new Produit(3L, "lko", "lib2", 22222L, null, null  ));
		}
	};
	@Test
	public void testretrieveProduit(){

		Mockito.when(profRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod));

		Assertions.assertNotNull(serviceImpl.retrieveProduit(2L));
	}
	@Test
	void testaddProduit(){

		Mockito.when(profRepository.save(prod)).thenReturn(prod);

		Assertions.assertNotNull(serviceImpl.addProduit(prod));
	}

	@Test
	void testdeleteProduit(){

		serviceImpl.deleteProduit(3L);

		Mockito.verify(profRepository, times(1)).deleteById(3L);

		assertEquals(null, serviceImpl.retrieveProduit(3L));
	}

}