package hsh.demo.restdocs.order.exception;

public class OrderNotFoundException extends RuntimeException {

    private OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }

    public static OrderNotFoundException create(Long id) {
        return new OrderNotFoundException(id);
    }
}
