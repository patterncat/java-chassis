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

package io.servicecomb.transport.common;

import org.mockito.Mockito;

import io.servicecomb.codec.protobuf.definition.OperationProtobuf;
import io.servicecomb.codec.protobuf.definition.ProtobufManager;
import io.servicecomb.core.Invocation;
import io.servicecomb.core.definition.OperationMeta;
import io.servicecomb.transport.highway.HighwayCodec;
import io.servicecomb.transport.highway.HighwayConfig;
import io.servicecomb.transport.highway.message.RequestHeader;

import io.vertx.core.buffer.Buffer;
import mockit.Mock;
import mockit.MockUp;

public class MockUtil {

    private static MockUtil instance = new MockUtil();

    private MockUtil() {

    }

    public static MockUtil getInstance() {
        return instance;
    }

    public void mockHighwayConfig() {

        new MockUp<HighwayConfig>() {
            @Mock
            String getAddress() {
                return "127.0.0.1";
            }

        };
    }

    public RequestHeader requestHeader = new RequestHeader();

    public boolean decodeRequestSucc = true;

    public void mockHighwayCodec() {

        new MockUp<HighwayCodec>() {
            @Mock
            RequestHeader readRequestHeader(Buffer headerBuffer) throws Exception {
                return requestHeader;
            }

            @Mock
            public Invocation decodeRequest(RequestHeader header, OperationProtobuf operationProtobuf,
                    Buffer bodyBuffer) throws Exception {
                if (decodeRequestSucc) {
                    return Mockito.mock(Invocation.class);
                }

                throw new Error("decode failed");
            }
        };
    }

    public void mockProtobufManager() {

        new MockUp<ProtobufManager>() {
            @Mock
            public OperationProtobuf getOrCreateOperation(OperationMeta operationMeta) throws Exception {
                return Mockito.mock(OperationProtobuf.class);
            }

        };
    }
}
