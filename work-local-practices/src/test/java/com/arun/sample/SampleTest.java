package com.arun.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Sample.class })
public class SampleTest {

    @Mock
    TestA testA;

    @Before
    public void setup() {
    }

    @Test
    public void testPrintName() throws Exception {
        PowerMockito.mockStatic(TestA.class);
        PowerMockito.whenNew(TestA.class).withNoArguments().thenReturn(testA);
        Sample sample = new Sample();
        sample.printName();
    }
}
