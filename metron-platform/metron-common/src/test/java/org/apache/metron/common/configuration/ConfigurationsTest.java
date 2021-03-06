/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.metron.common.configuration;

import junit.framework.Assert;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.apache.metron.common.configuration.Configurations;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationsTest {

  @Test
  public void test() throws IOException {
    EqualsVerifier.forClass(Configurations.class).suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS).usingGetClass().verify();
    Configurations configurations = new Configurations();
    try {
      configurations.updateConfig("someConfig", (byte[]) null);
      Assert.fail("Updating a config with null should throw an IllegalStateException");
    } catch(IllegalStateException e) {}
    Assert.assertTrue(configurations.toString() != null && configurations.toString().length() > 0);
  }
}
