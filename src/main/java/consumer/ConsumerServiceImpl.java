package consumer;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.*;

public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name = "destinationQueue")
    Destination destination;
    public String getMessage() {
        Message message = jmsTemplate.receive(destination);
        String msg = null;
        try {
            if (message.getJMSType().equals("")){
                msg=((TextMessage)message).getText();

            }else if (message.getJMSType().equals("")){
                msg= ((User)((ObjectMessage)message).getObject()).toString();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return msg.toString();
    }
}
