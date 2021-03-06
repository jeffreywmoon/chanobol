package anabolicandroids.chanobol.ui.scaffolding;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;

import java.io.File;

import anabolicandroids.chanobol.ui.threads.ThreadSortOrder;

// Convenience wrapper around SharedPreferences to make use of Java's static nature
@SuppressWarnings("UnusedDeclaration")
public class Prefs {

    private final SharedPreferences p;

    public Prefs(SharedPreferences sharedPrefs) {
        this.p = sharedPrefs;
    }

    public static final String THEME = "pref_theme";
    public Theme theme() {
        String name = p.getString("pref_theme", Theme.LIGHT.name);
        if (name.equals(Theme.LIGHT.name)) return Theme.LIGHT;
        if (name.equals(Theme.DARK.name)) return Theme.DARK;
        if (name.equals(Theme.TEAL.name)) return Theme.TEAL;
        if (name.equals(Theme.BLUE1.name)) return Theme.BLUE1;
        if (name.equals(Theme.BLUE2.name)) return Theme.BLUE2;
        if (name.equals(Theme.GRAY.name)) return Theme.GRAY;
        return Theme.LIGHT;
    }
    public void theme(Theme theme) {
        p.edit().putString(THEME, theme.name).apply();
    }

    public static final String HIDABLE_TOOLBAR = "pref_hidable_toolbar";
    public boolean hidableToolbar() {
        return p.getBoolean(HIDABLE_TOOLBAR, true);
    }
    public void hidableToolbar(boolean v) {
        p.edit().putBoolean(HIDABLE_TOOLBAR, v).apply();
    }

    public static final String PRELOAD_THUMBNAILS = "pref_preload_thumbnails";
    public boolean preloadThumbnails() {
        return p.getBoolean(PRELOAD_THUMBNAILS, true);
    }
    public void preloadThumbnails(boolean v) {
        p.edit().putBoolean(PRELOAD_THUMBNAILS, v).apply();
    }

    public static final String ONLY_THUMBNAILS = "pref_only_thumbnails_postlist";
    public boolean onlyThumbnailsInPostlist() {
        return p.getBoolean(ONLY_THUMBNAILS, false);
    }
    public void onlyThumbnailsInPostlist(boolean v) {
        p.edit().putBoolean(ONLY_THUMBNAILS, v).apply();
    }

    public static final String VOLUME_SCROLLING = "pref_volume_scrolling";
    public boolean volumeScrolling() {
        return p.getBoolean(VOLUME_SCROLLING, false);
    }
    public void volumeScrolling(boolean v) {
        p.edit().putBoolean(VOLUME_SCROLLING, v).apply();
    }

    public static final String AUTO_REFRESH = "pref_refresh";
    public boolean autoRefresh() {
        return p.getBoolean(AUTO_REFRESH, true);
    }
    public void autoRefresh(boolean v) {
        p.edit().putBoolean(AUTO_REFRESH, v).apply();
    }

    public static final String IMAGE_DIR = "pref_image_dir";
    public File imageDir() {
        String path = p.getString(IMAGE_DIR, null);
        if (path == null) return new File(Environment.getExternalStorageDirectory() + File.separator + "Chanobol");
        else return new File(path);
    }
    public void imageDir(String dir) {
        p.edit().putString(IMAGE_DIR, dir).apply();
    }


    public static final String THREAD_SORT_ORDER = "pref_thread_sort_order";
    public ThreadSortOrder threadSortOrder() {
        String s = p.getString(THREAD_SORT_ORDER, ThreadSortOrder.Bump.string);
        if (s.equals(ThreadSortOrder.Bump.string)) return ThreadSortOrder.Bump;
        if (s.equals(ThreadSortOrder.Replies.string)) return ThreadSortOrder.Replies;
        if (s.equals(ThreadSortOrder.Images.string)) return ThreadSortOrder.Images;
        if (s.equals(ThreadSortOrder.Date.string)) return ThreadSortOrder.Date;
        return ThreadSortOrder.Bump;
    }
    public void threadSortOrder(ThreadSortOrder order) {
        p.edit().putString(THREAD_SORT_ORDER, order.string).apply();
    }

    public static final String EXTERNAL_WEBM = "pref_external_webm";
    public boolean externalWebm() {
        if (Build.VERSION.SDK_INT < 15) return true;
        return p.getBoolean(EXTERNAL_WEBM, false);
    }
    public void externalWebm(boolean v) {
        p.edit().putBoolean(EXTERNAL_WEBM, v).apply();
    }

    public static final String IMMERSIVE_MODE = "pref_immersive_mode";
    public boolean immersiveMode() {
        if (Build.VERSION.SDK_INT < 19) return false;
        return p.getBoolean(IMMERSIVE_MODE, false);
    }
    public void immersiveMode(boolean v) {
        p.edit().putBoolean(IMMERSIVE_MODE, v).apply();
    }

    public static final String WATCHTASK_RECENTS = "pref_watchtask_recents";
    public boolean excludeWatchtaskRecents() {
        return p.getBoolean(WATCHTASK_RECENTS, true);
    }
    public void excludeWatchtaskRecents(boolean v) {
        p.edit().putBoolean(WATCHTASK_RECENTS, v).apply();
    }

}
