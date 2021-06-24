package com.example.api.cars.repository;

import com.example.api.cars.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    CarModel findByNome(String nome);
    Optional<CarModel> findByCodigoAndBrandCodigo(Integer codigo, Integer brandCodigo);

}
