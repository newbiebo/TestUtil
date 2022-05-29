package org.icu.testutil.factory.impl;

import org.icu.testutil.factory.GetTestBeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class GetTestBeanFactoryImpl implements GetTestBeanFactory, BeanFactoryAware {

    private static BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
    public Object getBeanFactory(String beanName) throws BeansException {

        Object testBean = beanFactory.getBean(beanName);

        return testBean;
    }
}
