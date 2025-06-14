# 保留 Xposed 相关接口和实现类
# -keep class de.robv.android.xposed.** { *; }
-keep class f.a.d.** { *; }

# 保留 IXposedHookLoadPackage 接口的所有实现类
-keep class * implements de.robv.android.xposed.IXposedHookLoadPackage { *; }

# 保留反射调用的类和方法
-keepclassmembers class * {
    public <methods>;
}
