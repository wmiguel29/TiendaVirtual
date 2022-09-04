package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Empleado;
import com.implementacion.tienda_virtual.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class EmpleadoController {
    @Autowired
    public IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> findAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/empleados/{idEmpleados}")
    public Empleado findById(@PathVariable long idEmpleados) {
        return empleadoService.findById(idEmpleados);
    }

    @PostMapping("/empleados")
    public Empleado save(@RequestBody Empleado empleado) {
        return empleadoService.save(empleado);
    }

    @DeleteMapping("/empleados/{idEmpleados}")
    public void delete(@PathVariable long idEmpleados) {
        empleadoService.delete(idEmpleados);
    }


}
