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

package io.servicecomb.swagger.invocation.arguments.consumer;

import io.servicecomb.swagger.extend.parameter.SwaggerInvocationContextParameter;
import io.servicecomb.swagger.invocation.arguments.ArgumentMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.servicecomb.swagger.invocation.arguments.ContextArgumentMapperFactory;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 *
 * @version  [版本号, 2017年4月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
@Qualifier("consumer")
public class ConsumerInvocationContextMapperFactory implements ContextArgumentMapperFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getContextClass() {
        return SwaggerInvocationContextParameter.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArgumentMapper create(int consumerArgIdx) {
        return new ConsumerInvocationContextMapper(consumerArgIdx);
    }
}
