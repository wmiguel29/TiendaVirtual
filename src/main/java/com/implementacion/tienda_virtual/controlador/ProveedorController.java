package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Proveedor;
import com.implementacion.tienda_virtual.services.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping ("/proveedores")
    public List<Proveedor> findAll(){
        return proveedorService.findAll();
    }

    @GetMapping ("/proveedores/{idProveedores}")
    public Proveedor findByID(@PathVariable Long idProveedores){
        return proveedorService.findById(idProveedores);
    }

    @DeleteMapping ("/proveedores/{idProveedores}")
    public void delete(@PathVariable Long idProveedores){
        proveedorService.delete(idProveedores);
    }

    @PostMapping ("/proveedores")
    public Proveedor save(@RequestBody Proveedor proveedor){
        return proveedorService.save(proveedor);
    }

    @PutMapping ("/proveedores/{idProveedores}")
    public Proveedor update(@RequestBody Proveedor proveedor, @PathVariable Long idProveedores){
        Proveedor actual = proveedorService.findById(idProveedores);
        actual.setNombre(proveedor.getNombre());
        actual.setTelefono(proveedor.getTelefono());
        actual.setEmail(proveedor.getEmail());

        return proveedorService.save(actual);
    }
}
