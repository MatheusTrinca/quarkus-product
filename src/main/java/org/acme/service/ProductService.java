package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ProductDto;
import org.acme.entitiy.ProductEntity;
import org.acme.repository.ProductRepository;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapProductToDto).toList();
    }

    public void createProduct(ProductDto productDto) {
        productRepository.persist(mapDtoToProduct(productDto));
    }

    public void changeProduct(Long id, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setModel(productDto.getModel());
        productEntity.setPrice(productDto.getPrice());

        productRepository.persist(productEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto mapProductToDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();

        productDto.setName(productEntity.getName());
        productDto.setDescription(productEntity.getDescription());
        productDto.setCategory(productEntity.getCategory());
        productDto.setModel(productEntity.getModel());
        productDto.setPrice(productEntity.getPrice());

        return productDto;
    }

    private ProductEntity mapDtoToProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDto.getName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setModel(productDto.getModel());
        productEntity.setPrice(productDto.getPrice());

        return productEntity;
    }


}
