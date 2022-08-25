package com.api.parkingcontrol.services;

import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

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
}
