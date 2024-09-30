/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecommerce.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ecommerce.app.repository.ProductRepository;
import upeu.edu.pe.ecommerce.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecommerce.infrastructure.entity.UserEntity;
import org.slf4j.*;

/**
 *
 * @author tpp
 */
public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    


    public Iterable<ProductEntity> getProducts() {
       return productRepository.getProducts();
    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity userEntity) {
      return productRepository.getProductsByUser(userEntity);
    }

    public ProductEntity getProductById(Integer id) {
      return productRepository.getProductById(id);
    }

    public ProductEntity saveProduct(ProductEntity productEntity,MultipartFile multipartFile) throws IOException {
        if (productEntity.getId() == null) {
            UserEntity user = new UserEntity();
            user.setId(1);
            productEntity.setDateCreated(LocalDateTime.now());
            productEntity.setDateUpdated(LocalDateTime.now());
            productEntity.setUserEntity(user);
            productEntity.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(productEntity);
        } else {
            ProductEntity productDB = productRepository.getProductById(productEntity.getId());
            log.info("product {}", productDB);

            //actualizar la imagen del producto
            if (multipartFile.isEmpty()) {
                productEntity.setImage(productDB.getImage());
            } else {
                if (!productDB.getImage().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImage());
                }
                productEntity.setImage(uploadFile.upload(multipartFile));
            }

            productEntity.setCode(productDB.getCode());
            productEntity.setUserEntity(productDB.getUserEntity());
            productEntity.setDateCreated(productDB.getDateCreated());
            productEntity.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }

    public boolean deleteProductById(Integer id) {
      return productRepository.deleteProductById(id);
    }
}
