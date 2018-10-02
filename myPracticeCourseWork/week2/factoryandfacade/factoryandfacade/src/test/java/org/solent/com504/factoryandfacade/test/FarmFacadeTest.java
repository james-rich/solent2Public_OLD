package org.solent.com504.factoryandfacade.test;

import org.junit.Test;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author gallenc
 */
public class FarmFacadeTest {

    @Test
    public void FarmFacadeTest() {
        System.out.println("\n++++++++++++++++++++\nstart of FarmFacadeTest()");
        
        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);

        farmFacade.addCat("cat");
        farmFacade.addDog("dogo");
        farmFacade.addCow("milky");

        // WHAT TESTS WOULD YOU CREATE HERE TO SET UP AND TEST THE FARM FACADE?
        System.out.println("Length of animalList: " 
                + farmFacade.getAllAnimals().size() 
                + "\n====================\nstart test as Animal without casting");
        for(Animal animal: farmFacade.getAllAnimals()){

            System.out.println(animal.toString());

            System.out.println("animal '" + animal.getName()
                    + "' makes this sound '" + animal.getSound()
                    + " because it is a " + animal.getClass().getSimpleName()
                    + " implemented by " + animal.getClass().getTypeName());
        }
        System.out.println("end test as Animal without casting\n====================\n");

        System.out.println("\n====================\ntest as Animal with casting");

        for(Object object: farmFacade.getAllAnimals()){

            System.out.println(object.toString());

            Animal animal = (Animal) object;

            System.out.println(animal.toString());

            System.out.println("animal '" + animal.getName()
                    + "' makes this sound '" + animal.getSound()
                    + " because it is a " + animal.getClass().getSimpleName()
                    + " implemented by " + animal.getClass().getTypeName());
        }
        System.out.println("end test as Animal with casting\n====================\n");


        System.out.println("end of FarmFacadeTest()\n-------------------\n");
    }

}
