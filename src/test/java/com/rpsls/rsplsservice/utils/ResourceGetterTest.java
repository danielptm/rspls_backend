package com.rpsls.rsplsservice.utils;

import com.rpsls.rsplsservice.service.S3Client;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-context.xml"})
public class ResourceGetterTest {

    @Autowired
    private S3Client s3Client;

    @Ignore
    public void testGetResource() {
        s3Client.getResultsFile();
    }

}
