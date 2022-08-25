package com.api.parkingcontrol.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

//define que o modelo abaixo sera um bean utilizando entity, para gerar de forma automatica a tabela
@Entity
//define o nome que sera atribuido a tabela criada
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    private  static final long serialVersionUID = 1L;

    //o modelo abaixo ira representar o controle de vagas de um condominio, sendo cada vaga tendo um responsavel, cada apto tem direito a uma vaga

    @Id    //@Id = identificador
    @GeneratedValue(strategy = GenerationType.AUTO)    //id gerado de forma automatica, não precisa passar na req
    private UUID id;     //UUID = Identificador apropriado para microservices
    @Column(nullable = false, unique = true, length = 10)     //@column define atributos da coluna
    private String parkingSpotNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false,length = 70)
    private String brandCar;
    @Column(nullable = false,length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false,length = 130)
    private String responsibleName;
    @Column(nullable = false,length = 30)
    private String apartment;
    @Column(nullable = false,length = 30)
    private String block;


    //Mapeamento dos get e set
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
