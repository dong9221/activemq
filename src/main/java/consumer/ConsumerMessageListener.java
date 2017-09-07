package consumer;

import domain.User;

import javax.jms.*;

public class ConsumerMessageListener implements MessageListener {
    public void onMessage(Message message) {
        String msg = null;
        try {
            if (message.getClass().toString().indexOf("ActiveMQTextMessage")>-1){
                msg=((TextMessage)message).getText();

            }else if (message.getClass().toString().indexOf("ActiveMQObjectMessage")>-1){
                msg= ((User)((ObjectMessage)message).getObject()).toString();
            }
            System.out.println("get Meaagae :"+msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
