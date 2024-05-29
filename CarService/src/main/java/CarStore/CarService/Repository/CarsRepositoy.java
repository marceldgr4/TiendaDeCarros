package CarStore.CarService.Repository;

import CarStore.CarService.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepositoy extends JpaRepository<Cars, Integer> {
    Optional<Cars> findById(Long id);

    @Query("SELECT c FROM Cars c WHERE c.Availability =true ")
    List<Cars> findAllByAvailability();
}
