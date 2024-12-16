package com.salesianostriana.dam.resteval;

import java.util.List;

public record LugaresDTO(
        long lugaresEncontrados,
        List<Place> lugares
) {
    static public LugaresDTO of(List<Place> lugaresIniciales){
        return new LugaresDTO(lugaresIniciales.size(), lugaresIniciales);
    }
}
