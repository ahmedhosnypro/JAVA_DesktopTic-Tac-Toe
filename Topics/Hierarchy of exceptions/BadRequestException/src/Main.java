import java.io.IOException;

// update the class
class BadRequestException extends IOException {
    public BadRequestException(String message) {
        super(message);
    }
}