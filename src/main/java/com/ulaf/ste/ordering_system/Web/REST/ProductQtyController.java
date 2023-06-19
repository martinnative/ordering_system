package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.ProductQty;
import com.ulaf.ste.ordering_system.Service.ProductQtyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productqtys")
public class ProductQtyController {
    private final ProductQtyService productQtyService;

    public ProductQtyController(ProductQtyService productQtyService) {
        this.productQtyService = productQtyService;
    }

    @GetMapping
    public ResponseEntity<List<ProductQty>> getAllProductQtys() {
        List<ProductQty> productQtys = productQtyService.getAllProductQty();
        return ResponseEntity.ok(productQtys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductQty> getProductQtyById(@PathVariable Long id) throws NotFoundByIdException {
        ProductQty productQty = productQtyService.getProductQtyById(id);
        if (productQty != null) {
            return ResponseEntity.ok(productQty);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<ProductQty> createProductQty(@RequestBody ProductQty productQty) {
        ProductQty createdProduct = productQtyService.createProductQty(productQty);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductQty> updateProduct(@PathVariable Long id, @RequestBody ProductQty productQty) throws NotFoundByIdException {
        ProductQty updatedProduct = productQtyService.updateProductQty(id, productQty);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductQty(@PathVariable Long id) {
        productQtyService.deleteProductQty(id);
        return ResponseEntity.noContent().build();
    }
}
