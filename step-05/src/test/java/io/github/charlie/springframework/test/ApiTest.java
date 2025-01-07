package io.github.charlie.springframework.test;

import cn.hutool.core.io.IoUtil;
import io.github.charlie.springframework.beans.PropertyValue;
import io.github.charlie.springframework.beans.PropertyValues;
import io.github.charlie.springframework.beans.factory.config.BeanDefinition;
import io.github.charlie.springframework.beans.factory.config.BeanReference;
import io.github.charlie.springframework.beans.factory.support.DefaultListableBeanFactory;
import io.github.charlie.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import io.github.charlie.springframework.core.io.DefaultResourceLoader;
import io.github.charlie.springframework.core.io.Resource;
import io.github.charlie.springframework.test.bean.UserDao;
import io.github.charlie.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // int
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // register
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // UserService set uid and userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // reference
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // get bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        Resource resource1 = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream1 = resource1.getInputStream();
        String content1 = IoUtil.readUtf8(inputStream1);
        System.out.println(content1);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // init
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // resolve the xml and register bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // query
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println(s);
    }
}
