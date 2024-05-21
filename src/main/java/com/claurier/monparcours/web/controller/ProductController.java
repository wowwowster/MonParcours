package com.claurier.monparcours.web.controller;

import com.claurier.monparcours.model.Product;
import com.claurier.monparcours.web.dao.ProductDao;
import com.claurier.monparcours.web.exceptions.ProduitGratuitException;
import com.claurier.monparcours.web.exceptions.ProduitIntrouvableException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController
{

    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @GetMapping(value = "/Produits")
    public MappingJacksonValue listeProduits()
    {
        Iterable<Product> produits = productDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    //Récupérer un produit par son Id
    @Operation(summary = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id)
    {
        Product produit = productDao.findById(id);
        if (produit == null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
        return produit;

    }

    @GetMapping(value = "test/produits/{prixLimit}")
    public List<Product> testeDeRequetes(@PathVariable int prixLimit)
    {
        return productDao.findByPrixGreaterThan(prixLimit);
    }

    //ajouter un produit
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Product product)
    {
        if (product.getPrix() == 0) throw new ProduitGratuitException("Ce produit n'est pas gratuit. Veuillez entrer un prix de vente > 0");
        Product productAdded = productDao.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productAdded.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id)
    {
        productDao.deleteById(id);

    }

    @PutMapping(value = "/Produits")
    public void updateProduit(@RequestBody Product product)
    {
        productDao.save(product);
    }

    @GetMapping(value = "Produits/MargeProduit")
    public Map<Product, Integer> calculerMargeProduit()
    {
        Map<Product, Integer> produitsEtMarges = new HashMap<>();
        List<Product> produits = productDao.findAll();
        for (Product produit : produits)
        {
            produitsEtMarges.put(produit, produit.getPrix() - produit.getPrixAchat());
        }
        return produitsEtMarges;
    }

    @GetMapping("/trierProduitsParOrdreAlphabetique")
    public List<Product> trierProduitsParOrdreAlphabetique()
    {
        return productDao.findAllByOrderByNomAsc();
    }
}
