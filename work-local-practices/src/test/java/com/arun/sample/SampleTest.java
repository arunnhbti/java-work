package com.arun.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.mockito.MockitoExtension;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Sample.class })
@ExtendWith({ MockitoExtension.class })
class SampleTest {

    @Mock
    TestA testA;

    @BeforeEach
    void init() {
    }

    @Test
    // void testPrintName(@Mock TestA testA) throws Exception {
    void testPrintName() throws Exception {
        PowerMockito.mockStatic(TestA.class);
        PowerMockito.whenNew(TestA.class).withNoArguments().thenReturn(testA);
        Sample sample = new Sample();
        sample.printName();
    }
}
