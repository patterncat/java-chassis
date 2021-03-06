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

package io.servicecomb.codec.protobuf.definition;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;
import io.servicecomb.core.definition.OperationMeta;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @version  [版本号, 2016年12月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public final class ProtobufManager {
    private static ProtobufManager instance = new ProtobufManager();

    private static ProtobufMapper mapper = new ProtobufMapper();

    private static ObjectWriter writer = mapper.writer();

    private static ObjectReader reader = mapper.reader();

    public static final String EXT_ID = "protobuf";

    private static final Object LOCK = new Object();

    static {
        // 支持在idl中定义empty message
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    private ProtobufManager() {
    }

    public static OperationProtobuf getOrCreateOperation(OperationMeta operationMeta) throws Exception {
        OperationProtobuf operationProtobuf = operationMeta.getExtData(ProtobufManager.EXT_ID);
        if (operationProtobuf == null) {
            synchronized (LOCK) {
                operationProtobuf = operationMeta.getExtData(ProtobufManager.EXT_ID);
                if (operationProtobuf == null) {
                    operationProtobuf = new OperationProtobuf(operationMeta);
                    operationMeta.putExtData(EXT_ID, operationProtobuf);
                }
            }
        }

        return operationProtobuf;
    }

    public static ProtobufManager getInstance() {
        return instance;
    }

    public static ProtobufMapper getMapper() {
        return mapper;
    }

    public static ObjectWriter getWriter() {
        return writer;
    }

    public static ObjectReader getReader() {
        return reader;
    }
}
