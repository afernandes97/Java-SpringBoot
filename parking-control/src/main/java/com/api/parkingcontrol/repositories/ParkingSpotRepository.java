package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//Criando a interface para o repository, utilizando da bilbioteca JpaRepository ele possui varios metodos prontos para utilizar transações com banco de dados.
@Repository
public interface ParkingSpotRepository  extends JpaRepository<ParkingSpotModel, UUID> {
    //atraves do jpa verificamos se a placa passada pelo cliente(licensePlateCar) já existe na base
    boolean existsByLicensePlateCar(String licensePlateCar);
    //atraves do jpa verificamos se a vaga passada pelo cliente(parkingSpotNumber) já existe na base
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    //atraves do jpa verificamos se o apartamento/bloco passado pelo cliente(apartment block) já existe na base
    boolean existsByApartmentAndBlock(String apartment, String block);
}
