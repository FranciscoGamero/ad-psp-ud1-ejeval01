package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public ResponseEntity<List<LugaresDTO>> listarLugares() {
        List<LugaresDTO> data = Collections.singletonList(LugaresDTO.of(placeRepository.getAll()));
        if (data.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(data);
    }

    public ResponseEntity<Place> buscarLugar(Long id) {
        Optional<Place> lugar = placeRepository.get(id);
        if (lugar.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(lugar.get());
    }
    public ResponseEntity<Place> crearLugar(Place lugar) {
        return ResponseEntity.ok(placeRepository.add(lugar));
    }
    public ResponseEntity<Place> editarLugar(Long id, Place lugar) {
        Optional<Place> aEditar = placeRepository.get(id);
        if(aEditar.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(placeRepository.edit(id, lugar).get());
    }
    public ResponseEntity<Place> borrarLugar(Long id) {
        placeRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    public ResponseEntity<Place> agregarTag(Long id, String nuevo_tag) {
        if(placeRepository.get(id).isEmpty())
        return ResponseEntity.notFound().build();
        else
            placeRepository.get(id).get().addTag(nuevo_tag);
        return ResponseEntity.ok(placeRepository.get(id).get());
    }
    public ResponseEntity<Place> eliminarTag(Long id, String tag) {
        if(placeRepository.get(id).isEmpty())
            return ResponseEntity.notFound().build();
        else
            placeRepository.get(id).get().removeTag(tag);
        return ResponseEntity.ok(placeRepository.get(id).get());
    }
}
