package com.rpsls.rsplsservice.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-context.xml"})
public class ResourceGetterTest {

    @Test
    public void testGetResource() {
        Assert.assertTrue(ResourceGetter.getFile("choices/choices.json").length() > 0);
    }

    @Test
    public void test() {
        System.out.println(ResourceGetter.getFile("choices/choices.json").length());
    }
}
