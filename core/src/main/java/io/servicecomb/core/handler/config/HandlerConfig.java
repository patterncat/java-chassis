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

package io.servicecomb.core.handler.config;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.servicecomb.core.Handler;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @version  [版本号, 2016年12月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class HandlerConfig {
    private String handlerId;

    private Class<Handler> clazz;

    /**
     * 获取handlerId的值
     * @return 返回 handlerId
     */
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    public String getHandlerId() {
        return handlerId;
    }

    /**
     * 对handlerId进行赋值
     * @param handlerId handlerId的新值
     */
    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    /**
     * 获取clazz的值
     * @return 返回 clazz
     */
    @JacksonXmlProperty(localName = "class", isAttribute = true)
    public Class<Handler> getClazz() {
        return clazz;
    }

    /**
     * 对clazz进行赋值
     * @param clazz clazz的新值
     */
    public void setClazz(Class<Handler> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    public void setClazz(String clazz) throws ClassNotFoundException {
        this.clazz = (Class<Handler>) Class.forName(clazz);
    }
}
