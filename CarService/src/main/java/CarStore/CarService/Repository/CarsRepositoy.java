package CarStore.CarService.Repository;

import CarStore.CarService.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepositoy extends JpaRepository<Cars, Integer> {
    Optional<Cars> findById(Long id);
}
