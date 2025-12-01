package com.duocuc.api.app.kotling.apuestas.controller;


import com.duocuc.api.app.kotling.apuestas.model.ProductoModel;
import com.duocuc.api.app.kotling.apuestas.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://3.239.91.151"}) // Vite
@RestController
@RequestMapping("/api/pokemon/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductoModel> getProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> getProductoId(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoModel> postProducto(@RequestBody ProductoModel producto) {
        ProductoModel nuevo = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoModel> putProducto(@PathVariable Integer id,
                                                     @RequestBody ProductoModel producto) {
        return productoService.obtenerProductoPorId(id)
                .map(p -> {
                    producto.setId(id);
                    ProductoModel actualizado = productoService.editarProducto(producto);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        boolean eliminado = productoService.eliminarProducto(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();   // 204 si se borró
        } else {
            return ResponseEntity.notFound().build();    // 404 si no existía
        }
    }

}
