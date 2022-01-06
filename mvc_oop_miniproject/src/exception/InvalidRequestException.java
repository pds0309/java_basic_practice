package game.exception;

public class InvalidRequestException extends Exception {

  public InvalidRequestException() {};

  public InvalidRequestException(String msg) {
    super(msg);
  }
}
