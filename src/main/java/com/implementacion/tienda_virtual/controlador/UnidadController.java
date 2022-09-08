package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Unidad;
import com.implementacion.tienda_virtual.services.IUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UnidadController {

    @Autowired
    private IUnidadService unidadService;

    @GetMapping("/unidades")
    public List<Unidad> findAll(){
        return unidadService.findAll();
    }

    @GetMapping("/unidades/{idUnidades}")
    public Unidad findByID(@PathVariable Long idunidades){
        return unidadService.findById(idunidades);
    }

    @DeleteMapping("/unidades/{idUnidades}")
    public void delete(@PathVariable Long idunidades){
        unidadService.delete(idunidades);
    }

    @PostMapping("/unidades")
    public Unidad save(@RequestBody Unidad unidad){
        return unidadService.save(unidad);
    }

    @PutMapping("/unidades/{idUnidades}")
    public Unidad update(@RequestBody Unidad unidad, @PathVariable Long idUnidades){
        Unidad actual = unidadService.findById(idUnidades);
        actual.setIdsucursal(unidad.getIdsucursal());
        actual.setIdproducto(unidad.getIdproducto());
        actual.setIdproveedor(unidad.getIdproveedor());


        return unidadService.save(actual);
    }
}
