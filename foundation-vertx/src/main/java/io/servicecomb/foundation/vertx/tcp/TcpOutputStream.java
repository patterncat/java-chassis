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

package io.servicecomb.foundation.vertx.tcp;

import io.servicecomb.foundation.vertx.client.tcp.TcpClient;
import io.servicecomb.foundation.vertx.server.TcpParser;
import io.servicecomb.foundation.vertx.stream.BufferOutputStream;

/**
 * TcpOutputStream
 *
 *
 */
public class TcpOutputStream extends BufferOutputStream {
    private long msgId;

    public TcpOutputStream() {
        super();

        msgId = TcpClient.getAndIncRequestId();
        write(TcpParser.TCP_MAGIC);
        writeLong(msgId);
    }

    public TcpOutputStream(long msgId) {
        super();

        this.msgId = msgId;
        write(TcpParser.TCP_MAGIC);
        writeLong(msgId);
    }

    public long getMsgId() {
        return msgId;
    }

    public void writeLength(int totalLen, int headerLen) {
        writeInt(totalLen);
        writeInt(headerLen);
    }
}
