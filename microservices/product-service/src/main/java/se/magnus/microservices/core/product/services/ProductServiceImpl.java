package se.magnus.microservices.core.product.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.Product;
import se.magnus.api.core.product.ProductService;
import se.magnus.api.exceptions.InvalidInputException;
import se.magnus.util.http.ServiceUtil;
@RestController
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @Override
    public Product getProduct(int productId) {

        LOG.debug("/Product return the found product for product={}",productId);

        if(productId<1){
            throw new InvalidInputException("Invalid productId"+productId);
        }
        if(productId==13){
            throw new InvalidInputException("No product found "+productId);
        }
        return new  Product(productId,"name-"+productId,123,serviceUtil.getServiceAddress());
    }
}
