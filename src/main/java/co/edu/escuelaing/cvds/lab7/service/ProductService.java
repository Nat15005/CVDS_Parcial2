package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository ProductRepository;

    @Autowired
    public ProductService(ProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    public Product addProduct(Product Product) {
        return ProductRepository.save(Product);
    }

    public Product getProduct(int ProductId) {
        // Obtener la lista de empleados que coinciden con el ID proporcionado
        List<Product> Products = ProductRepository.findByProductId(ProductId);

        // Verificar si la lista tiene algún empleado
        if (!Products.isEmpty()) {
            // Si la lista tiene empleados, devolver el primero
            return Products.get(0);
        } else {
            // Si la lista está vacía, no se encontró ningún empleado con el ID proporcionado
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    public Product updateProduct(int id, Product Product) {
        // Obtener la lista de empleados que coinciden con el ID proporcionado
        List<Product> Products = ProductRepository.findByProductId(id);
        // Verificar si la lista no está vacía, lo que significa que el empleado existe
        if (!Products.isEmpty()) {
            // Guardar el empleado actualizado en la base de datos
            return ProductRepository.save(Product);
        } else {
            // Si la lista está vacía, el empleado no existe en la base de datos
            return null;
        }
    }

    public void deleteProduct(int ProductId) {
        // Eliminar el empleado de la base de datos por su ID
        ProductRepository.deleteById(ProductId);
    }
}