package tn.esprit.rh.achat.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {

		@Autowired
		ISecteurActiviteService secteur;
		
		
		@Test
		public void TestAddSecteurActivite() {
			
		SecteurActivite s = secteur.addSecteurActivite( SecteurActivite.builder()
					
					.codeSecteurActivite("gggg")
					.libelleSecteurActivite("fff")
					
					.build());
		assertNotNull(s);
		assertNotNull(s.getIdSecteurActivite());
		
	}
		
			
		
}