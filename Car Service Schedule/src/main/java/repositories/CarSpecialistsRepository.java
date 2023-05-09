package repositories;

import models.carSpecialist.CarSpecialist;

import java.util.ArrayList;
import java.util.Collection;

public class CarSpecialistsRepository implements CarSpecialistsRepo{
     Collection<CarSpecialist> allCarSpecialists;

     public CarSpecialistsRepository() {
          this.allCarSpecialists = new ArrayList<>();
     }

     @Override
     public void addCarSpecialist(CarSpecialist carSpecialist) {
         this.allCarSpecialists.add(carSpecialist);
     }

     @Override
     public void removeCarSpecialist(String name) {
         allCarSpecialists.stream()
                 .filter(carSpecialist -> carSpecialist.getName().equals(name))
                 .findFirst()
                 .orElse(null);
     }

     @Override
     public CarSpecialist findSpecialist(String name) {
          return allCarSpecialists.stream()
                  .filter(carSpecialist -> carSpecialist.getName().equals(name))
                  .findFirst()
                  .orElse(null);
     }
}
