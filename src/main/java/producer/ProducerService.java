package producer;

import domain.User;

public interface ProducerService {
    void sendService(String message);
    void sendObjectService(User user);
}
