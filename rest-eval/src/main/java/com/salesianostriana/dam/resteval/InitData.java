package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PlaceService placeService;

    @PostConstruct
    public void Init() {

        placeService.crearLugar(Place.builder().name("El pizkito")
                .address("Calle Logroño")
                .coords("41,33521 -541.23442")
                .desc("Bocateria local en Mairena del Aljarafe")
                .build());

        placeService.crearLugar(Place.builder().name("La Unión")
                .address("CalleFalsa123")
                .coords("124.21234 -567.7686")
                .desc("Restaurante familiar")
                .build());
    }

}
