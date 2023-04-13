package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
    @Autowired
    IOperateurService operateurService;

    @Test
    public void testAddProduit() {

        Operateur s = new Operateur("1nom","prenom", "operateurpwd");
        Operateur savedOp=operateurService.addOperateur(s) ;
        assertNotNull(savedOp.getNom());
        assertNotNull(savedOp.getPrenom());
        assertNotNull(savedOp.getPassword());
        operateurService.deleteOperateur(savedOp.getIdOperateur());
    }

    @Test
    public void testAddProductOptimized() {

        Operateur s = new Operateur("1nom","prenom", "operateur");
        Operateur savedOp=operateurService.addOperateur(s) ;
        assertNotNull(savedOp.getIdOperateur());
        assertSame("operateur", savedOp.getNom());
        assertSame("1nom", savedOp.getPrenom());
        assertSame("prenom", savedOp.getPassword());
        operateurService.deleteOperateur(savedOp.getIdOperateur());
    }
    @Test
    public void testDeleteStock() {

        Operateur s = new Operateur("1nom","prenom", "operateur");
        Operateur savedOp=operateurService.addOperateur(s) ;
        operateurService.deleteOperateur(savedOp.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(savedOp.getIdOperateur()));
    }
}
