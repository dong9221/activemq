package producer;

import domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerTest{
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService producerService = context.getBean(ProducerService.class);
        int num = 0;
        while(num<1000000){
            producerService.sendService("msg : "+num++);
            User user = new User();
            user.setAge(22+num);
            user.setName("Jonh "+num);
            user.setSex(1);
            producerService.sendObjectService(user);
            Thread.sleep(500);
        }

        //context.close();
    }
}
