package com.implementacion.tienda_virtual.controlador;

import com.implementacion.tienda_virtual.entity.Producto;
import com.implementacion.tienda_virtual.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/productos/{idProductos}")
    public Producto findById(@PathVariable Long idProductos) {
        return productoService.findById(idProductos);
    }

    @DeleteMapping("/productos/{idProductos}")
    public void delete(@PathVariable Long idProductos){
        productoService.delete(idProductos);
    }

    @PostMapping("/productos")
    public Producto save(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @PutMapping("/productos/{idProductos}")
    public Producto update(@RequestBody Producto producto, @PathVariable Long idProductos) {
        Producto actual = productoService.findById(idProductos);
        actual.setNombre(producto.getNombre());
        actual.setPrecio(producto.getPrecio());
        actual.setDescripcion(producto.getDescripcion());

        return productoService.save(actual);
    }
}
