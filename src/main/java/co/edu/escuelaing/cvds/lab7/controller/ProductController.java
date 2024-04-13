package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService ProductService;

    @Autowired
    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return ProductService.getAllProducts();
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable int id) {
        return ProductService.getProduct(id);
    }
    @DeleteMapping("/product/{id}")
    @ResponseBody
    public void delProduct(@PathVariable int id){
        ProductService.deleteProduct(id);
    }
    @PutMapping("/product/{id}")
    @ResponseBody
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return ProductService.updateProduct(id, updatedProduct);
    }
    @PostMapping("/product")
    @ResponseBody
    public Product createProduct(@RequestBody Product Product) {
        return ProductService.addProduct(Product);
    }

    @PatchMapping(value = "/product/{id}", consumes = "application/json")

    @ResponseBody
    public Product patchProduct(@PathVariable int id, @RequestBody Product partialProduct) {
        // Obtener el producto existente
        Product existingProduct = ProductService.getProduct(id);

        // Actualizar los atributos del producto existente con los valores proporcionados
        if (partialProduct.getName() != null) {
            existingProduct.setName(partialProduct.getName());
        }
        if (partialProduct.getDescription() != null) {
            existingProduct.setDescription(partialProduct.getDescription());
        }
        if (partialProduct.getCategory() != null) {
            existingProduct.setCategory(partialProduct.getCategory());
        }
        if (partialProduct.getRating() != -1) { // Usamos -1 como valor para indicar "no especificado"
            existingProduct.setRating(partialProduct.getRating());
        }
        if (partialProduct.getPrice() != -1) { // Usamos -1 como valor para indicar "no especificado"
            existingProduct.setPrice(partialProduct.getPrice());
        }
        if (partialProduct.getQuantity() != -1) { // Usamos -1 como valor para indicar "no especificado"
            existingProduct.setQuantity(partialProduct.getQuantity());
        }

        // Actualizar el producto en la base de datos
        Product updatedProduct = ProductService.updateProduct(id, existingProduct);

        // Devolver el producto actualizado
        return updatedProduct;
    }


}

