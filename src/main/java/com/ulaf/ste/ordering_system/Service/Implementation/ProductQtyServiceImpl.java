package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.ProductQty;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Repository.ProductQtyRepository;
import com.ulaf.ste.ordering_system.Service.ProductQtyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQtyServiceImpl implements ProductQtyService {

    private final ProductQtyRepository productQtyRepository;
    private final CategoryRepository categoryRepository;

    public ProductQtyServiceImpl(ProductQtyRepository productQtyRepository, CategoryRepository categoryRepository) {
        this.productQtyRepository = productQtyRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductQty createProductQty(ProductQty productQty) {
        return productQtyRepository.save(productQty);
    }

    @Override
    public ProductQty getProductQtyById(Long id) throws NotFoundByIdException {
        return productQtyRepository.findById(id).orElseThrow(()->new NotFoundByIdException("ID was not found"));
    }

    @Override
    public List<ProductQty> getAllProductQty() {
        return productQtyRepository.findAll();
    }

    @Override
    public ProductQty updateProductQty(Long id, ProductQty productQty) throws NotFoundByIdException {
        ProductQty existingProduct = this.getProductQtyById(id);

        if (existingProduct != null) {
            existingProduct.setProduct(productQty.getProduct());
            existingProduct.setQuantity(productQty.getQuantity());
            return productQtyRepository.save(existingProduct);
        }

        throw new NotFoundByIdException("ID was not found.");
    }

    @Override
    public void deleteProductQty(Long id) {
        productQtyRepository.deleteById(id);
    }

    @Override
    public List<ProductQty> findAllProductsQtyWithCategory(String category) throws NotFoundByIdException {
        Category existingCategory = categoryRepository.findCategoryByName(category);
        if(existingCategory!=null)
        {
            return productQtyRepository.findProduct_QtyByProductCategory(existingCategory);
        }
        throw new NotFoundByIdException("Category not found.");
    }
}
