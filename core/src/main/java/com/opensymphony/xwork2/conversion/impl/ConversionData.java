/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.opensymphony.xwork2.conversion.impl;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

public class ConversionData {
    private Object value;
    private Class toClass;

    public ConversionData() {
    }

    public ConversionData(Object value, Class toClass) {
        super();
        this.value = value;
        this.toClass = toClass;
    }

    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Class getToClass() {
        return toClass;
    }
    public void setToClass(Class toClass) {
        this.toClass = toClass;
    }
}
