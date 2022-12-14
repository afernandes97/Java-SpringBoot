package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    //faz a chamada ao repository passando a placa e verificando se ela ja existe
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        //chama o metodo dentro do repository para verificar se  placa do carro que o cliente enviou já existe na base
        return parkingSpotRepository.existsByLicensePlateCar((licensePlateCar));
    }
    //faz a chamada ao repository passando a vaga e verificando se ela ja existe
    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        //faz uma chamada ao metodo dentro de repository passando o parkingSpotNumber
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }
    //faz a chamada ao repository passando o apto/bloco e verificando se ela ja existe
    public boolean existsByApartmentAndBlock(String apartment, String block){
        //faz uma chamada ao metodo dentro de repository passando o apartment/block
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    //serviço responsavel por fazer a busca de todos os dados salvos na base
    //retorna uma lista de parkingspotmodel
    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        //utiliza um metodo pronto : findAll
        return parkingSpotRepository.findAll(pageable);
    }

    //serviço responsavel por realizar a chamada ao repository atraves do findById passando o valor do id recebido do cliente
    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    //servico responsavel por deletar da base
    //@transactional, usando principalmente quando tem relacionamento, por que a caso de errado na transação ele garante que tudo volte ao normal.
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        //utilizando o repository.delete passando o id recebido do cliente
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
