package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//Criando a interface para o repository, utilizando da bilbioteca JpaRepository ele possui varios metodos prontos para utilizar transações com banco de dados.
@Repository
public interface ParkingSpotRepository  extends JpaRepository<ParkingSpotModel, UUID> {

}
