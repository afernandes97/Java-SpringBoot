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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        //verifica se a placa do carro ja existe na lista, atraves de uma chamada ao service que retorna um valor boleean
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }
        //verifica se a vaga do carro ja existe na lista, atraves de uma chamada ao service que retorna um valor boleean
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }
        //verifica se o bloco ou apto ja existe na lista, atraves de uma chamada ao service que retorna um valor boleean
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

    //Criando o metodo get
    @GetMapping
    //ResponseEntity para montar a resposta, no caso sera uma lista de parkingSpotModel
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        //no corpo da resposta devolve a lista realizada atraves de uma chamada ao service com metodo findall
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }


    //criando metodo getOne]
    //definindo na uri que sera passado um id na chamada, ficaria parking-spot/id
    @GetMapping("/{id}")
    //O responseEntity retornado sera um Objeto,para melhor controle de resposta
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){ //@PathVariable para passar um valor, definindo o nome dele no value(que sera o mesmo do getmapping), e o tipo dele
        //apos acionado o metodo, atraves da chamada do findById passando o id recebido do cliente
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        //verificando se o parkingSpotModelOptional não estiver presente, construimos o responseentity passando notfound no status e avisando o cliente que a vaga nao existe
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
        }
        //caso sucesso retorna ao cliente status ok e retorna o model do optional atraves do get
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }
}
