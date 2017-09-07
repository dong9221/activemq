package consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        //ConsumerService consumerService = context.getBean(ConsumerService.class);

        //String msg = consumerService.getMessage();
        //System.out.println("received:"+msg);
    }
}
