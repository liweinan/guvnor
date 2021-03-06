/*
 * Copyright 2011 JBoss Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.drools.guvnor.server.configurations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class ApplicationPreferencesLoaderTest {

    @Test
    @Ignore("This test relies upon a resource in guvnor-server-drools")
    public void testLoad() throws Exception {
        Map<String, String> preferences = ApplicationPreferencesLoader.load();

        assertNotNull( preferences );
        assertEquals( 14,
                      preferences.size() );
        assertTrue( preferences.containsKey( "visual-ruleflow" ) );
        assertTrue( preferences.containsKey( "verifier" ) );
        assertTrue( preferences.containsKey( "asset.format.enabled.formdef" ) );
        assertEquals( "true",
                      preferences.get( "verifier" ) );
        assertEquals( "true",
                      preferences.get( "oryx-bpmn-editor" ) );
        assertEquals( "false",
                      preferences.get( "asset.format.enabled.formdef" ) );
        assertEquals( "false",
                      preferences.get( "rule-modeller-onlyShowDSLStatements" ) );
    }

}
