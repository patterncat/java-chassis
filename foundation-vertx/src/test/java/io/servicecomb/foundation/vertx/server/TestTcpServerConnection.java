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
package io.servicecomb.foundation.vertx.server;

import org.junit.Assert;
import org.junit.Test;

import io.vertx.core.net.NetSocket;
import mockit.Mocked;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @version  [版本号, 2017年5月10日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestTcpServerConnection {
    @Test
    public void test(@Mocked NetSocket netSocket) {
        TcpServerConnection connection = new TcpServerConnection();
        connection.setProtocol("p");
        connection.setZipName("z");

        connection.init(netSocket);

        Assert.assertEquals(netSocket, connection.netSocket);
    }
}
