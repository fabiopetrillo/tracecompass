/**********************************************************************
 * Copyright (c) 2017 Ericsson
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 **********************************************************************/

package org.eclipse.tracecompass.tmf.ui.swtbot.tests.views;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.StateItem;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.TimeGraphPresentationProvider;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.model.ITimeEvent;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.model.ITimeEventStyleStrings;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.model.TimeEvent;
import org.eclipse.tracecompass.tmf.ui.widgets.timegraph.model.TimeLinkEvent;

import com.google.common.collect.ImmutableMap;

/**
 * Simple presentation provider to test the time graph widgets
 *
 * @author Matthew Khouzam
 */
class StubPresentationProvider extends TimeGraphPresentationProvider {

    @Override
    public String getPreferenceKey() {
        return "Stub";
    }

    private static final StateItem LASER = new StateItem(
            ImmutableMap.of(
                    ITimeEventStyleStrings.label(), "\"LASER\"",
                    ITimeEventStyleStrings.heightFactor(), 0.1f,
                    ITimeEventStyleStrings.fillColor(), (255 << 24 | 255)));

    /**
     * States, visible since they are tested
     */
    public static final StateItem[] STATES = {
            new StateItem(new RGB(0, 255, 0), "HAT"),
            new StateItem(new RGB(128, 192, 255), "SKIN"),
            new StateItem(new RGB(0, 64, 128), "HAIR"),
            new StateItem(new RGB(0, 0, 255), "EYE"),
            new StateItem(new RGB(255, 64, 128), "PUCK"),
            LASER
    };

    @Override
    public StateItem[] getStateTable() {
        return STATES;
    }

    @Override
    public int getStateTableIndex(ITimeEvent event) {
        if (event instanceof TimeLinkEvent) {
            return 5;
        }

        if (event instanceof TimeEvent) {
            return ((TimeEvent) event).getValue();
        }
        return -1;
    }

}
