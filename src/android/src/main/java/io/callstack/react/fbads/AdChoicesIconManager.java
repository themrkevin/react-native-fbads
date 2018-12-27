/**
 * This is custom implementation of AdChoicesIcon
 *
 * Background:
 * We use `react-native-fbads` for showing FAN ads, however, not the latest version that includes AdChoicesIcon out-of-the-box.
 * Commit hash we use: https://github.com/callstack/react-native-fbads.git#65271661f1d9b9bdcd7f5ae0a4779b9a251b62dc
 * The reason being the latest version has known bug where ads appear blurred and unusable.
 *
 * TODO: When that's fixed, remove this and use latest version of lib
 * Issue tracker: https://github.com/callstack/react-native-fbads/issues/132
 */
package io.callstack.react.fbads;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class AdChoicesIconManager extends SimpleViewManager<AdChoicesIconView> {
    private static final String PACKAGE_NAME = "AdChoicesIcon";
    private static final String PROP_PLACEMENT_ID = "placementId";

    public AdChoicesIconManager(ReactContext context) {
        super();
    }

    @Override
    public String getName() {
        return PACKAGE_NAME;
    }

    @Override
    protected AdChoicesIconView createViewInstance(ThemedReactContext reactContext) {
        return new AdChoicesIconView(reactContext);
    }

    @ReactProp(name = PROP_PLACEMENT_ID)
    public void setPropPlacementId(final AdChoicesIconView view, final String placementId) {
        view.setPlacementId(placementId);
    }
}
