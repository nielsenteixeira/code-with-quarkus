package org.nielsen;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> getAll() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public void create(ProductDTO productDTO) {
        var product = new Product();
        product.setName(productDTO.name);
        product.setValue(productDTO.value);
        Product.persist(product);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void update(@PathParam("id") Long id, ProductDTO productDTO) {
        Optional<Product> productOpt = Product.findByIdOptional(id);
        if (productOpt.isPresent()) {
            var product = productOpt.get();
            product.setName(productDTO.name);
            product.setValue(productDTO.value);
            Product.persist(product);
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        var productOpt = Product.findByIdOptional(id);
        productOpt.ifPresentOrElse(PanacheEntityBase::delete, () -> { throw new NotFoundException(); });
    }

}
