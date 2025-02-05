/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.dao.utils;

import org.apache.dolphinscheduler.common.constants.Constants;
import org.apache.dolphinscheduler.dao.entity.WorkerGroup;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class WorkerGroupUtils {

    private static final String DEFAULT_WORKER_GROUP = "default";

    /**
     * Check if the worker group is empty, if the worker group is default, it is considered empty
     */
    public static boolean isWorkerGroupEmpty(String workerGroup) {
        return StringUtils.isEmpty(workerGroup) || getDefaultWorkerGroup().equals(workerGroup);
    }

    public static String getWorkerGroupOrDefault(String workerGroup) {
        return getWorkerGroupOrDefault(workerGroup, getDefaultWorkerGroup());
    }

    public static String getWorkerGroupOrDefault(String workerGroup, String defaultWorkerGroup) {
        return isWorkerGroupEmpty(workerGroup) ? defaultWorkerGroup : workerGroup;
    }

    public static String getDefaultWorkerGroup() {
        return DEFAULT_WORKER_GROUP;
    }

    public static List<String> getWorkerAddressListFromWorkerGroup(WorkerGroup workerGroup) {
        String addrList = workerGroup.getAddrList();
        if (StringUtils.isEmpty(addrList)) {
            return Collections.emptyList();
        }
        return Lists.newArrayList(addrList.split(Constants.COMMA));
    }

}
