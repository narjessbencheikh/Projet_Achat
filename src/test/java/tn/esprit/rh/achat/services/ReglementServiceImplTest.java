package tn.esprit.rh.achat.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




@ExtendWith(MockitoExtension.class)
@SpringBootTest()
public class ReglementServiceImplTest {
	private static final Logger l =LogManager.getLogger(ReglementServiceImplTest.class);
	@Autowired
	ReglementServiceImpl rs;
	
	@InjectMocks
	ReglementServiceImpl rsm;
	Reglement reglement = new Reglement(14f, 9f, true, new Date(),new Facture());
	
	List<Reglement> listReglements = new ArrayList<Reglement>() {
		{
		add(new Reglement(15f, 10f, true, new Date(),new Facture()));
		add(new Reglement(17f, 18f, false, new Date(),new Facture()));
		}
	};
	@Mock
	ReglementRepository rr;
	
	@Test
	public void testRetrieveAllReglements() {
		l.info("testRetrieveAllReglements()");
		List<Reglement> listReglements = rs.retrieveAllReglements();
		Assertions.assertEquals(0, listReglements.size());
		l.info("Out methode testRetrieveAllReglements()");
	}
	
	@Test
	public void testAddReglement() {
		l.info("testAddReglement()");
		Mockito.when(rr.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
		Reglement reglement1 = rsm.retrieveReglement(2L);
		Assertions.assertNotNull(reglement1);
		l.info("Out methode testAddReglement()");
	}
	@Test
	public void testRetrieveReglement() {
		l.info("testRetrieveReglement()");
		Mockito.when(rr.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
		Reglement reglement1 = rsm.retrieveReglement(2L);
		Assertions.assertNotNull(reglement1);
		l.info("Out methode testRetrieveReglement()");
	}
	@Test
	public void testRetrieveReglementByFacture() {
		l.info("testRetrieveReglementByFacture()");
		List<Reglement> listReglements = rs.retrieveReglementByFacture(1L);
		Assertions.assertEquals(0, listReglements.size());
		l.info("Out methode testRetrieveReglementByFacture()");
	}
}
