package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.FacturaUnidad;
import com.implementacion.tienda_virtual.services.IFacturaUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturaUnidad")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class FacturaUnidadController {

    @Autowired
    private IFacturaUnidadService facturaUnidadService;

    @GetMapping("/facturaUnidad")
    public List<FacturaUnidad> findAll(){
        return facturaUnidadService.findAll();
    }

    @GetMapping("/facturaUnidad/{idFacturaUnidad}")
    public FacturaUnidad findByIDs(@PathVariable Long idFacturaUnidad,@PathVariable Long idFacturaUnidad2){
        return facturaUnidadService.findByIds(idFacturaUnidad, idFacturaUnidad2);
    }

    @DeleteMapping("/facturaUnidad/{idFacturaUnidad}")
    public void delete(@PathVariable Long idFacturaUnidad,@PathVariable Long idFacturaUnidad2){
        facturaUnidadService.delete(idFacturaUnidad, idFacturaUnidad2);
    }

    @PostMapping("/facturaUnidad")
    public FacturaUnidad save(@RequestBody FacturaUnidad facturaUnidad){
        return facturaUnidadService.save(facturaUnidad);
    }



}
