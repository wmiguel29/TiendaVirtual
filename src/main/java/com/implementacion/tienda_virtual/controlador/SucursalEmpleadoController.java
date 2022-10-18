package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.SucursalEmpleado;
import com.implementacion.tienda_virtual.services.ISucursalEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursalEmpleado")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SucursalEmpleadoController {

    @Autowired
    private ISucursalEmpleado sucursalEmpleadoService;

    @GetMapping("/sucursalEmpleado")
    public List<SucursalEmpleado> findAll(){
        return sucursalEmpleadoService.findAll();
    }

    @GetMapping("/sucursalEmpleado/{idSucursalEmpleado}")
    public SucursalEmpleado findByIDs(@PathVariable Long idSucursalEmpleado, @PathVariable Long idSucursalEmpleado2){
        return sucursalEmpleadoService.findByIds(idSucursalEmpleado, idSucursalEmpleado2);
    }

    @DeleteMapping("/sucursalEmpleado/{idSucursalEmpleado}")
    public void delete(@PathVariable Long idSucursalEmpleado, @PathVariable Long idSucursalEmpleado2){
        sucursalEmpleadoService.delete(idSucursalEmpleado, idSucursalEmpleado2);
    }

    @PostMapping("/sucursalEmpleado")
    public SucursalEmpleado save(@RequestBody SucursalEmpleado sucursalEmpleado){
        return sucursalEmpleadoService.save(sucursalEmpleado);
    }
}
