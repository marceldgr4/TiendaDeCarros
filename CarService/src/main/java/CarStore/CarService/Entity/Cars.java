package CarStore.CarService.Entity;

import jakarta.persistence.*;
import lombok.*;


    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @Builder
    @Table(name="Cars")
    public class Cars {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id_Cars;
        @Column(nullable = false)
        private String Model;

        @Column(nullable = false)
        private  String Vehicle_brand;

        @Column(nullable = false)
        private String Availability;

        public Cars UpdateCars(Cars cars) {
            return new Cars(this.Id_Cars, cars.Model, cars.Vehicle_brand, cars.Availability);
        }
}
