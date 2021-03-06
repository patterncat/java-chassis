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
package io.servicecomb.provider.springmvc.reference;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @version  [版本号, 2017年5月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestCseUriTemplateHandler {
    @Test
    public void testCrossApp() {
        CseUriTemplateHandler handler = new CseUriTemplateHandler();
        URI uri = handler.expand("cse://{ap}{p}:ms/{path}?q={query}", "ap", "p", "path", "query");
        Assert.assertEquals("cse://app:ms/path?q=query", uri.toString());

        Map<String, String> vars = new HashMap<>();
        vars.put("app", "app");
        vars.put("path", "path");
        vars.put("q", "query");
        uri = handler.expand("cse://{app}:ms/{path}?q={q}", vars);
        Assert.assertEquals("cse://app:ms/path?q=query", uri.toString());

        uri = handler.expand("cse://ms/{path}?q={query}", "path", "query");
        Assert.assertEquals("cse://ms/path?q=query", uri.toString());
    }
}
