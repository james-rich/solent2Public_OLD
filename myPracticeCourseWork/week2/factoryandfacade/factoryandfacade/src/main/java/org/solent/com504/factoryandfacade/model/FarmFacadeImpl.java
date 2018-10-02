/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3richj71
 */
public class FarmFacadeImpl implements FarmFacade{

    List<Animal> animalList = new ArrayList();
        
    @Override
    public List<Animal> getAllAnimals() {
        return animalList;
    }

    @Override
    public void addDog(String name) {
        Animal animal = AnimalObjectFactory.createDog();
        animal.setName(name);
        animalList.add(animal);
    }

    @Override
    public void addCat(String name) {
        Animal animal = AnimalObjectFactory.createCat();
        animal.setName(name);
        animalList.add(animal);
    }

    @Override
    public void addCow(String name) {
        Animal animal = AnimalObjectFactory.createCow();
        animal.setName(name);
        animalList.add(animal);
    }
    
}
