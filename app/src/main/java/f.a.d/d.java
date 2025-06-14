package f.a.d;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class d implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) {
        if (!"android".equals(lpparam.packageName)) {
            return;
        }

        XposedBridge.log("DisablePinVerifyPer72h: android package loaded, start hook");

        try {
            findAndHookMethod(
                    "com.android.server.locksettings.LockSettingsStrongAuth",
                    lpparam.classLoader,
                    "rescheduleStrongAuthTimeoutAlarm",
                    long.class,
                    int.class,
                    XC_MethodReplacement.DO_NOTHING);

            XposedBridge.log("DisablePinVerifyPer72h: Hook succeeded");
        } catch (Throwable t) {
            XposedBridge.log("DisablePinVerifyPer72h: Hook failed: " + t);
        }
    }
}
