package producer;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    Destination destination;

    @Resource(name = "topicDestination")
    Destination destination2;

    
    public void sendService(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("message = [" + textMessage.getText() + "]");
                return textMessage;
            }
        });

        jmsTemplate.send(destination2, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("message2 = [" + textMessage.getText() + "]");
                return textMessage;
            }
        });
        System.out.println("send message: " + message);

    }

    public void sendObjectService(final User user) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(user);
                System.out.println("message = [" + objectMessage.toString() + "]");
                return objectMessage;
            }
        });
    }
}
