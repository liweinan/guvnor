/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation;

import com.google.gwt.place.shared.Place;
import org.drools.guvnor.client.rpc.PackageConfigData;

public class ModuleFormatsGrid extends Place {

    private String[] formats;
    private PackageConfigData packageConfig;
    private String title;

    public ModuleFormatsGrid( PackageConfigData packageConfig,
                              String title,
                              String[] formats ) {
        this.packageConfig = packageConfig;
        this.title = title;
        this.formats = formats;
    }

    public ModuleFormatsGrid( PackageConfigData packageConfig,
                              String title ) {
        this.packageConfig = packageConfig;
        this.title = title;
    }
    
    public String[] getFormats() {
        return formats;
    }

    public PackageConfigData getPackageConfigData() {
        return packageConfig;
    }

    public String getTitle() {
        return title;
    }
}
