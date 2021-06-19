package com.example.api.cars.repository;

import com.example.api.cars.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Brand findByNome(String nome);

}