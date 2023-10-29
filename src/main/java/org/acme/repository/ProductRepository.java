package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entitiy.ProductEntity;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {}
