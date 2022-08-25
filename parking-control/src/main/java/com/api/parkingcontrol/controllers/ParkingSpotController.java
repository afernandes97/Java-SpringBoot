package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    //inserindo o service atraves de um construtor
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    //Criando o metodo post
    @PostMapping
    //ResponseEntity para montar a resposta
    //passando com parametro o dto de parkingspotdto, que vao dizer quais campos que o cliente vai enviar
    //@requestbody para tratamento de json
    //@valid para dizer que as validações em dto sejam validas
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        //validações
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }

        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }

        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block");
        }
        //atribuindo/convertendo os dados de entrada(parkingspotdto) a um model(parkingspotmodel)
        var parkingSpotModel = new ParkingSpotModel();
        //converter o dto em model utilizando o BeanUtils.copyProperties, parkingSpotDto converte para parkingSpotModel
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        //a data não é enviada pelo cliente, ela é setada através do localdatetime.now ja formatando em utc
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        //construindo a resposta, utilizando o responseentity.status, passando o status e no body passando o retorno do metodo save
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }
}
