package com.example.api.cars.repository;

import com.example.api.cars.entity.CarModel;
import com.example.api.cars.entity.CarYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarYearRepository extends JpaRepository<CarYear, Integer> {

//    CarYear findByNome(String nome);
}
