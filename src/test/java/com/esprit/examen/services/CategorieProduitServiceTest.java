package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategorieProduitServiceTest {
    @Autowired
    ICategorieProduitService categorieService;
    @Test
    public void testAddCategorieProduit() {
        Set<Produit> produits = new Set<Produit>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Produit> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Produit produit) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Produit> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        CategorieProduit s = new CategorieProduit(null, "cat1", "test", produits);
        CategorieProduit savedCat=categorieService.addCategorieProduit(s) ;
        assertNotNull(savedCat.getCodeCategorie());
        assertNotNull(savedCat.getLibelleCategorie());

    }



    @Test
    public void testDeleteCategorieProduit() {

        Set<Produit> produits = new Set<Produit>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Produit> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Produit produit) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Produit> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        CategorieProduit s = new CategorieProduit(null, "cat1", "test", produits);
        CategorieProduit savedCat=categorieService.addCategorieProduit(s) ;
        categorieService.deleteCategorieProduit(savedCat.getIdCategorieProduit());
        assertNull(categorieService.retrieveCategorieProduit(savedCat.getIdCategorieProduit()));
    }
}