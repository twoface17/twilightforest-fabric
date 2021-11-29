package twilightforest.lib.util;

import com.mojang.math.Vector3f;

public class VecUtil {
    public static void setX(Vector3f vector3f, float x) {
        vector3f.set(x, vector3f.y(), vector3f.z());
    }
    public static void setY(Vector3f vector3f, float y) {
        vector3f.set(vector3f.x(), y, vector3f.z());
    }
    public static void setZ(Vector3f vector3f, float z) {
        vector3f.set(vector3f.x(), vector3f.y(), z);
    }
}
