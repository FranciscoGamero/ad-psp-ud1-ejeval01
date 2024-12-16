package com.salesianostriana.dam.resteval;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place/")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<LugaresDTO>> listarLugares() {
       return placeService.listarLugares();
    }

    @GetMapping("{id}")
    public ResponseEntity<Place> buscarLugar(@PathVariable Long id) {
        return placeService.buscarLugar(id);
    }
    @PostMapping
    public ResponseEntity<Place> crearLugar(@RequestBody Place lugar) {
        return placeService.crearLugar(lugar);
    }
    @PutMapping("{id}")
    public ResponseEntity<Place> editarLugar(@PathVariable Long id, @RequestBody Place lugar) {
        return placeService.editarLugar(id, lugar);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Place> borrarLugar(@PathVariable Long id) {
        return placeService.borrarLugar(id);
    }

    @PutMapping("{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Place> agregarTag(@PathVariable Long id, @PathVariable String nuevo_tag){
        return placeService.agregarTag(id, nuevo_tag);
    }
    @PutMapping("{id}/tag/del/{nuevo_tag}")
    public ResponseEntity<Place> eliminar(@PathVariable Long id, @PathVariable String nuevo_tag){
        return placeService.eliminarTag(id, nuevo_tag);
    }
}
