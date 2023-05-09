package repositories;

import models.carSpecialist.CarSpecialist;
import models.carSpecialist.CarSpecialists;

public interface CarSpecialistsRepo {
    void addCarSpecialist(CarSpecialist carSpecialist);

    void removeCarSpecialist(String name);

    CarSpecialist findSpecialist(String name);
}
