package com.ceriosrey.chattrbox;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020%H\u0002J\"\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020%H\u0016J\u0012\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0012\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020%H\u0014J\u0012\u0010:\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J-\u0010=\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00172\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050?2\u0006\u0010@\u001a\u00020AH\u0016\u00a2\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020%H\u0002J\b\u0010E\u001a\u00020%H\u0002J\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/ceriosrey/chattrbox/AddItemActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Landroid/media/MediaPlayer$OnCompletionListener;", "()V", "audioName", "", "buttonPlaySample", "Landroid/widget/Button;", "buttonRecord", "chooseImageButton", "editTextName", "Landroid/widget/EditText;", "handler", "Landroid/os/Handler;", "imageName", "imageViewAddItem", "Landroid/widget/ImageView;", "internalStorageProvider", "Lcom/ceriosrey/chattrbox/InternalStorageProvider;", "itemId", "player", "Landroid/media/MediaPlayer;", "recordRequestCode", "", "recorder", "Landroid/media/MediaRecorder;", "result", "Lio/realm/RealmResults;", "Lcom/ceriosrey/chattrbox/ChattRItem;", "saved", "", "spinnerCategory", "Landroid/widget/Spinner;", "storageReadCode", "tempFile", "Ljava/io/File;", "chooseImageClicked", "", "getItemCount", "category", "realm", "Lio/realm/Realm;", "getPhoto", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCompletion", "mp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "play", "record", "recordPermissionRequest", "savingImageToInternalStorage", "setupRecordPermission", "stopRecord", "app_debug"})
public final class AddItemActivity extends android.support.v7.app.AppCompatActivity implements android.media.MediaPlayer.OnCompletionListener {
    private final com.ceriosrey.chattrbox.InternalStorageProvider internalStorageProvider = null;
    private android.media.MediaRecorder recorder;
    private android.media.MediaPlayer player;
    private java.io.File tempFile;
    private android.os.Handler handler;
    private android.widget.ImageView imageViewAddItem;
    private final int recordRequestCode = 101;
    private final int storageReadCode = 103;
    private android.widget.Button buttonRecord;
    private android.widget.Button chooseImageButton;
    private android.widget.Button buttonPlaySample;
    private android.widget.EditText editTextName;
    private java.lang.String imageName;
    private java.lang.String audioName;
    private boolean saved;
    private java.lang.String itemId;
    private io.realm.RealmResults<com.ceriosrey.chattrbox.ChattRItem> result;
    private android.widget.Spinner spinnerCategory;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecordPermission() {
    }
    
    private final void recordPermissionRequest() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void getPhoto() {
    }
    
    private final void chooseImageClicked() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void getItemCount(java.lang.String category, io.realm.Realm realm) {
    }
    
    private final void record() {
    }
    
    private final void stopRecord() {
    }
    
    private final void play() {
    }
    
    @java.lang.Override()
    public void onCompletion(@org.jetbrains.annotations.Nullable()
    android.media.MediaPlayer mp) {
    }
    
    private final void savingImageToInternalStorage() {
    }
    
    public AddItemActivity() {
        super();
    }
}