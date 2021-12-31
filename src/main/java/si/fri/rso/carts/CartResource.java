package si.fri.rso.carts;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("carts")
public class CartResource {

    @Inject
    private RestProperties cartProperties;

    @GET
    public Response getAllCarts() {
        List<Cart> customers = Database.getCarts();
        return Response.ok(customers).build();
    }

    @GET
    @Path("{cartId}")
    public Response getCart(@PathParam("cartId") String cartId) {
        Cart cart = Database.getCart(cartId);
        return cart != null
                ? Response.ok(cart).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response createCart() {
        Cart cart = new Cart();
        int id = Database.addCart(cart);
        return  Response.ok(id).build();
    }

    @POST
    @Path("{cartId}/{bookId}")
    public Response addNewBook(
            @PathParam("cartId") String cartId,
            @PathParam("bookId") String bookId ) {

        Response bookResponse = ClientBuilder.newClient()
                .target(cartProperties.getCatalogueUrl()).path("books").path(bookId).request().get();

        if (bookResponse.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)
             ) {
            Book b = bookResponse.readEntity(Book.class);

            if(Database.addBook(cartId, b))  return Response.ok(b).build();

            else return Response.status(Response.Status.NOT_FOUND).build();

        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

}
