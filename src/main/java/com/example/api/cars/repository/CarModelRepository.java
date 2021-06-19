package com.example.api.cars.repository;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    CarModel findByNome(String nome);

}
