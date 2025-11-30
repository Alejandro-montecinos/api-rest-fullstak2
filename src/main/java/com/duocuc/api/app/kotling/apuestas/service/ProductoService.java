package com.duocuc.api.app.kotling.apuestas.service;

import com.duocuc.api.app.kotling.apuestas.model.ProductoModel;
import com.duocuc.api.app.kotling.apuestas.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<ProductoModel> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Optional<ProductoModel> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public ProductoModel crearProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public ProductoModel editarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public boolean eliminarProducto(Integer id) {
        return productoRepository.findById(id).map(p -> {
            productoRepository.deleteById(id);
            return true;              // se eliminó
        }).orElse(false);             // no existía
    }


}
