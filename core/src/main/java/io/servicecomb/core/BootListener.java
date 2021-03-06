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

package io.servicecomb.core;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 *
 * @version  [版本号, 2017年4月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface BootListener {
    enum EventType {
        BEFORE_HANDLER,
        AFTER_HANDLER,
        BEFORE_PRODUCER_PROVIDER,
        AFTER_PRODUCER_PROVIDER,
        BEFORE_CONSUMER_PROVIDER,
        AFTER_CONSUMER_PROVIDER,
        BEFORE_TRANSPORT,
        AFTER_TRANSPORT,
        BEFORE_REGISTRY,
        AFTER_REGISTRY
    }

    class BootEvent {
        private EventType eventType;

        public EventType getEventType() {
            return eventType;
        }

        public void setEventType(EventType eventType) {
            this.eventType = eventType;
        }
    }

    void onBootEvent(BootEvent event);
}
