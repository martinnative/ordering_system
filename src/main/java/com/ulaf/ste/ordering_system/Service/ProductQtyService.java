package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.ProductQty;

import java.util.List;

public interface ProductQtyService {
    ProductQty createProductQty(ProductQty productQty);
    ProductQty getProductQtyById(Long id) throws NotFoundByIdException;
    List<ProductQty> getAllProductQty();
    ProductQty updateProductQty(Long id, ProductQty productQty) throws NotFoundByIdException;

    void deleteProductQty(Long id);

    List<ProductQty> findAllProductsQtyWithCategory(String category) throws NotFoundByIdException;
}
