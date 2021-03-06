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

package io.servicecomb.common.rest.codec;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @version  [版本号, 2017年1月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public final class RestObjectMapper extends ObjectMapper {
    public static final RestObjectMapper INSTANCE = new RestObjectMapper();

    private static final long serialVersionUID = -8158869347066287575L;

    private static final JavaType STRING_JAVA_TYPE = TypeFactory.defaultInstance().constructType(String.class);

    private RestObjectMapper() {
        // swagger中要求date使用ISO8601格式传递，这里与之做了功能绑定，这在cse中是没有问题的
        setDateFormat(new ISO8601DateFormat());
    }

    public String convertToString(Object value) throws Exception {
        return convertValue(value, STRING_JAVA_TYPE);
    }
}
