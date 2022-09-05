package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.dao.IFacturaDAO;
import com.implementacion.tienda_virtual.entity.Cliente;
import com.implementacion.tienda_virtual.entity.Factura;
import com.implementacion.tienda_virtual.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/facturas")
    public List<Factura> findAll(){return facturaService.findAll();}

    @GetMapping("/facturas/{idfactura}")
    public Factura findById(@PathVariable Long idFactura){
        return facturaService.findById(idFactura);
    }

    @DeleteMapping("/facturas/{idfactura}")
    public void delete(@PathVariable Long idFactura){
        facturaService.delete(idFactura);
    }

    @PostMapping("/facturas")
    public Factura save(@RequestBody Factura factura){
        return facturaService.save(factura);
    }


}
