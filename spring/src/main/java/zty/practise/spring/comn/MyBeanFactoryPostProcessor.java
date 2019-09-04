package zty.practise.spring.comn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * beanFactory的后置处理器；在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 * 所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 * 
 * @author zhangtianyi
 *
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
	@Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("可以执行bean的方法，但不会加载bean");
    }
}
