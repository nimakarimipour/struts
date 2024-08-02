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
package org.apache.struts2.dispatcher.listener;

import org.apache.struts2.dispatcher.HostConfig;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.Iterator;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

/**
 * Host configuration that just holds a ServletContext
 */
public class ListenerHostConfig implements HostConfig {
    private @RUntainted ServletContext servletContext;

    public ListenerHostConfig(@RUntainted ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public @RUntainted String getInitParameter(String key) {
        return null;
    }

    public Iterator<@RUntainted String> getInitParameterNames() {
        return Collections.<@RUntainted String>emptyList().iterator();
    }

    public @RUntainted ServletContext getServletContext() {
        return servletContext;  
    }
}
