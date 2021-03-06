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

package io.servicecomb.swagger.extend.parameter;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import io.servicecomb.swagger.generator.core.OperationGenerator;
import io.servicecomb.swagger.generator.core.utils.ParamUtils;

import io.swagger.models.ModelImpl;
import io.swagger.models.RefModel;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.PropertyBuilder;
import io.swagger.models.properties.RefProperty;

/**
 * 备选body
 * int test(int x, Set<String> y)
 * 反向生成契约时，x、y都是备选body，最终再合并成body
 * 如果直接使用BodyParamter,会导致y有信息丢失
 *
 *
 * @version  [版本号, 2017年3月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PendingBodyParameter extends BodyParameter {
    private OperationGenerator operationGenerator;

    private Property property;

    private Type type;

    public void setOperationGenerator(OperationGenerator operationGenerator) {
        this.operationGenerator = operationGenerator;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Method getMethod() {
        return operationGenerator.getProviderMethod();
    }

    public BodyParameter createBodyParameter(String paramName) {
        String modelType = ParamUtils.generateBodyParameterName(operationGenerator.getProviderMethod());
        RefModel model = toRefModel(modelType);

        BodyParameter bodyParameter = new BodyParameter();
        bodyParameter.setName(paramName);
        bodyParameter.setSchema(model);

        return bodyParameter;
    }

    // swagger中的body只能是ref，不能是简单类型
    private RefModel toRefModel(String modelType) {
        if (RefProperty.class.isInstance(property)) {
            return (RefModel) PropertyBuilder.toModel(property);
        }

        ModelImpl modelImpl = new ModelImpl();
        modelImpl.setType("object");
        modelImpl.setName(name);
        modelImpl.addProperty(name, property);

        operationGenerator.getSwagger().addDefinition(modelType, modelImpl);

        RefModel refModel = new RefModel();
        refModel.setReference("#/definitions/" + modelType);

        return refModel;
    }
}
