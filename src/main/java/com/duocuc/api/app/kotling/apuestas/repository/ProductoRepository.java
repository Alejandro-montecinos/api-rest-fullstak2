package com.duocuc.api.app.kotling.apuestas.repository;

import com.duocuc.api.app.kotling.apuestas.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<ProductoModel,Integer> {
}
