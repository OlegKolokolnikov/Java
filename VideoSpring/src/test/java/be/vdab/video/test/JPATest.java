package be.vdab.video.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// enkele imports ...
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/conf/springDAO.xml") 
public class JPATest {
@Test
public void test() { 
}
}