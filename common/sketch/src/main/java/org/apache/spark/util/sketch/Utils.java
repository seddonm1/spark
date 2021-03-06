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

package org.apache.spark.util.sketch;

import java.io.UnsupportedEncodingException;

public class Utils {
  public static byte[] getBytesFromUTF8String(String str) {
    try {
      return str.getBytes("utf-8");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("Only support utf-8 string", e);
    }
  }

  public static long integralToLong(Object i) {
    long longValue;

    if (i instanceof Long) {
      longValue = (Long) i;
    } else if (i instanceof Integer) {
      longValue = ((Integer) i).longValue();
    } else if (i instanceof Short) {
      longValue = ((Short) i).longValue();
    } else if (i instanceof Byte) {
      longValue = ((Byte) i).longValue();
    } else {
      throw new IllegalArgumentException("Unsupported data type " + i.getClass().getName());
    }

    return longValue;
  }
}
