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
package org.apache.struts2.action;

import java.util.Map;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

/**
 * Actions that want access to the user's HTTP session attributes should implement this interface.
 *
 * This will give them access to a Map where they can put objects that can be made available
 * to subsequent requests.
 *
 * Typical uses may be cached user data such as name, or a shopping cart.
 */
public interface SessionAware {

    /**
     * Applies the Map of session attributes in the implementing class.
     *
     * @param session a Map of HTTP session attribute name/value pairs.
     */
    void withSession(Map<String, Object> session);

}
