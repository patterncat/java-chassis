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

package io.servicecomb.swagger.generator.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 *
 * @version  [版本号, 2017年3月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Path(value = "Echo")
public class Echo {
    @ApiResponse(response = int.class, code = 200, message = "")
    public Response response() {
        return null;
    }

    public Response invalidResponse() {
        return null;
    }

    @Produces("")
    @Consumes("")
    @ApiOperation(value = "")
    public void emptyPath() {

    }

    @Path(value = "echo/{targetName}")
    @Consumes(value = {"json", "xml"})
    @Produces(value = {"json", "xml"})
    @POST
    public String echo(User srcUser, @HeaderParam(value = "header") String header,
            @PathParam(value = "targetName") String targetName,
            @QueryParam(value = "word") String word) {
        return String.format("%s %s %s %s", srcUser.name, header, targetName, word);
    }

    @Path(value = "cookie")
    @POST
    public String cookie(@CookieParam(value = "cookie") String cookie) {
        return String.format("%s", cookie);
    }

    @Path(value = "form")
    @POST
    public String form(@FormParam(value = "form") String form) {
        return String.format("%s", form);
    }

    @Path(value = "query")
    @GET
    public String query(@QueryParam(value = "query") String query) {
        return String.format("%s", query);
    }

    @Path(value = "query")
    @GET
    public String queryComplex(@QueryParam(value = "querys") List<User> querys) {
        return String.format("%s", querys);
    }
}
