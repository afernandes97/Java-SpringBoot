package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {
    //opção via Autowired
    //esta dizendo ao spring que em determinados momentos devera injetar uma dependencia de ParkingSpotRepository dentro de ParkingSpotService
    //@Autowired
    //ParkingSpotRepository parkingSpotRepository;


    //opção com construtor
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    //@transactional, usando principalmente quando tem relacionamento, por que a caso de errado na transação ele garante que tudo volte ao normal.
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        //utilizando a biblioteca do jpa e o metodo save dentro dela passando o parkingSpotModel
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        //chama o metodo dentro do repository para verificar se  placa do carro que o cliente enviou já existe na base
        return parkingSpotRepository.existsByLicensePlateCar((licensePlateCar));
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        //faz uma chamada ao metodo dentro de repository passando o parkingSpotNumber
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block){
        //faz uma chamada ao metodo dentro de repository passando o apartment/block
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }
}
