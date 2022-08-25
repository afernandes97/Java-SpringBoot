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
}
