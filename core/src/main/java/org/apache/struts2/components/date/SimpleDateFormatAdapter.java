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
package org.apache.struts2.components.date;

import com.opensymphony.xwork2.ActionContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import edu.ucr.cs.riple.taint.ucrtainting.qual.RUntainted;

public class SimpleDateFormatAdapter implements DateFormatter {

    @Override
    public String format(TemporalAccessor temporal, String format) {
        DateFormat df;
        Locale locale = ActionContext.getContext().getLocale();
        if (format == null) {
            df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        } else {
            df = new SimpleDateFormat(format, locale);
        }
        return df.format(new Date(Instant.from(temporal).toEpochMilli()));
    }

}
