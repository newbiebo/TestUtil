package org.icu.testutil.controller;


import org.icu.testutil.dto.ReqDTO;
import org.icu.testutil.factory.GetTestBeanFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;


@org.springframework.stereotype.Controller
@RequestMapping("/common")
public class Controller {

    private GetTestBeanFactory getTestBeanFactory;


    @ResponseBody
    @RequestMapping("/testBeanController")
    public Object xxx(ReqDTO reqDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //调用bean工厂获取bean
        Object testBean = this.getTestBean(reqDTO.getBeanName());
        //返回调用的接口的返回值
        Object invoke = testBean.getClass().getMethod(reqDTO.getMethod(), new Class[]{}).invoke(testBean, new Object());

        return invoke;
    }


    private Object getTestBean(String beanName){

        Object testBean = getTestBeanFactory.getBeanFactory(beanName);

        return testBean;
    }
}
