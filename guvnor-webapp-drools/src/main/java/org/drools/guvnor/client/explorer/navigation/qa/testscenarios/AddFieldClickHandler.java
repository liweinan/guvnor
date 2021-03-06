/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation.qa.testscenarios;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import org.drools.guvnor.client.common.FormStylePopup;
import org.drools.guvnor.client.messages.Constants;
import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;

abstract class AddFieldClickHandler
        implements SelectionHandler<String>, ClickHandler {

    protected final SuggestionCompletionEngine suggestionCompletionEngine;
    protected final ScenarioParentWidget parent;

    public AddFieldClickHandler(SuggestionCompletionEngine suggestionCompletionEngine,
                                ScenarioParentWidget parent) {
        this.suggestionCompletionEngine = suggestionCompletionEngine;
        this.parent = parent;
    }

    @Override
    public void onClick(ClickEvent event) {
        final FormStylePopup pop = new FormStylePopup();
        pop.setTitle(Constants.INSTANCE.ChooseDotDotDot());

        pop.addAttribute(Constants.INSTANCE.ChooseAFieldToAdd(), createAddNewField(pop));

        pop.show();
    }

    private FactFieldSelector createAddNewField(final FormStylePopup pop) {
        FactFieldSelector factFieldSelector = createFactFieldSelector();

        factFieldSelector.addSelectionHandler(this);
        factFieldSelector.addSelectionHandler(new SelectionHandler<String>() {
            @Override
            public void onSelection(SelectionEvent<String> stringSelectionEvent) {
                pop.hide();
                parent.renderEditor();
            }
        });

        return factFieldSelector;
    }

    protected abstract FactFieldSelector createFactFieldSelector();

}
