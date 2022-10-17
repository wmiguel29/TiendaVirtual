package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Sucursal;
import com.implementacion.tienda_virtual.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SucursalControlador {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping("/sucursales")
    public List<Sucursal> findAll(){
        return sucursalService.findAll();
    }

    @GetMapping("/sucursales/{idSucursales}")
    public Sucursal findByID(@PathVariable Long idSucursales){
        return sucursalService.findById(idSucursales);
    }

    @DeleteMapping("/sucursales/{idSucursales}")
    public void delete(@PathVariable Long idSucursales){
        sucursalService.delete(idSucursales);
    }

    @PostMapping("/sucursales")
    public Sucursal save(@RequestBody Sucursal sucursal){
        return sucursalService.save(sucursal);
    }

    @PutMapping("/sucursales/{idSucursales}")
    public Sucursal update(@RequestBody Sucursal sucursal, @PathVariable Long idSucursales){
        Sucursal actual = sucursalService.findById(idSucursales);
        actual.setNombre(sucursal.getNombre());
        actual.setDireccion(sucursal.getDireccion());

        return sucursalService.save(actual);
    }
}
