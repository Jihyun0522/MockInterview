import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class PermissionRequester {

    public static final int NOT_SUPPORT_VERSION = 2;
    public static final int ALREADY_GRANTED = -1;
    public static final int REQUEST_PERMISSION = 0;

    private Activity context;
    private Uri.Builder builder;

    private void setBuilder(Uri.Builder builder){
        this.builder = builder;
    }

    private PermissionRequester(Activity context){
        this.context = context;
    }
}