package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;




@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurTest {
	
	@Mock
	OperateurRepository OperateurRepository;
	
	@InjectMocks
	OperateurServiceImpl OperateurService;
	
	
	@Test
	public void testRetrieveOperateur() {
		
		Operateur operateur = new Operateur((long) 123, "maa", "laa","khjghfdm",null);
		operateur.setIdOperateur((long) 123);
		
	Mockito.when(OperateurRepository.findById((long) 123)).thenReturn(Optional.of(operateur));
	OperateurService.retrieveOperateur((long) 123);
	Assertions.assertNotNull(operateur);
	
	System.out.println(operateur); 
	System.out.println(" Retrieve is working correctly...!!");  
	
	}
	
	@Test
	public void createOperateurTest()
	{

		Operateur op = new Operateur((long) 12345, "mmmaa", "lllaa","hgdlehg",null);
		op.setIdOperateur((long) 12345);
		
		OperateurService.addOperateur(op);
		verify(OperateurRepository, times(1)).save(op);
		System.out.println(op); 
		System.out.println(" Create is working...!!");  
	}
	
	
	
	@Test
	public void getAllOperateursTest()
	{
		List<Operateur> OperateurList = new ArrayList<Operateur>() {

			{
		add(new Operateur(null, "aaa", "lll","opaapaa",null));
		add(new Operateur(null, "ccc", "moljl","kjgfkj",null));
		add(new Operateur(null, "kkkkk", "ppp","nhgjgh",null));
			}};
			
			
		when(OperateurService.retrieveAllOperateurs()).thenReturn(OperateurList);
		//test
		List<Operateur> sList = OperateurService.retrieveAllOperateurs();
		assertEquals(3, sList.size());
		System.out.println(" Retrieve all is working correctly...!!");  
	
	}
	

	
	
	@Test
	public void TestDeleteOperateur(){

	Operateur op1 = new Operateur((long) 567, "aaacc", "lll","opaaaa",null);
	op1.setIdOperateur((long) 567);
	
	Mockito.lenient().when(OperateurRepository.findById(op1.getIdOperateur())).thenReturn(Optional.of(op1));

	OperateurService.deleteOperateur((long) 567);
	verify(OperateurRepository).deleteById(op1.getIdOperateur());
	
	System.out.println(op1);
	System.out.println(" Delete is working correctly...!!");  
		}
	
	
	
	

	
	}
	
	
	
	
	

