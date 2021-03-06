/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.foundation.metrics.performance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @since Mar 14, 2017
 * @see 
 */
public class TestPerfResult {

    PerfResult oPerfResult = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        oPerfResult = new PerfResult();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        oPerfResult = null;
    }

    /**
     * Test Un-Initialized Values
     */
    @Test
    public void testDefaultValues() {
        Assert.assertNull(oPerfResult.getName());
        Assert.assertEquals(0, oPerfResult.getCallCount());
        Assert.assertEquals(0, oPerfResult.getMsAvgLatency(), 0);
        Assert.assertEquals(0, oPerfResult.getAvgCallCount());
        Assert.assertNull(oPerfResult.getMsLatencySegments());
        Assert.assertEquals(0, oPerfResult.getMsgCount());

    }

    /**
     * Test the values after Initialization
     */
    @Test
    public void testIntializedValues() {
        initializeObject(); //Initialize the object.
        Assert.assertEquals("testPerf", oPerfResult.getName());
        Assert.assertEquals(1, oPerfResult.getCallCount());
        Assert.assertEquals(56, oPerfResult.getMsAvgLatency(), 0);
        Assert.assertEquals(2, oPerfResult.getAvgCallCount());
        Assert.assertEquals(2, oPerfResult.getMsLatencySegments().length);
        Assert.assertEquals(10, oPerfResult.getMsgCount());
        Assert.assertEquals("testStringtestString", oPerfResult.segmentsToString("testString"));

    }

    /**
     * Initialize the values for the object
     */
    private void initializeObject() {
        long[] oLongLatencySegment = new long[] {123, 154};
        oPerfResult.setAvgCallCount(2);
        oPerfResult.setCallCount(1);
        oPerfResult.setMsAvgLatency(56);
        oPerfResult.setMsgCount(10);
        oPerfResult.setName("testPerf");
        oPerfResult.setMsLatencySegments(oLongLatencySegment);

    }

}
