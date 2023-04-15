package com.esprit.examen.services;
import static org.junit.Assert.assertNotNull;

import java.util.*;

import com.esprit.examen.entities.Produit;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

@SpringBootTest
public class CategorieProduitServiceTestMockito {


    @Mock
    CategorieProduitRepository catRepo;

    @InjectMocks
    CategorieProduitServiceImpl catService;


    @Test
    public void testRetrieveCatkById()
    {
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
        CategorieProduit catproduit = new CategorieProduit(null, "cat1", "test", produits);

        Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
        assertNotNull(catService.retrieveCategorieProduit(1L));
    }

    @Test
    public void testRetrieveAllCategories()
    {
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
        CategorieProduit catproduit1 = new CategorieProduit(null, "cat1", "test", produits);
        CategorieProduit catproduit2 = new CategorieProduit(null, "cat1", "test", produits);
        CategorieProduit catproduit3 = new CategorieProduit(null, "cat1", "test", produits);
        List<CategorieProduit> prods= new ArrayList<CategorieProduit>();
        prods.add(catproduit1);
        prods.add(catproduit2);
        prods.add(catproduit3);
        Mockito.when(catRepo.findAll()).thenReturn(prods);
        assertNotNull(catService.retrieveAllCategorieProduits());
    }


    @Test
    public void testUpdateCat()
    {
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
        CategorieProduit catproduit = new CategorieProduit(null, "cat1", "test", produits);


        Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
        catproduit.setCodeCategorie("136 JF");
        catproduit.setLibelleCategorie("categorie testupdate");
        Mockito.when(catRepo.save(catproduit)).thenReturn(catproduit);


    }


    @Test
    public void testCreateCat()
    {
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
        CategorieProduit catproduit = new CategorieProduit(null, "cat1", "test", produits);
        catService.addCategorieProduit(catproduit);

        Mockito.when(catRepo.save(catproduit)).thenReturn(catproduit);
        assertNotNull(catService.addCategorieProduit(catproduit));
    }

    @Test
    public void deleteCatTest() {
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
        CategorieProduit catproduit = new CategorieProduit(null, "cat1", "test", produits);
        Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(catproduit));
        catService.deleteCategorieProduit(catproduit.getIdCategorieProduit());;


    }



}
