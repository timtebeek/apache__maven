package org.apache.maven.integrationtests;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;

public class MavenIT0024Test
    extends AbstractMavenIntegrationTestCase
{

    /**
     * Test usage of &lt;executions/&gt; inside a plugin rather than &lt;goals/&gt;
     * that are directly inside the plugin.
     */
    public void testit0024()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/it0024" );

        Verifier verifier = new Verifier( testDir.getAbsolutePath() );
        verifier.executeGoal( "initialize" );
        verifier.assertFilePresent( "target/plugin-exec-configuration.txt" );
        verifier.verifyErrorFreeLog();
        verifier.resetStreams();
    }

}
